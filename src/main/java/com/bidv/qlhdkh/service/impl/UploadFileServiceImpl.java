package com.bidv.qlhdkh.service.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.model.FileModel;
import com.bidv.qlhdkh.model.LstDocument;
import com.bidv.qlhdkh.repository.DocumentRepository;
import com.bidv.qlhdkh.repository.InfoFileUploadRepository;
import com.bidv.qlhdkh.service.UploadFileService;
import com.filenet.api.collection.ContentElementList;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.ClassNames;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;

import filenetP8.FileNetObject;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private static final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
    @Autowired
    Constants constants;
    @Autowired
    InfoFileUploadRepository infoFileUploadRepository;
    @Autowired
    DocumentRepository documentRepository;

    @Override
    @Transactional
    public void createDocument(LstDocument lstDocument, int caseId) throws Exception {
        log.info("Start upload file BIDV");
        ObjectStore objectStore = getObjectStore();
        Folder folder = Factory.Folder.getInstance(objectStore, ClassNames.FOLDER, constants.getPathUpload());
        Folder currentFolder = Factory.Folder.fetchInstance(objectStore, constants.getPathUpload(), null);
        log.info(currentFolder.get_FolderName());
        try {
            if (lstDocument.getDocModel().size() > 0) {
                List<com.bidv.qlhdkh.entity.Document> documents = documentRepository.getLstDoc(caseId);
                if (documents.size() > 0) {
                    documentRepository.deleteAll(documents);
                    createNewDoc(lstDocument, caseId, objectStore, folder, currentFolder);
                } else {
                    createNewDoc(lstDocument, caseId, objectStore, folder, currentFolder);
                }
            }
            log.info("End upload file BIDV");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

    private void createNewDoc(LstDocument lstDocument, int caseId, ObjectStore objectStore, Folder folder, Folder currentFolder) throws Exception {
        for (FileModel fileModel : lstDocument.getDocModel()) {
            FileModel infoFileUpload = createDocumentWithContent(folder, objectStore, fileModel.getContentURL());
            if (infoFileUpload != null) {
                com.bidv.qlhdkh.entity.Document document = new com.bidv.qlhdkh.entity.Document();
                document.setCaseId(caseId);
                document.setDocId(infoFileUpload.getDocId());
                document.setDocName(infoFileUpload.getFileName());
                document.setFileName(currentFolder.get_FolderName());
                document.setObjectId(fileModel.getObjectId());
                document.setServerName(fileModel.getServerName());
                document.setUrl(fileModel.getContentURL());
                document.setMimeType(infoFileUpload.getMimeType());
                List<com.bidv.qlhdkh.entity.Document> optionalDocument = infoFileUploadRepository.getDoc(fileModel.getObjectId());
                if (optionalDocument.size() > 0) {
                    infoFileUploadRepository.deleteAll(optionalDocument);
                    infoFileUploadRepository.save(document);
                } else {
                    infoFileUploadRepository.save(document);
                }
            }
        }
    }

    @Override
    public LstDocument getListDoc(int caseId) {
        LstDocument lstDocument = new LstDocument();
        try {
            log.info("Start find Info Document");
            List<com.bidv.qlhdkh.entity.Document> documents = documentRepository.getLstDoc(caseId);
            for (com.bidv.qlhdkh.entity.Document document : documents) {
                FileModel fileModel = new FileModel();
                fileModel.setDocName(document.getDocName());
                fileModel.setFileName(document.getFileName());
                fileModel.setCaseId(document.getCaseId());
                fileModel.setContentURL(document.getUrl());
                fileModel.setObjectId(document.getObjectId());
                fileModel.setServerName(document.getServerName());
                fileModel.setDocId(document.getDocId());
                fileModel.setMimeType(document.getMimeType());
                lstDocument.addDocModelItem(fileModel);
            }
            log.info("End find Info Document");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error find Info Document");
        }
        return lstDocument;
    }


    public ObjectStore getObjectStore() throws Exception {
        ObjectStore os = null;
        try {
            FileNetObject fileNetObject = new FileNetObject(constants.getUri(), constants.getOsName(), null, constants.getStanza(), constants.getUser(), constants.getPass(), null);
            os = fileNetObject.getObjectStoreInstance();
            return os;
        } catch (Exception e) {
            e.printStackTrace();
            return os;
        }
    }

    @Transactional
    public FileModel createDocumentWithContent(Folder folder, ObjectStore os, String urlPath) throws Exception {
        try {
            FileModel fileModel = new FileModel();
            URLConnection connection = getFileInputStream(urlPath);
            InputStream inputStream = connection.getInputStream();
            log.info("contentType: " + connection.getContentType());
            log.info(connection.getHeaderField("Content-Disposition"));
            String result = java.net.URLDecoder.decode(connection.getHeaderField("Content-Disposition"), StandardCharsets.UTF_8.name()).replace("inline; filename*=UTF-8''", "");
            log.info("fileName: " + result);
            Document doc = Factory.Document.createInstance(os, ClassNames.DOCUMENT);
            ContentTransfer contentTransfer = Factory.ContentTransfer.createInstance();
            ContentElementList contentElementList = Factory.ContentElement.createList();
            contentTransfer.setCaptureSource(inputStream);
            contentElementList.add(contentTransfer);
            doc.set_ContentElements(contentElementList);
            contentTransfer.set_RetrievalName(result);
            contentTransfer.set_ContentType(connection.getContentType());
            doc.set_MimeType(connection.getContentType());
            doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
            doc.save(RefreshMode.REFRESH);
            ReferentialContainmentRelationship rc = folder.file(doc, AutoUniqueName.AUTO_UNIQUE,
                    null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
            rc.save(RefreshMode.REFRESH);
            fileModel.setDocId(doc.get_Id().toString());
            fileModel.setMimeType(connection.getContentType());
            fileModel.setDocName(doc.get_Name());
            fileModel.setFileName(result);
            return fileModel;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public URLConnection getFileInputStream(String urlPath) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            URL url = new URL(urlPath);
            String userpass = constants.getUserLogin() + ":" + constants.getPassLogin();
            String basicAuth = "Basic :" + new String(Base64.getEncoder().encode(userpass.getBytes()));
            log.info("BasicAu: " + basicAuth);
            URLConnection con = url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", basicAuth);
            String urlParameters = "j_username=" + constants.getUserLogin() + "&j_password=" + constants.getPassLogin() + "&save=Log In";
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            URL urls = new URL(constants.getLinkCookie());
            URLConnection cons = urls.openConnection();
            HttpURLConnection http = (HttpURLConnection) cons;
            http.setInstanceFollowRedirects(false);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setRequestProperty("Cookie", "WASReqURL=" + urlPath + "; JSESSIONID=0000pACzJ0uof5lnGxMskzZyotG:1f7qavksd; com_ibm_bpm_process_portal_hash=null");
            http.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            http.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(http.getOutputStream())) {
                wr.write(postData);
            }
            log.info(http.getHeaderField("Set-Cookie").split(";")[0]);
            con.setRequestProperty("Cookie", http.getHeaderField("Set-Cookie").split(";")[0]);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
