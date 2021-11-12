package com.bidv.qlhdkh.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Util {

    public static Date getDate(String datePath) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        if (datePath != null && !datePath.isEmpty()) {
            date = simpleDateFormat.parse(datePath);
        }
        return date;
    }


    public static Date getDates(String dateFormat) throws ParseException {
        Date date = null;
        try {
            if (dateFormat != null && !dateFormat.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                date = simpleDateFormat.parse(dateFormat);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }

    public static String convertDateToString(Date date) {
        String strDate = null;
        try {
            if (date != null) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                strDate = dateFormat.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
            strDate = null;
        }
        return strDate;
    }

    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        s = s.trim();
        if ("".equals(s)) {
            return true;
        }
        return false;
    }

    public static List<String> listUpdate() {
        List<String> statusList = new ArrayList<>();
        statusList.add("NVCS02");
        statusList.add("NVHT02");
        return statusList;
    }

    public static List<String> listStatus() {
        List<String> statusList = new ArrayList<>();
        statusList.add("NVCS02");
        statusList.add("NVCS04");
        statusList.add("NVCS08");
        statusList.add("NVCS10");
        statusList.add("NVHT02");
        statusList.add("NVHT04");
        statusList.add("NVHT08");
        statusList.add("NVHT10");
        statusList.add("SKCS02");
        statusList.add("SKCS03");
        statusList.add("SKCS05");
        statusList.add("SKCS07");
        statusList.add("SKHT01");
        statusList.add("SKHT02");
        statusList.add("SKHT02");
        statusList.add("SKHT03");
        statusList.add("SKHT05");
        statusList.add("SKHT07");
        return statusList;
    }

    public static List<String> listStatusNewCase() {
        List<String> statusList = new ArrayList<>();
        statusList.add("NVCS02");
        statusList.add("NVCS04");
        statusList.add("NVHT02");
        statusList.add("NVHT04");
        statusList.add("SKCS02");
        statusList.add("SKCS03");
        statusList.add("SKHT02");
        statusList.add("SKHT03");
        statusList.add("NVCS08");
        statusList.add("NVHT08");
        return statusList;
    }


    public static List<String> listStatusCheck() {
        List<String> statusList = new ArrayList<>();
        statusList.add("NVCS03");
        statusList.add("NVCS04");
        statusList.add("NVCS05");
        statusList.add("NVCS06");
        statusList.add("NVCS07");
        statusList.add("NVCS08");
        statusList.add("NVCS09");
        statusList.add("NVCS10");
        statusList.add("NVHT03");
        statusList.add("NVHT04");
        statusList.add("NVHT05");
        statusList.add("NVHT06");
        statusList.add("NVHT07");
        statusList.add("NVHT08");
        statusList.add("NVHT09");
        statusList.add("NVHT10");
//        statusList.add("SKHT08");
//        statusList.add("SKCS08");
//        statusList.add("NVHT02");
//        statusList.add("NVCS02");
        return statusList;
    }

    public static List<String> checkStatusSk() {
        List<String> statusList = new ArrayList<>();

        statusList.add("SKCS04");
        statusList.add("SKCS05");
        return statusList;
    }



}
