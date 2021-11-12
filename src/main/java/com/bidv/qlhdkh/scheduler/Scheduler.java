package com.bidv.qlhdkh.scheduler;

import com.bidv.qlhdkh.service.impl.SendMailServicelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class Scheduler {
    @Autowired
    SendMailServicelImpl sendMailServicel;

    @Scheduled(cron = "${some.email.profile.nt}")
    public void schedule() throws Exception {
        sendMailServicel.sendMailService();
    }

    @Scheduled(cron = "${some.email.profile.snt}")
    public void scheduleReport() throws Exception {
        sendMailServicel.sendMailServiceReport();
    }

    @Scheduled(cron = "${some.email.profile.scn}")
    public void scheduleReportSCN() throws Exception {
        sendMailServicel.sendMailServiceReportSCN();
    }

    @Scheduled(cron = "${some.email.profile.ctl}")
    public void scheduleReportCTL() throws Exception {
        sendMailServicel.sendMailServiceReportCTL();
    }

    @Scheduled(cron = "${some.email.profile.action1}")
    public void scheduleReportAction1() throws Exception {
        sendMailServicel.sendMailReportAction();
    }

    @Scheduled(cron = "${some.email.profile.action2}")
    public void scheduleReportAction2() throws Exception {
        sendMailServicel.sendMailReportAction();
    }

    @Scheduled(cron = "0 0 0-23 * * 0-6")
    public void a() throws Exception {
        Date date = new Date();
        DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String eDate = outputformat.format(date);
        Timestamp endDate = Timestamp.valueOf(eDate);
        System.out.println(endDate + "E");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        Date currentDatePlusOne = c.getTime();
        String sDate = outputformat.format(currentDatePlusOne);
        Timestamp startDate = Timestamp.valueOf(sDate);
        System.out.println(startDate + "S");
    }
}
