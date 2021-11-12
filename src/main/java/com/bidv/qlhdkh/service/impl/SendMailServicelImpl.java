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
            String interestSub = "Sáng kiến hiện hành";
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
            mimeMessageHelper.setSubject("Báo cáo hoạt động Nghiên Cứu KH và Sáng Kiến");
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
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH thực hiện báo cáo hoạt động Nghiên Cứu KH và Sáng Kiến cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Thường trực Hội đồng hoặc Đầu mối quản lý hoạt động.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
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
            mimeMessageHelper.setSubject("Đề Nghị Hoàn Thiện Hồ Sơ Nghiệm thu");
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
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH đang thực hiện đăng ký nhiệm vụ " + projectCode + " cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Chủ nhiệm nhiệm vụ/ Thư ký nhiệm vụ.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
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
            mimeMessageHelper.setSubject("Báo Cáo Sau Nghiệm Thu");
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
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH đang thực hiện báo cáo sau nghiệm thu nhiệm vụ " + projectCode + " cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Chủ nhiệm nhiệm vụ/ Thư ký nhiệm vụ.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
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
            mimeMessageHelper.setSubject("Báo cáo sau công nhận");
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
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH đang thực hiện  báo cáo sau công nhận nhiệm vụ " + projectCode + " cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Tác giả/Nhóm tác giả.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
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
            mimeMessageHelper.setSubject("Đề nghị đánh giá số tiền làm lợi sau 1 năm áp dụng");
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
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH đang thực hiện  đề nghị đánh giá số tiền làm lợi sau 1 năm áp dụng " + projectCode + " cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Tác giả/Nhóm tác giả.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
    }


}
