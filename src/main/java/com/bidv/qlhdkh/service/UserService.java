package com.bidv.qlhdkh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bidv.qlhdkh.model.UserModel;

public interface UserService {
    List<UserModel> getAllUserModel(String username, String codeUser, String email, String brn, String departmentCode, String title, String contacts, String brnLevel, String bds, Pageable pageable);

    UserModel findUserBuCodeUser(String userName);
}
