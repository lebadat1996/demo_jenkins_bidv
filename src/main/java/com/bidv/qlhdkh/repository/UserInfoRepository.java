package com.bidv.qlhdkh.repository;

import com.bidv.qlhdkh.entity.UserInfo;
import com.bidv.qlhdkh.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {
    @Query(value = "select  U.codeUser as codeUser,U.username as username," +
            "U.email as email,U.brn as brn,U.status as status,U.mavtvt as mavtvt," +
            "U.title as title, U.departmentCode as departmentCode,U.contacts as contacts," +
            "U.latestsync as latestsync,U.passflag as passflag,U.passTime as passTime ," +
            "U.chgStatus as chgStatus,U.effectDate as effectDate,U.htchucvu as htchucvu," +
            "U.emplClass as emplClass,U.department as department,U.departmentName as departmentName," +
            "U.departmentCodeMap as departmentCodeMap,U.nameTitle as nameTitle,D.codeBdsParent as bdsParent" +
            " from UserInfo U INNER JOIN Department D ON  U.departmentCode = D.codeDepartment" +
            " where (:username is null or U.username like %:username%)" +
            "and (:codeUser is null or U.codeUser like %:codeUser%) " +
            "and (:email is null or U.email like %:email%) " +
            "and (:brn is null or U.brn like %:brn%) " +
            "and (:departmentCode is null or U.departmentCode like %:departmentCode%)" +
            "and (:brnLevel is null or D.brnLevel like %:brnLevel%)" +
            "and (:title is null or U.title like %:title%) " +
            "and (:department is null or U.department like %:department%)" +
            "and (:bds is null or U.bds like %:bds%) ORDER BY username")
    List<UserModel.info> getAllUserModel(String username, String codeUser, String email, String brn, String departmentCode, String title, String department, String brnLevel, String bds, Pageable pageable);

    @Query("select u from UserInfo u where u.codeUser=:codeUser")
    UserInfo findUserInfoByCodeUserss(String codeUser);
}
