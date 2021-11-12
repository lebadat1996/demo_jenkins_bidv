package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

public class InfoUser {
    @JsonProperty("UserInfoModel")
    private UserInfoModel userInfoModel = null;

    @JsonProperty("LstRoleInfo")
    private LstRoleInfo lstRoleInfo = null;

    @JsonProperty("LstFunctionModel")
    private LstFunctionModel lstFunctionModel = null;


    public InfoUser lstRoleInfo(LstRoleInfo lstRoleInfo) {
        this.lstRoleInfo = lstRoleInfo;
        return this;
    }

    /**
     * Get lstRoleInfo
     *
     * @return lstRoleInfo
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstRoleInfo getLstRoleInfo() {
        return lstRoleInfo;
    }

    public void setLstRoleInfo(LstRoleInfo lstRoleInfo) {
        this.lstRoleInfo = lstRoleInfo;
    }

    public InfoUser lstFunctionModel(LstFunctionModel lstFunctionModel) {
        this.lstFunctionModel = lstFunctionModel;
        return this;
    }

    /**
     * Get lstFunctionModel
     *
     * @return lstFunctionModel
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstFunctionModel getLstFunctionModel() {
        return lstFunctionModel;
    }

    public void setLstFunctionModel(LstFunctionModel lstFunctionModel) {
        this.lstFunctionModel = lstFunctionModel;
    }

    public InfoUser userInfoModel(UserInfoModel userInfoModel) {
        this.userInfoModel = userInfoModel;
        return this;
    }

    /**
     * Get userInfoModel
     *
     * @return userInfoModel
     **/
    @ApiModelProperty(value = "")

    @Valid

    public UserInfoModel getUserInfoModel() {
        return userInfoModel;
    }

    public void setUserInfoModel(UserInfoModel userInfoModel) {
        this.userInfoModel = userInfoModel;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfoUser infoUser = (InfoUser) o;
        return Objects.equals(this.userInfoModel, infoUser.userInfoModel) && Objects.equals(this.lstRoleInfo, infoUser.lstRoleInfo) &&
                Objects.equals(this.lstFunctionModel, infoUser.lstFunctionModel)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstRoleInfo, lstFunctionModel, userInfoModel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InfoUser {\n");
        sb.append("    userInfoModel: ").append(toIndentedString(userInfoModel)).append("\n");
        sb.append("    lstRoleInfo: ").append(toIndentedString(lstRoleInfo)).append("\n");
        sb.append("    lstFunctionModel: ").append(toIndentedString(lstFunctionModel)).append("\n");

        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
