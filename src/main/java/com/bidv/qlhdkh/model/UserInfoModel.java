package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserInfoModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-01T03:58:53.501Z")


public class UserInfoModel   {
  @JsonProperty("codeUser")
  private String codeUser = null;

  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("bds")
  private String bds = null;

  @JsonProperty("cra")
  private String cra = null;

  @JsonProperty("qlnsBrn")
  private String qlnsBrn = null;

  @JsonProperty("brn")
  private String brn = null;

  @JsonProperty("branch")
  private String branch = null;

  @JsonProperty("departmentCode")
  private String departmentCode = null;

  @JsonProperty("department")
  private String department = null;

  public UserInfoModel codeUser(String codeUser) {
    this.codeUser = codeUser;
    return this;
  }

  /**
   * Get codeUser
   * @return codeUser
  **/
  @ApiModelProperty(value = "")


  public String getCodeUser() {
    return codeUser;
  }

  public void setCodeUser(String codeUser) {
    this.codeUser = codeUser;
  }

  public UserInfoModel fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Get fullName
   * @return fullName
  **/
  @ApiModelProperty(value = "")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UserInfoModel email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfoModel bds(String bds) {
    this.bds = bds;
    return this;
  }

  /**
   * Get bds
   * @return bds
  **/
  @ApiModelProperty(value = "")


  public String getBds() {
    return bds;
  }

  public void setBds(String bds) {
    this.bds = bds;
  }

  public UserInfoModel cra(String cra) {
    this.cra = cra;
    return this;
  }

  /**
   * Get cra
   * @return cra
  **/
  @ApiModelProperty(value = "")


  public String getCra() {
    return cra;
  }

  public void setCra(String cra) {
    this.cra = cra;
  }

  public UserInfoModel qlnsBrn(String qlnsBrn) {
    this.qlnsBrn = qlnsBrn;
    return this;
  }

  /**
   * Get qlnsBrn
   * @return qlnsBrn
  **/
  @ApiModelProperty(value = "")


  public String getQlnsBrn() {
    return qlnsBrn;
  }

  public void setQlnsBrn(String qlnsBrn) {
    this.qlnsBrn = qlnsBrn;
  }

  public UserInfoModel brn(String brn) {
    this.brn = brn;
    return this;
  }

  /**
   * Get brn
   * @return brn
  **/
  @ApiModelProperty(value = "")


  public String getBrn() {
    return brn;
  }

  public void setBrn(String brn) {
    this.brn = brn;
  }

  public UserInfoModel branch(String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * Get branch
   * @return branch
  **/
  @ApiModelProperty(value = "")


  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public UserInfoModel departmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  /**
   * Get departmentCode
   * @return departmentCode
  **/
  @ApiModelProperty(value = "")


  public String getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
  }

  public UserInfoModel department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
  **/
  @ApiModelProperty(value = "")


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoModel userInfoModel = (UserInfoModel) o;
    return Objects.equals(this.codeUser, userInfoModel.codeUser) &&
        Objects.equals(this.fullName, userInfoModel.fullName) &&
        Objects.equals(this.email, userInfoModel.email) &&
        Objects.equals(this.bds, userInfoModel.bds) &&
        Objects.equals(this.cra, userInfoModel.cra) &&
        Objects.equals(this.qlnsBrn, userInfoModel.qlnsBrn) &&
        Objects.equals(this.brn, userInfoModel.brn) &&
        Objects.equals(this.branch, userInfoModel.branch) &&
        Objects.equals(this.departmentCode, userInfoModel.departmentCode) &&
        Objects.equals(this.department, userInfoModel.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeUser, fullName, email, bds, cra, qlnsBrn, brn, branch, departmentCode, department);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfoModel {\n");
    
    sb.append("    codeUser: ").append(toIndentedString(codeUser)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    bds: ").append(toIndentedString(bds)).append("\n");
    sb.append("    cra: ").append(toIndentedString(cra)).append("\n");
    sb.append("    qlnsBrn: ").append(toIndentedString(qlnsBrn)).append("\n");
    sb.append("    brn: ").append(toIndentedString(brn)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    departmentCode: ").append(toIndentedString(departmentCode)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

