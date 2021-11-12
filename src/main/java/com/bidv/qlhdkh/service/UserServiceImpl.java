package com.bidv.qlhdkh.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidv.qlhdkh.constants.Constants;
import com.bidv.qlhdkh.entity.UserInfo;
import com.bidv.qlhdkh.model.UserModel;
import com.bidv.qlhdkh.repository.DepartmentRepository;
import com.bidv.qlhdkh.repository.UserInfoRepository;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    Constants constants;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<UserModel> getAllUserModel(String username, String codeUser, String email, String brn, String departmentCode, String title, String department, String brnLevel, String bds, Pageable pageable) {
        List<UserModel> userModels = new ArrayList<>();
        try {
            log.info("Start query get list User Info");
            log.info("debug enabled: {}", log.isDebugEnabled());
            List<UserModel.info> infoList = userInfoRepository.getAllUserModel(username, codeUser, email, brn, departmentCode, title, department, brnLevel, bds, pageable);
            userModels = constants.fromToList(infoList, UserModel.class);
            log.info("End query get list User Info");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn query get list info user");
            log.error("Error query get list info user");
        }
        return userModels;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserModel findUserBuCodeUser(String codeUser) {
        UserInfo userInfo = new UserInfo();
        UserModel userModel = new UserModel();
        try {
            log.info("Start query get  User Info by CodeUser");
            userInfo = userInfoRepository.findUserInfoByCodeUserss(codeUser);
            ModelMapper modelMapper = new ModelMapper();
            userModel = modelMapper.map(userInfo, UserModel.class);
            log.info("End query get User Info");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Warn query get info User Info by CodeUser");
            log.error("Error query get User Info by CodeUser");
        }
        return userModel;
    }


}
