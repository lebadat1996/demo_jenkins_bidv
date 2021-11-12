package com.bidv.qlhdkh.service.impl;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.model.CadresInforModel;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
public class CallSoapService {
    @Autowired
    Constants constants;


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

    public List<CadresInforModel> callSoap(String bdsid, String depcode, String rolename) throws IOException {
        String wsEndPoint = constants.getWebEndpoint();
        String responseString = "";
        String outputString = "";
        String tagList = "CANBO";
        String submitReturn = "submitReturn";
        String environment = constants.getEnvironment();
        List<CadresInforModel> lstCadres = new ArrayList<>();
        if (environment.equals("TEST")) {
            outputString =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                            + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                            + "   <soapenv:Body>"
                            + "      <NS1:submitResponse xmlns:NS1=\"http://UserMan\">"
                            + "         <submitReturn>"
                            + "            <DOC>"
                            + "               <XML>"
                            + "                  <LIST>"
                            + StringEscapeUtils.escapeXml(getDummyData(rolename, bdsid))
                            + "</LIST>"
                            + "               </XML>"
                            + "            </DOC>"
                            + "         </submitReturn>"
                            + "      </NS1:submitResponse>"
                            + "   </soapenv:Body>"
                            + "</soapenv:Envelope>";
        } else {
            HttpURLConnection connection;
            URL url = new URL(wsEndPoint);
            connection = (HttpURLConnection) url.openConnection();


            HttpURLConnection httpConn = (HttpURLConnection) connection;
            String strRequest = enCodeXML(bdsid, depcode, rolename);
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
                outputString = outputString + responseString;
            }
        }
        org.w3c.dom.Document doc = parseXmlFile(outputString);
        NodeList nodeDocument = ((org.w3c.dom.Document) doc)
                .getElementsByTagName(submitReturn);
        String decodeContent = StringEscapeUtils.unescapeXml(nodeDocument.item(0).getTextContent());
        if (decodeContent.isEmpty()) {
            return lstCadres;
        }
        org.w3c.dom.Document doc1 = parseXmlFile(decodeContent);
        NodeList nodeListDocument = ((org.w3c.dom.Document) doc1)
                .getElementsByTagName(tagList);
        for (int i = 0; i < nodeListDocument.getLength(); i++) {
            Element nNode = (Element) nodeListDocument.item(i);
            CadresInforModel cadres = new CadresInforModel();
            cadres.setFullName(getString("HOTEN", nNode));
            cadres.setUserId(getString("MACB", nNode));
            cadres.setEmail(getString("EMAIL", nNode));
            cadres.setUserName(getString("ACCOUNT", nNode));
            cadres.setGroupXL(getString("ROLECODE", nNode));
            lstCadres.add(cadres);
        }
        return lstCadres;

    }

    public static String enCodeXML(String bdsid, String depcode, String rolename) {
        String str = "<DOC>"
                + "<XML>"
                + "<MESSAGETYPE>GetBranchRoleInfo</MESSAGETYPE>"  //GetBranchRoleInfo
                + "<BDSID>" + bdsid + "</BDSID>"
                + "<DEPCODE>" + depcode + "</DEPCODE>"
                + "<ROLECODE>" + rolename + "</ROLECODE>"
                + "</XML>"
                + "</DOC>";
        return StringEscapeUtils.escapeXml(str);
    }

    public static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDummyData(String role, String branch) {
        if (branch != null) {
            if (branch.equals("149") && role.equals("thuongtruchoidong")) {
                return "<CANBO>"
                        + "<MACB>ID_THHD_CS01</MACB>"
                        + "<HOTEN>FULLNAME_THHD_CS01</HOTEN>"
                        + "<EMAIL>shbtestmail+3@gmail.com</EMAIL>"
                        + "<ACCOUNT>THHD_CS01</ACCOUNT>"
                        + "<ROLECODE>thuongtruchoidong</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("149") && role.equals("chutichhoidong")) {
                return "<CANBO>"
                        + "<MACB>ID_CTHDKHCN_CS01</MACB>"
                        + "<HOTEN>FULLNAME_CTHDKHCN_CS01</HOTEN>"
                        + "<EMAIL>EMAIL_CTHDKHCN_CS01</EMAIL>"
                        + "<ACCOUNT>CTHDKHCN_CS01</ACCOUNT>"
                        + "<ROLECODE>chutichhoidong</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("149") && role.equals("chutichhoidongxetduyet")) {
                return "<CANBO>"
                        + "<MACB>ID_CTHDXD_CS01</MACB>"
                        + "<HOTEN>FULLNAME_CTHDXD_CS01</HOTEN>"
                        + "<EMAIL>EMAIL_CTHDXD_CS01</EMAIL>"
                        + "<ACCOUNT>CTHDXD_CS01</ACCOUNT>"
                        + "<ROLECODE>chutichhoidongxetduyet</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("149") && role.equals("hoidongkhoahoc")) {
                return "<CANBO>"
                        + "<MACB>ID_TVHDXD_CS01</MACB>"
                        + "<HOTEN>FULLNAME_TVHDXD_CS01</HOTEN>"
                        + "<EMAIL>EMAIL_TVHDXD_CS01</EMAIL>"
                        + "<ACCOUNT>TVHDXD_CS01</ACCOUNT>"
                        + "<ROLECODE>hoidongkhoahoc</ROLECODE>"
                        + "</CANBO>"
                        ;
            }


            if (branch.equals("149") && role.equals("tacgia")) {
                return "<EMPLOYEES>" +
                        "<CANBO>"
                        + "<MACB>ID_TG_CS02</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS02</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS02</EMAIL>"
                        + "<ACCOUNT>TG_CS02</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>"
                        + "<CANBO>"
                        + "<MACB>ID_TG_CS03</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS03</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS03</EMAIL>"
                        + "<ACCOUNT>TG_CS03</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>"
                        + "<CANBO>"
                        + "<MACB>ID_TG_CS04</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS04</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS04</EMAIL>"
                        + "<ACCOUNT>TG_CS04</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>" +"</EMPLOYEES>" ;
            }


            if (branch.equals("149") && role.equals("daumoi")) {
                return "<CANBO>"
                        + "<MACB>ID_DM_01</MACB>"
                        + "<HOTEN>FULLNAME_DM_01</HOTEN>"
                        + "<EMAIL>shbtestmail+33@gmail.com</EMAIL>"
                        + "<ACCOUNT>DM_01</ACCOUNT>"
                        + "<ROLECODE>daumoi</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("149") && role.equals("Giamdocdonvi")) {
                return "<CANBO>"
                        + "<MACB>ID_GD_DV01</MACB>"
                        + "<HOTEN>FULLNAME_GD_DV01</HOTEN>"
                        + "<EMAIL>EMAIL_GD_DV01</EMAIL>"
                        + "<ACCOUNT>GD_DV01</ACCOUNT>"
                        + "<ROLECODE>Giamdocdonvi</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("149") && role.equals("Giamdoctrungtam")) {
                return "<CANBO>"
                        + "<MACB>ID_GD_TT01</MACB>"
                        + "<HOTEN>FULLNAME_GD_TT01</HOTEN>"
                        + "<EMAIL>EMAIL_GD_TT01</EMAIL>"
                        + "<ACCOUNT>GD_TT01</ACCOUNT>"
                        + "<ROLECODE>Giamdoctrungtam</ROLECODE>"
                        + "</CANBO>"
                        ;
            }

            if (branch.equals("120") && role.equals("thuongtruchoidong")) {
                return "<CANBO>"
                        + "<MACB>ID_THHD_CS02</MACB>"
                        + "<HOTEN>FULLNAME_THHD_CS02</HOTEN>"
                        + "<EMAIL>shbtestmail+9@gmail.com</EMAIL>"
                        + "<ACCOUNT>THHD_CS02</ACCOUNT>"
                        + "<ROLECODE>thuongtruchoidong</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("chutichhoidong")) {
                return "<CANBO>"
                        + "<MACB>ID_CTHDKHCN_CS02</MACB>"
                        + "<HOTEN>FULLNAME_CTHDKHCN_CS02</HOTEN>"
                        + "<EMAIL>EMAIL_CTHDKHCN_CS02</EMAIL>"
                        + "<ACCOUNT>CTHDKHCN_CS02</ACCOUNT>"
                        + "<ROLECODE>chutichhoidong</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("chutichhoidongxetduyet")) {
                return "<CANBO>"
                        + "<MACB>ID_CTHDXD_CS02</MACB>"
                        + "<HOTEN>FULLNAME_CTHDXD_CS02</HOTEN>"
                        + "<EMAIL>EMAIL_CTHDXD_CS02</EMAIL>"
                        + "<ACCOUNT>CTHDXD_CS02</ACCOUNT>"
                        + "<ROLECODE>chutichhoidongxetduyet</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("hoidongkhoahoc")) {
                return "<CANBO>"
                        + "<MACB>ID_TVHDXD_CS02</MACB>"
                        + "<HOTEN>FULLNAME_TVHDXD_CS02</HOTEN>"
                        + "<EMAIL>EMAIL_TVHDXD_CS02</EMAIL>"
                        + "<ACCOUNT>TVHDXD_CS02</ACCOUNT>"
                        + "<ROLECODE>hoidongkhoahoc</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("tacgia")) {
                return "<EMPLOYEES>"+"<CANBO>"
                        + "<MACB>ID_TG_CS02</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS02</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS02</EMAIL>"
                        + "<ACCOUNT>TG_CS02</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>"
                        + "<CANBO>"
                        + "<MACB>ID_TG_CS03</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS03</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS03</EMAIL>"
                        + "<ACCOUNT>TG_CS03</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>"
                        + "<CANBO>"
                        + "<MACB>ID_TG_CS04</MACB>"
                        + "<HOTEN>FULLNAME_TG_CS04</HOTEN>"
                        + "<EMAIL>EMAIL_TG_CS04</EMAIL>"
                        + "<ACCOUNT>TG_CS04</ACCOUNT>"
                        + "<ROLECODE>tacgia</ROLECODE>"
                        + "</CANBO>" + "</EMPLOYEES>"
                        ;
            }
            if (branch.equals("120") && role.equals("daumoi")) {
                return "<CANBO>"
                        + "<MACB>ID_DM_02</MACB>"
                        + "<HOTEN>FULLNAME_DM_02</HOTEN>"
                        + "<EMAIL>shbtestmail+28@gmail.com</EMAIL>"
                        + "<ACCOUNT>DM_02</ACCOUNT>"
                        + "<ROLECODE>daumoi</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("Giamdocdonvi")) {
                return "<CANBO>"
                        + "<MACB>ID_GD_DV02</MACB>"
                        + "<HOTEN>FULLNAME_GD_DV02</HOTEN>"
                        + "<EMAIL>EMAIL_GD_DV02</EMAIL>"
                        + "<ACCOUNT>GD_DV02</ACCOUNT>"
                        + "<ROLECODE>Giamdocdonvi</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
            if (branch.equals("120") && role.equals("Giamdoctrungtam")) {
                return "<CANBO>"
                        + "<MACB>ID_GD_TT02</MACB>"
                        + "<HOTEN>FULLNAME_GD_TT02</HOTEN>"
                        + "<EMAIL>EMAIL_GD_TT02</EMAIL>"
                        + "<ACCOUNT>GD_TT02</ACCOUNT>"
                        + "<ROLECODE>Giamdoctrungtam</ROLECODE>"
                        + "</CANBO>"
                        ;
            }
        }

        if (role.equals("thuongtruchethong")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_THHD_HT01</MACB>"
                    + " <HOTEN>FULLNAME_THHD_HT01</HOTEN>"
                    + " <EMAIL>EMAIL_THHD_HT01</EMAIL>"
                    + " <ACCOUNT>THHD_HT01</ACCOUNT>"
                    + " <ROLECODE>thuongtruchethong</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_THHD_HT02</MACB>"
                    + " <HOTEN>FULLNAME_THHD_HT02</HOTEN>"
                    + " <EMAIL>EMAIL_THHD_HT02</EMAIL>"
                    + " <ACCOUNT>THHD_HT02</ACCOUNT>"
                    + " <ROLECODE>thuongtruchethong</ROLECODE>"
                    + " </CANBO>"+"</EMPLOYEES>";
        }
        if (role.equals("chutichhdkhhethong")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_CTHDKHCN_HT01</MACB>"
                    + " <HOTEN>FULLNAME_CTHDKHCN_HT01</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDKHCN_HT01</EMAIL>"
                    + " <ACCOUNT>CTHDKHCN_HT01</ACCOUNT>"
                    + " <ROLECODE>chutichhdkhhethong</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_CTHDKHCN_HT02</MACB>"
                    + " <HOTEN>FULLNAME_CTHDKHCN_HT02</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDKHCN_HT02</EMAIL>"
                    + " <ACCOUNT>CTHDKHCN_HT02</ACCOUNT>"
                    + " <ROLECODE>chutichhdkhhethong</ROLECODE>"
                    + " </CANBO>" +"</EMPLOYEES>";
        }
        if (role.equals("Giamdoctrungtam")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_GD_TT01</MACB>"
                    + " <HOTEN>FULLNAME_GD_TT01</HOTEN>"
                    + " <EMAIL>EMAIL_GD_TT01</EMAIL>"
                    + " <ACCOUNT>GD_TT01</ACCOUNT>"
                    + " <ROLECODE>Giamdoctrungtam</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_GD_TT02</MACB>"
                    + " <HOTEN>FULLNAME_GD_TT02</HOTEN>"
                    + " <EMAIL>EMAIL_GD_TT02</EMAIL>"
                    + " <ACCOUNT>GD_TT02</ACCOUNT>"
                    + " <ROLECODE>Giamdoctrungtam</ROLECODE>"
                    + " </CANBO>"+"</EMPLOYEES>";
        }
        if (role.equals("daumoi")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_DM_01</MACB>"
                    + " <HOTEN>FULLNAME_DM_01</HOTEN>"
                    + " <EMAIL>EMAIL_DM_01</EMAIL>"
                    + " <ACCOUNT>DM_01</ACCOUNT>"
                    + " <ROLECODE>daumoi</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_DM_02</MACB>"
                    + " <HOTEN>FULLNAME_DM_02</HOTEN>"
                    + " <EMAIL>EMAIL_DM_02</EMAIL>"
                    + " <ACCOUNT>DM_02</ACCOUNT>"
                    + " <ROLECODE>daumoi</ROLECODE>"
                    + " </CANBO>" +"</EMPLOYEES>";
        }

        if (role.equals("tacgia")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_TG_CS02</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS02</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS02</EMAIL>"
                    + " <ACCOUNT>TG_CS02</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_TG_CS03</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS03</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS03</EMAIL>"
                    + " <ACCOUNT>TG_CS03</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_TG_CS04</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS04</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS04</EMAIL>"
                    + " <ACCOUNT>TG_CS04</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_TG_CS02</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS02</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS02</EMAIL>"
                    + " <ACCOUNT>TG_CS02</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_TG_CS03</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS03</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS03</EMAIL>"
                    + " <ACCOUNT>TG_CS03</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_TG_CS04</MACB>"
                    + " <HOTEN>FULLNAME_TG_CS04</HOTEN>"
                    + " <EMAIL>EMAIL_TG_CS04</EMAIL>"
                    + " <ACCOUNT>TG_CS04</ACCOUNT>"
                    + " <ROLECODE>tacgia</ROLECODE>"
                    + " </CANBO>" +"</EMPLOYEES>";
        }

        if (role.equals("thuongtruchoidong")) {
            return "<EMPLOYEES>" + "<CANBO>"
                    + " <MACB>ID_THHD_CS01</MACB>"
                    + " <HOTEN>FULLNAME_THHD_CS01</HOTEN>"
                    + " <EMAIL>shbtestmail+3@gmail.com</EMAIL>"
                    + " <ACCOUNT>THHD_CS01</ACCOUNT>"
                    + " <ROLECODE>thuongtruchoidong</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_THHD_CS02</MACB>"
                    + " <HOTEN>FULLNAME_THHD_CS02</HOTEN>"
                    + " <EMAIL>shbtestmail+9@gmail.com</EMAIL>"
                    + " <ACCOUNT>THHD_CS02</ACCOUNT>"
                    + " <ROLECODE>thuongtruchoidong</ROLECODE>"
                    + " </CANBO>" + "</EMPLOYEES>";
        }

        if (role.equals("chutichhoidong")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_CTHDKHCN_CS01</MACB>"
                    + " <HOTEN>FULLNAME_CTHDKHCN_CS01</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDKHCN_CS01</EMAIL>"
                    + " <ACCOUNT>CTHDKHCN_CS01</ACCOUNT>"
                    + " <ROLECODE>chutichhoidong</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_CTHDKHCN_CS02</MACB>"
                    + " <HOTEN>FULLNAME_CTHDKHCN_CS02</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDKHCN_CS02</EMAIL>"
                    + " <ACCOUNT>CTHDKHCN_CS02</ACCOUNT>"
                    + " <ROLECODE>chutichhoidong</ROLECODE>"
                    + " </CANBO>" +"</EMPLOYEES>";
        }

        if (role.equals("chutichhoidongxetduyet")) {
            return "<EMPLOYEES>"+"<CANBO>"
                    + " <MACB>ID_CTHDXD_CS01</MACB>"
                    + " <HOTEN>FULLNAME_CTHDXD_CS01</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDXD_CS01</EMAIL>"
                    + " <ACCOUNT>CTHDXD_CS01</ACCOUNT>"
                    + " <ROLECODE>chutichhoidongxetduyet</ROLECODE>"
                    + " </CANBO>"
                    + "<CANBO>"
                    + " <MACB>ID_CTHDXD_CS02</MACB>"
                    + " <HOTEN>FULLNAME_CTHDXD_CS02</HOTEN>"
                    + " <EMAIL>EMAIL_CTHDXD_CS02</EMAIL>"
                    + " <ACCOUNT>CTHDXD_CS02</ACCOUNT>"
                    + " <ROLECODE>chutichhoidongxetduyet</ROLECODE>"
                    + " </CANBO>"+ "</EMPLOYEES>";
        }
        return "";
    }

}
