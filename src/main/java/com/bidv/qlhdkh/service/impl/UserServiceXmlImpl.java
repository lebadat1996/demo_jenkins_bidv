package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.model.*;
import com.bidv.qlhdkh.service.UserServiceXml;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
public class UserServiceXmlImpl implements UserServiceXml {
    @Autowired
    Constants constants;

    @Override
    public InfoUser getUserInfo(String email, String codeApp) throws IOException {
        String output = "";
        String environment = constants.getEnvironment();
        String responseString = "";
        InfoUser infoUser = new InfoUser();
        if (environment.equals("TEST")) {
            output = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                    + "   <soapenv:Body>"
                    + "      <NS1:submitResponse xmlns:NS1=\"http://UserMan\">"
                    + "         <submitReturn>"
                    + "            <DOC>"
                    + "               <XML>"
                    + "                  <LIST>"
                    + StringEscapeUtils.escapeXml(getDataUser(email, codeApp))
                    + "</LIST>"
                    + "               </XML>"
                    + "            </DOC>"
                    + "         </submitReturn>"
                    + "      </NS1:submitResponse>"
                    + "   </soapenv:Body>"
                    + "</soapenv:Envelope>";
        } else {
            HttpURLConnection connection;
            URL url = new URL(constants.getWebEndpoint());
            connection = (HttpURLConnection) url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            String strRequest = enCodeXML(email, codeApp);
            String xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tns0=\"http://UserMan\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                    + "<soapenv:Header />"
                    + "<soapenv:Body>"
                    + "<tns0:submit>"
                    + "<request>"
                    + strRequest
                    + "</request>"
                    + "</tns0:submit>"
                    + "</soapenv:Body>"
                    + "</soapenv:Envelope>";
            byte[] msgByte = xmlInput.getBytes(StandardCharsets.UTF_8);
            httpConn.setRequestProperty("Content-Length",
                    String.valueOf(msgByte.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            //httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            out.write(msgByte);
            out.close();
            InputStreamReader isr = new InputStreamReader(
                    httpConn.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader in = new BufferedReader(isr);
            while ((responseString = in.readLine()) != null) {
                output = output + responseString;
            }
        }
        org.w3c.dom.Document doc = parseXmlToDoc(output);
        NodeList nodeDocument = ((org.w3c.dom.Document) doc)
                .getElementsByTagName("submitReturn");
        String decodeContent = StringEscapeUtils.unescapeXml(nodeDocument.item(0).getTextContent());
        if (decodeContent.isEmpty()) {
            return infoUser;
        }
        Document document = parseXmlToDoc(decodeContent);
        NodeList userinfo = ((org.w3c.dom.Document) document)
                .getElementsByTagName("USERINFO");
        NodeList role = ((org.w3c.dom.Document) document)
                .getElementsByTagName("ROLEINFO");
        NodeList nodeListFunc = ((org.w3c.dom.Document) document)
                .getElementsByTagName("LIST");
        UserInfoModel userInfoModelList = new UserInfoModel();
        LstRoleInfo lstRoleInfo = new LstRoleInfo();
        LstFunctionModel lstFunctionModel = new LstFunctionModel();
        getUserInfo(userinfo, userInfoModelList);
        getRoleInfo(role, lstRoleInfo);
        getFunctionLst(nodeListFunc, lstFunctionModel);
        infoUser.setLstRoleInfo(lstRoleInfo);
        infoUser.setUserInfoModel(userInfoModelList);
        infoUser.setLstFunctionModel(lstFunctionModel);
        return infoUser;
    }

    public static String getDataUser(String email, String codeApp) {
        return "<DOC>"
                + "<XML>"
                + "<USERINFO>"
                + "<MACB>9040</MACB>"
                + "<FULLNAME>HOÀNG THỊ NGA</FULLNAME>"
                + "<EMAIL>9040@bidv.com.vn</EMAIL>"
                + "<BDS>351</BDS>"
                + "<CRA>698</CRA>"
                + "<QLNSBRN>351</QLNSBRN>"
                + "<BRN>351</BRN>"
                + "<BRANCH>LẠNG SƠN</BRANCH>"
                + "<DEPARTMENT_CODE>BIDV351A404</DEPARTMENT_CODE>"
                + "<DEPARTMENT>P. TCHC</DEPARTMENT>"
                + "</USERINFO>"
                + "<ROLEINFO>"
                + "<ROW>"
                + "<ROLEID>14952</ROLEID>"
                + "<ROLENAME>Thuongtruchoidonghethong</ROLENAME>"
                + "<USRLVL>HO</USRLVL>"
                + "</ROW>"
                + "<ROW>"
                + "<ROLEID>14954</ROLEID>"
                + "<ROLENAME>thuongtruchoidong</ROLENAME>"
                + "<USRLVL>TW</USRLVL>"
                + "</ROW>"
                + "<ROW>"
                + "<ROLEID>14959</ROLEID>"
                + "<ROLENAME>Tacgia</ROLENAME>"
                + "<USRLVL>CN</USRLVL>"
                + "</ROW>"
                + "</ROLEINFO>"
                + "<TELLER/>"
                + "<LIST>"
                + "<ROW>"
                + "<FUNCTION>28105</FUNCTION>"
                + "<FUNCODE>QLHDKH001</FUNCODE>"
                + "<FUNCNAME>Xét duyệt tuyển chọn nhiệm vụ cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>Xet_duyet_cap_co_so</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28105</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Tacgia</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14959</GROUPFUNCID>"
                + "<GRFUNCID>14959</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28105</FUNCTION>"
                + "<FUNCODE>QLHDKH001</FUNCODE>"
                + "<FUNCNAME>Xét duyệt tuyển chọn nhiệm vụ cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>Xet_duyet_cap_co_so</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28105</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>thuongtruchoidong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14954</GROUPFUNCID>"
                + "<GRFUNCID>14954</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28105</FUNCTION>"
                + "<FUNCODE>QLHDKH001</FUNCODE>"
                + "<FUNCNAME>Xét duyệt tuyển chọn nhiệm vụ cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>Xet_duyet_cap_co_so</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28105</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28106</FUNCTION>"
                + "<FUNCODE>QLHDKH002</FUNCODE>"
                + "<FUNCNAME>Xét duyệt tuyển chọn nhiệm vụ cấp hệ thống</FUNCNAME>"
                + "<FUNCLINK>Xet_duyet_cap_he_thong</FUNCLINK>"
                + "<FUNCORDER>5</FUNCORDER>"
                + "<PARENTFUNC>28106</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28106</FUNCTION>"
                + "<FUNCODE>QLHDKH002</FUNCODE>"
                + "<FUNCNAME>Xét duyệt tuyển chọn nhiệm vụ cấp hệ thống</FUNCNAME>"
                + "<FUNCLINK>Xet_duyet_cap_he_thong</FUNCLINK>"
                + "<FUNCORDER>5</FUNCORDER>"
                + "<PARENTFUNC>28106</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Tacgia</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14959</GROUPFUNCID>"
                + "<GRFUNCID>14959</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28107</FUNCTION>"
                + "<FUNCODE>QLHDKH003</FUNCODE>"
                + "<FUNCNAME>Nghiệm thu nhiệm vụ cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>nghiem_thu_cap_co_so</FUNCLINK>"
                + "<FUNCORDER>7</FUNCORDER>"
                + "<PARENTFUNC>28107</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>thuongtruchoidong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14954</GROUPFUNCID>"
                + "<GRFUNCID>14954</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28107</FUNCTION>"
                + "<FUNCODE>QLHDKH003</FUNCODE>"
                + "<FUNCNAME>Nghiệm thu nhiệm vụ cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>nghiem_thu_cap_co_so</FUNCLINK>"
                + "<FUNCORDER>7</FUNCORDER>"
                + "<PARENTFUNC>28107</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28108</FUNCTION>"
                + "<FUNCODE>QLHDKH004</FUNCODE>"
                + "<FUNCNAME>Nghiệm thu nhiệm vụ cấp hệ thống</FUNCNAME>"
                + "<FUNCLINK>nghiem_thu_cap_he_thong</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28108</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28134</FUNCTION>"
                + "<FUNCODE>QLHDKH005</FUNCODE>"
                + "<FUNCNAME>Đề nghi dừng cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dung_coso</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28134</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>thuongtruchoidong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14954</GROUPFUNCID>"
                + "<GRFUNCID>14954</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28134</FUNCTION>"
                + "<FUNCODE>QLHDKH005</FUNCODE>"
                + "<FUNCNAME>Đề nghi dừng cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dung_coso</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28134</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28135</FUNCTION>"
                + "<FUNCODE>QLHDKH006</FUNCODE>"
                + "<FUNCNAME>Đề ghị dừng cấp hệ thống</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dung_hethong</FUNCLINK>"
                + "<FUNCORDER>4</FUNCORDER>"
                + "<PARENTFUNC>28135</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28136</FUNCTION>"
                + "<FUNCODE>QLHDKH007</FUNCODE>"
                + "<FUNCNAME>Đề nghị điều chỉnh cấp hệ thống</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dieu_chinh_hethong</FUNCLINK>"
                + "<FUNCORDER>1</FUNCORDER>"
                + "<PARENTFUNC>28136</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28137</FUNCTION>"
                + "<FUNCODE>QLHDKH008</FUNCODE>"
                + "<FUNCNAME>Đề nghị điều chỉnh cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dieu_chinh_coso</FUNCLINK>"
                + "<FUNCORDER>2</FUNCORDER>"
                + "<PARENTFUNC>28137</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>thuongtruchoidong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14954</GROUPFUNCID>"
                + "<GRFUNCID>14954</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28137</FUNCTION>"
                + "<FUNCODE>QLHDKH008</FUNCODE>"
                + "<FUNCNAME>Đề nghị điều chỉnh cấp cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_dieu_chinh_coso</FUNCLINK>"
                + "<FUNCORDER>2</FUNCORDER>"
                + "<PARENTFUNC>28137</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28138</FUNCTION>"
                + "<FUNCODE>QLHDKH009</FUNCODE>"
                + "<FUNCNAME>Đề nghi công nhận sáng kiến cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_sangkien_coso</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28138</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>thuongtruchoidong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14954</GROUPFUNCID>"
                + "<GRFUNCID>14954</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28138</FUNCTION>"
                + "<FUNCODE>QLHDKH009</FUNCODE>"
                + "<FUNCNAME>Đề nghi công nhận sáng kiến cơ sở</FUNCNAME>"
                + "<FUNCLINK>de_nghi_sangkien_coso</FUNCLINK>"
                + "<FUNCORDER>0</FUNCORDER>"
                + "<PARENTFUNC>28138</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "<ROW>"
                + "<FUNCTION>28139</FUNCTION>"
                + "<FUNCODE>QLHDKH010</FUNCODE>"
                + "<FUNCNAME>Đề nghi công nhận sáng kiến hệ thống</FUNCNAME>"
                + "<FUNCLINK>de_nghi_sangkien_hethong</FUNCLINK>"
                + "<FUNCORDER>6</FUNCORDER>"
                + "<PARENTFUNC>28139</PARENTFUNC>"
                + "<SUBFUNC> </SUBFUNC>"
                + "<GROUPFUNCNAME>Thuongtruchoidonghethong</GROUPFUNCNAME>"
                + "<GROUPFUNCID>14952</GROUPFUNCID>"
                + "<GRFUNCID>14952</GRFUNCID>"
                + "</ROW>"
                + "</LIST>"
                + "</XML>"
                + "</DOC>";
    }

    public static String enCodeXML(String email, String codeApp) {
        String str = "<DOC>"
                + "<XML>"
                + "<MESSAGETYPE>GetUserInfo</MESSAGETYPE>"  //GetBranchRoleInfo
                + "<EMAIL>" + email + "</EMAIL>"
                + "<MAUNGDUNG>" + codeApp + "</MAUNGDUNG>"
                + "</XML>"
                + "</DOC>";
        return StringEscapeUtils.escapeXml(str);
    }

    public static Document parseXmlToDoc(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


    private static void getFunctionLst(NodeList nodeListFunc, LstFunctionModel lstFunctionModel) {
        Node nNode = (Node) nodeListFunc.item(0);
        NodeList nodeListDocument = nNode.getChildNodes();
        for (int j = 0; j < nodeListDocument.getLength(); j++) {
            Element element = (Element) nodeListDocument.item(j);
            FunctionModel functionModel = new FunctionModel();
            functionModel.setFunction(getString("FUNCTION", element));
            functionModel.setFunCode(getString("FUNCODE", element));
            functionModel.setFunName(getString("FUNCNAME", element));
            functionModel.setFunLinnk(getString("FUNCLINK", element));
            functionModel.setFunCorder(getString("FUNCORDER", element));
            functionModel.setParentFunc(getString("PARENTFUNC", element));
            functionModel.setSubFunc(getString("SUBFUNC", element));
            functionModel.setGroupFuncName(getString("GROUPFUNCNAME", element));
            functionModel.setGrFuncId(getString("GROUPFUNCID", element));
            functionModel.setGrFuncId(getString("GRFUNCID", element));
            lstFunctionModel.addRoleInfoItem(functionModel);
        }

    }

    private static void getRoleInfo(NodeList role, LstRoleInfo roleInfoList) {
        Node nNode = (Node) role.item(0);
        NodeList nodeListDocument = nNode.getChildNodes();
        ;
        for (int j = 0; j < nodeListDocument.getLength(); j++) {
            Element element = (Element) nodeListDocument.item(j);
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setRoleId(getString("ROLEID", element));
            roleInfo.setRoleName(getString("ROLENAME", element));
            roleInfo.setUsrlvl(getString("USRLVL", element));
            roleInfoList.addRoleInfoItem(roleInfo);
        }

    }


    private static UserInfoModel getUserInfo(NodeList userinfo, UserInfoModel userInfoModel) {
        for (int i = 0; i < userinfo.getLength(); i++) {
            Element nNode = (Element) userinfo.item(i);
            userInfoModel.codeUser(getString("MACB", nNode));
            userInfoModel.setFullName(getString("FULLNAME", nNode));
            userInfoModel.setEmail(getString("EMAIL", nNode));
            userInfoModel.setBds(getString("BDS", nNode));
            userInfoModel.setCra(getString("CRA", nNode));
            userInfoModel.setBrn(getString("BRN", nNode));
            userInfoModel.setBranch(getString("BRANCH", nNode));
            userInfoModel.setDepartmentCode(getString("DEPARTMENT_CODE", nNode));
            userInfoModel.setDepartment(getString("DEPARTMENT", nNode));
            userInfoModel.setQlnsBrn(getString("QLNSBRN", nNode));
        }
        return userInfoModel;
    }

    public static String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }
        return "";
    }
}
