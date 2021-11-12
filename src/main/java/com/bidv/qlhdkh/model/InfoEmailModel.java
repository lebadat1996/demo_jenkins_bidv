package com.bidv.qlhdkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class InfoEmailModel {
     Date endDate;
     String email;
     String status;
     String userId;
     String userName;
     String departmentCode;

    public interface infoEmail {
        Date getEndDate();

        String getEmail();

        String getStatus();

        String getUserId();

        String getUserName();

        String getDepartmentCode();
    }
}
