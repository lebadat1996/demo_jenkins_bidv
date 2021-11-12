package com.bidv.qlhdkh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CouncilDtoModel {

    Integer idCouncil;

    String councilId;

    String subject;

    String dateCreate;

    String dateModify;

    String creator;

    String modifier;

    String timeActive;

    String status;

    String memberid;

    String nameMember;

    String position;

    public interface infoCouncilModel {
        String getCouncilId();

        String getSubject();

        String getDateCreate();

        String getDateModify();

        String getCreator();

        String getModifier();

        String getTimeActive();

        String getStatus();

        String getMemberid();

        String getNameMember();

        String getPosition();

        Integer getIdCouncil();
    }
}
