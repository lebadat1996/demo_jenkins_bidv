package com.bidv.qlhdkh.service.impl;

import static com.bidv.qlhdkh.constants.Constants.CN;
import static com.bidv.qlhdkh.constants.Constants.TG;
import static com.bidv.qlhdkh.constants.Constants.TK;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.CaseInfoHistory;
import com.bidv.qlhdkh.entity.ListMemberHistory;
import com.bidv.qlhdkh.model.CadresInforModel;
import com.bidv.qlhdkh.repository.CaseInfoHistoryRepository;
import com.bidv.qlhdkh.repository.ListMemberHistoryRepository;
import com.bidv.qlhdkh.service.MailService;
import com.bidv.qlhdkh.service.SendMailService;

@Service
public class SendMailServicelImpl implements SendMailService {
    private static final Logger log = LoggerFactory.getLogger(SendMailServicelImpl.class);

    @Autowired
    CaseInfoHistoryRepository caseInfoHistoryRepository;
    @Autowired
    MailService mailService;
    @Autowired
    ListMemberHistoryRepository historyRepository;
    @Autowired
    Constants constants;
    @Autowired
    ListMemberHistoryRepository listMemberHistoryRepository;
    @Autowired
    CallSoapService callSoapService;

    @Override
    public void sendMailService() throws IOException, MessagingException {
        try {
            log.info("Start Api SendMail");
            List<CaseInfoHistory> caseInfoHistoryList = caseInfoHistoryRepository.caseInfo();
            List<ListMemberHistory> listMembers = listMemberHistoryRepository.listMemBerHis();
            List<ListMemberHistory> listMember = new ArrayList<>();
            Map<List<ListMemberHistory>, String> map = new HashMap<>();
            for (CaseInfoHistory c : caseInfoHistoryList) {
                Date date = c.getEndDate();
                LocalDate localDate = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                for (ListMemberHistory listMemberHistory : listMembers) {
                    if (c.getId().equals(listMemberHistory.getCaseId())
                            && (listMemberHistory.getJobTitle().contains(CN) || listMemberHistory.getJobTitle().contains(TK))) {
                        if (localDate.plusMonths(1).isEqual(LocalDate.now())) {
                            listMember.add(listMemberHistory);
                            map.put(listMember, c.getProjectCode());
                        }
                    }
                }
            }
            List<ListMemberHistory> listMemberHistories = listMember
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
            List<String> listEmail = new ArrayList<>();
            for (ListMemberHistory ls : listMemberHistories) {
                listEmail.add(ls.getEmail());
            }
            sendMails(listEmail, map.get(listMember));
            log.info("End Api SendMail");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn Send Mail");
            log.error("Error Send Mail");
        }

    }

