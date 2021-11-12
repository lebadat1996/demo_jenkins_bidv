package com.bidv.qlhdkh.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public interface SendMailService {
    void sendMailService() throws IOException, MessagingException;

    void sendMailServiceReport() throws IOException, MessagingException;

    void sendMailServiceReportSCN() throws IOException, MessagingException;

    void sendMailServiceReportCTL() throws IOException, MessagingException;

    void sendMailReportAction() throws IOException, MessagingException;

    JavaMailSenderImpl sendMails();

}
