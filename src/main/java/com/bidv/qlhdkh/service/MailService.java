package com.bidv.qlhdkh.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.model.Email;
import com.bidv.qlhdkh.service.impl.SendMailServicelImpl;

@Service
public class MailService {
    @Autowired
    Constants constants;
    @Autowired
    SendMailServicelImpl sendMailService;

    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    public void sendMails(Email emailModel) throws MessagingException, IOException {
        try{
            log.info("Notify Send Mail !!!");
            log.debug("Debug Api Send Mail");
            log.info("Start Send Mail");
            List<String> listEmail = emailModel.getToMails();
            String[] myArray = new String[listEmail.size()];
            listEmail.toArray(myArray);
            MimeMessage msg = sendMailService.sendMails().createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true, "utf8");
            mimeMessageHelper.setTo(myArray);
            mimeMessageHelper.setSubject(emailModel.getSubject());
            mimeMessageHelper.setText(getContent(emailModel.getCodeGen(), constants.getEmailLink()), true);
            sendMailService.sendMails().send(msg);
            log.debug("Debug Api Send Mail End.");
            log.info("Api Send Mail Success");
        }catch (Exception e){
            e.printStackTrace();
            log.debug("Warn Send Mail");
            log.error("Error Send Mail");
        }
    }

    public static String getContent(String codeGen, String link) {
        return "<h4>Kính gửi</h4>Anh/chị,<br>CBTH đang thực hiện đăng ký nhiệm vụ " + codeGen + " cấp Hệ thống/Cơ sở, khai báo Anh/Chị với vai trò Chủ nhiệm nhiệm vụ/ Thư ký nhiệm vụ/Giám đốc/Lãnh đạo Đơn vị chủ trì/ Danh sách thành viên tham gia.\n" +
                "<br>Đề nghị Anh/Chị xác nhận tham gia đăng ký bằng cách ấn vào Link sau: <a href=\"" + link + "\">" + link + "</a>" +
                "<br>Trân trọng cảm ơn anh chị !" +
                "<br>" +
                "<b><i>Đây là email được gửi tự động từ hệ thống vui lòng không reply lại.</i></b>";
    }

    public static String emailContent(String codeGen, String link) throws IOException {
        InputStream is = null;
        BufferedReader in = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            is = MailService.class.getClassLoader().getResourceAsStream("content/emailContent.html");
            assert is != null;
            in = new BufferedReader(new InputStreamReader(is));
            String str;
            while ((str = in.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
            in.close();
        }
        return stringBuilder.toString();
    }
}