    @Override
    public void sendMailServiceReport() throws IOException, MessagingException {
        try {
            log.info("Start Api SendMail");
            List<CaseInfoHistory> caseInfoHistoryList = caseInfoHistoryRepository.caseInfos();
            List<ListMemberHistory> listMembers = listMemberHistoryRepository.listMemBerHis();
            List<ListMemberHistory> listMember = new ArrayList<>();
            Map<List<ListMemberHistory>, String> map = new HashMap<>();
            for (CaseInfoHistory c : caseInfoHistoryList) {
                Date date = c.getAcceptDate();
                if (date != null) {
                    LocalDate localDate = date.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    for (ListMemberHistory listMemberHistory : listMembers) {
                        if (c.getId().equals(listMemberHistory.getCaseId())
                                && (listMemberHistory.getJobTitle().contains(CN) || listMemberHistory.getJobTitle().contains(TK))) {
                            if (localDate.plusMonths(6).isEqual(LocalDate.now())) {
                                listMember.add(listMemberHistory);
                                map.put(listMember, c.getProjectCode());
                            }
                        }
                    }
                }
            }
            List<ListMemberHistory> listMemberHistories = listMember
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
            List<String> listEmail = new ArrayList<>();
            for (ListMemberHistory ls : listMemberHistories) {
                listEmail.add(ls.getEmail());
            }
            sendMailsReportNT(listEmail, map.get(listMember));
            log.info("End Api SendMail");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    @Override
    public void sendMailServiceReportSCN() throws IOException, MessagingException {
        try {
            log.info("Start Api SendMail");
            List<CaseInfoHistory> caseInfoHistoryList = caseInfoHistoryRepository.caseInfosSCN();
            List<ListMemberHistory> listMembers = listMemberHistoryRepository.listMemBerHis();
            List<ListMemberHistory> listMember = new ArrayList<>();
            Map<List<ListMemberHistory>, String> map = new HashMap<>();
            for (CaseInfoHistory c : caseInfoHistoryList) {
                Date date = c.getRecognitionDate();
                if (date != null) {
                    LocalDate localDate = date.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    for (ListMemberHistory listMemberHistory : listMembers) {
                        if (c.getId().equals(listMemberHistory.getCaseId()) && listMemberHistory.getJobTitle().contains(TG)) {
                            if (localDate.plusMonths(6).isEqual(LocalDate.now())) {
                                listMember.add(listMemberHistory);
                                map.put(listMember, c.getProjectCode());
                            }
                        }
                    }
                }
            }
            List<ListMemberHistory> listMemberHistories = listMember
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
            List<String> listEmail = new ArrayList<>();
            for (ListMemberHistory ls : listMemberHistories) {
                listEmail.add(ls.getEmail());
            }
            sendMailsSCN(listEmail, map.get(listMember));
            log.info("End Api SendMail");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    @Override
    public void sendMailServiceReportCTL() throws IOException, MessagingException {
        try {
            log.info("Start Api SendMail");
            String interestSub = "S??ng ki???n hi???n h??nh";
            List<CaseInfoHistory> caseInfoHistoryList = caseInfoHistoryRepository.caseInfosCTL(interestSub);
            List<ListMemberHistory> listMembers = listMemberHistoryRepository.listMemBerHis();
            List<ListMemberHistory> listMember = new ArrayList<>();
            Map<List<ListMemberHistory>, String> map = new HashMap<>();
            for (CaseInfoHistory c : caseInfoHistoryList) {
                Date date = c.getRecognitionDate();
                if (date != null) {
                    LocalDate localDate = date.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    for (ListMemberHistory listMemberHistory : listMembers) {
                        if (c.getId().equals(listMemberHistory.getCaseId()) && listMemberHistory.getJobTitle().contains(TG)) {
                            if (localDate.plusYears(1).isEqual(LocalDate.now())) {
                                listMember.add(listMemberHistory);
                                map.put(listMember, c.getProjectCode());
                            }
                        }
                    }
                }
            }
            List<ListMemberHistory> listMemberHistories = listMember
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
            List<String> listEmail = new ArrayList<>();
            for (ListMemberHistory ls : listMemberHistories) {
                listEmail.add(ls.getEmail());
            }
            sendMailsCTL(listEmail, map.get(listMember));
            log.info("End Api SendMail");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    @Override
    public void sendMailReportAction() throws IOException, MessagingException {
        try {
            String roleTT = constants.getRoleTT();
            String roledm = constants.getRoledm();
            List<CadresInforModel> lstCadres = callSoapService.callSoap("149", null, roleTT);
            List<CadresInforModel> cadres = callSoapService.callSoap("149", null, roledm);
            List<CadresInforModel> cadresE = callSoapService.callSoap("120", null, roledm);
            List<CadresInforModel> lstCadress = callSoapService.callSoap("120", null, roleTT);
            List<CadresInforModel> cadresInforModelList = new ArrayList<>();
            cadresInforModelList.addAll(cadres);
            cadresInforModelList.addAll(cadresE);
            cadresInforModelList.addAll(lstCadres);
            cadresInforModelList.addAll(lstCadress);
            List<String> emails = new ArrayList<>();
            for (CadresInforModel c : cadresInforModelList) {
                emails.add(c.getEmail());
            }
            sendMailsReportAction(emails);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public JavaMailSenderImpl sendMails() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(constants.getHostEmail());
        mailSender.setPort(constants.getPortEmail());
        mailSender.setUsername(constants.getUserName());
        mailSender.setPassword(constants.getPassword());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");
        return mailSender;
    }

    public void sendMailsReportAction(List<String> emails) throws MessagingException, IOException {
        try {
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            if (emails == null || emails.isEmpty()) {
                return;
            }
            String[] myArray = new String[emails.size()];
            emails.toArray(myArray);
            MimeMessage msg = sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject("B??o c??o ho???t ?????ng Nghi??n C???u KH v?? S??ng Ki???n");
            mimeMessageHelper.setText(getContentRpAction(constants.getEmailLink()), true);
            sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContentRpAction(String link) {
        return "<h4>K??nh g???i</h4>Anh/ch???,<br>CBTH th???c hi???n b??o c??o ho???t ?????ng Nghi??n C???u KH v?? S??ng Ki???n c???p H??? th???ng/C?? s???, khai b??o Anh/Ch??? v???i vai tr?? Th?????ng tr???c H???i ?????ng ho???c ?????u m???i qu???n l?? ho???t ?????ng.\n" +
                "<br>????? ngh??? Anh/Ch??? x??c nh???n tham gia ????ng k?? b???ng c??ch ???n v??o Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Tr??n tr???ng c???m ??n anh ch??? !" +
                "<br>" +
                "<b><i>????y l?? email ???????c g???i t??? ?????ng t??? h??? th???ng vui l??ng kh??ng reply l???i.</i></b>";
    }

    public void sendMails(List<String> emails, String projectCode) throws MessagingException, IOException {
        try {
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            if (emails == null || emails.isEmpty()) {
                return;
            }
            String[] myArray = new String[emails.size()];
            emails.toArray(myArray);
            MimeMessage msg = sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject("????? Ngh??? Ho??n Thi???n H??? S?? Nghi???m thu");
            mimeMessageHelper.setText(getContent(constants.getEmailLink(), projectCode), true);
            sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContent(String link, String projectCode) {
        return "<h4>K??nh g???i</h4>Anh/ch???,<br>CBTH ??ang th???c hi???n ????ng k?? nhi???m v??? " + projectCode + " c???p H??? th???ng/C?? s???, khai b??o Anh/Ch??? v???i vai tr?? Ch??? nhi???m nhi???m v???/ Th?? k?? nhi???m v???.\n" +
                "<br>????? ngh??? Anh/Ch??? x??c nh???n tham gia ????ng k?? b???ng c??ch ???n v??o Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Tr??n tr???ng c???m ??n anh ch??? !" +
                "<br>" +
                "<b><i>????y l?? email ???????c g???i t??? ?????ng t??? h??? th???ng vui l??ng kh??ng reply l???i.</i></b>";
    }


    public void sendMailsReportNT(List<String> emails, String projectCode) throws MessagingException, IOException {
        try {
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            if (emails == null || emails.isEmpty()) {
                return;
            }
            String[] myArray = new String[emails.size()];
            emails.toArray(myArray);
            MimeMessage msg = sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject("B??o C??o Sau Nghi???m Thu");
            mimeMessageHelper.setText(getContentReportNT(constants.getEmailLink(), projectCode), true);
            sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContentReportNT(String link, String projectCode) {
        return "<h4>K??nh g???i</h4>Anh/ch???,<br>CBTH ??ang th???c hi???n b??o c??o sau nghi???m thu nhi???m v??? " + projectCode + " c???p H??? th???ng/C?? s???, khai b??o Anh/Ch??? v???i vai tr?? Ch??? nhi???m nhi???m v???/ Th?? k?? nhi???m v???.\n" +
                "<br>????? ngh??? Anh/Ch??? x??c nh???n tham gia ????ng k?? b???ng c??ch ???n v??o Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Tr??n tr???ng c???m ??n anh ch??? !" +
                "<br>" +
                "<b><i>????y l?? email ???????c g???i t??? ?????ng t??? h??? th???ng vui l??ng kh??ng reply l???i.</i></b>";
    }

    public void sendMailsSCN(List<String> emails, String projectCode) throws MessagingException, IOException {
        try {
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            if (emails == null || emails.isEmpty()) {
                return;
            }
            String[] myArray = new String[emails.size()];
            emails.toArray(myArray);
            MimeMessage msg = sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject("B??o c??o sau c??ng nh???n");
            mimeMessageHelper.setText(getContentReportSCN(constants.getEmailLink(), projectCode), true);
            sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContentReportSCN(String link, String projectCode) {
        return "<h4>K??nh g???i</h4>Anh/ch???,<br>CBTH ??ang th???c hi???n  b??o c??o sau c??ng nh???n nhi???m v??? " + projectCode + " c???p H??? th???ng/C?? s???, khai b??o Anh/Ch??? v???i vai tr?? T??c gi???/Nh??m t??c gi???.\n" +
                "<br>????? ngh??? Anh/Ch??? x??c nh???n tham gia ????ng k?? b???ng c??ch ???n v??o Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Tr??n tr???ng c???m ??n anh ch??? !" +
                "<br>" +
                "<b><i>????y l?? email ???????c g???i t??? ?????ng t??? h??? th???ng vui l??ng kh??ng reply l???i.</i></b>";
    }

    public void sendMailsCTL(List<String> emails, String projectCode) throws MessagingException, IOException {
        try {
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            if (emails == null || emails.isEmpty()) {
                return;
            }
            String[] myArray = new String[emails.size()];
            emails.toArray(myArray);
            MimeMessage msg = sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject("????? ngh??? ????nh gi?? s??? ti???n l??m l???i sau 1 n??m ??p d???ng");
            mimeMessageHelper.setText(getContentReportCTL(constants.getEmailLink(), projectCode), true);
            sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContentReportCTL(String link, String projectCode) {
        return "<h4>K??nh g???i</h4>Anh/ch???,<br>CBTH ??ang th???c hi???n  ????? ngh??? ????nh gi?? s??? ti???n l??m l???i sau 1 n??m ??p d???ng " + projectCode + " c???p H??? th???ng/C?? s???, khai b??o Anh/Ch??? v???i vai tr?? T??c gi???/Nh??m t??c gi???.\n" +
                "<br>????? ngh??? Anh/Ch??? x??c nh???n tham gia ????ng k?? b???ng c??ch ???n v??o Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Tr??n tr???ng c???m ??n anh ch??? !" +
                "<br>" +
                "<b><i>????y l?? email ???????c g???i t??? ?????ng t??? h??? th???ng vui l??ng kh??ng reply l???i.</i></b>";
    }


}
