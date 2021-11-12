package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.InfoUser;

import java.io.IOException;
import java.net.MalformedURLException;

public interface UserServiceXml {
    InfoUser getUserInfo(String email, String codeApp) throws IOException;
}
