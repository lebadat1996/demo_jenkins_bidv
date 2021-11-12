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
 * CadresInforModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class CadresInforModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("UserId")
  private String userId = null;

  @JsonProperty("FullName")
  private String fullName = null;

  @JsonProperty("JobTitle")
  private String jobTitle = null;

  @JsonProperty("Email")
  private String email = null;

  @JsonProperty("PhoneNumber")
  private String phoneNumber = null;

  @JsonProperty("UserName")
  private String userName = null;

  @JsonProperty("Bds")
  private String bds = null;

  @JsonProperty("Cra")
  private String cra = null;

  @JsonProperty("Brn")
  private String brn = null;

  @JsonProperty("Branch")
  private String branch = null;

  @JsonProperty("DeparmentCode")
  private String deparmentCode = null;

  @JsonProperty("Department")
  private String department = null;

  @JsonProperty("BrnLevel")
  private String brnLevel = null;

  @JsonProperty("GroupXL")
  private String groupXL = null;

  @JsonProperty("Confirm")
  private String confirm = null;

  @JsonProperty("Qualification")
  private String qualification = null;

  @JsonProperty("ContributePercent")
  private String contributePercent = null;

  @JsonProperty("DateofBirth")
  private String dateofBirth = null;

  public CadresInforModel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CadresInforModel caseId(Integer caseId) {
    this.caseId = caseId;
    return this;
  }

  /**
   * Get caseId
   * @return caseId
  **/
  @ApiModelProperty(value = "")


  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }

  public CadresInforModel userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public CadresInforModel fullName(String fullName) {
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

  public CadresInforModel jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  /**
   * Get jobTitle
   * @return jobTitle
  **/
  @ApiModelProperty(value = "")


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public CadresInforModel email(String email) {
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

  public CadresInforModel phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public CadresInforModel userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public CadresInforModel bds(String bds) {
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

  public CadresInforModel cra(String cra) {
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

  public CadresInforModel brn(String brn) {
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

  public CadresInforModel branch(String branch) {
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

  public CadresInforModel deparmentCode(String deparmentCode) {
    this.deparmentCode = deparmentCode;
    return this;
  }

  /**
   * Get deparmentCode
   * @return deparmentCode
  **/
  @ApiModelProperty(value = "")


  public String getDeparmentCode() {
    return deparmentCode;
  }

  public void setDeparmentCode(String deparmentCode) {
    this.deparmentCode = deparmentCode;
  }

  public CadresInforModel department(String department) {
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

  public CadresInforModel brnLevel(String brnLevel) {
    this.brnLevel = brnLevel;
    return this;
  }

  /**
   * Get brnLevel
   * @return brnLevel
  **/
  @ApiModelProperty(value = "")


  public String getBrnLevel() {
    return brnLevel;
  }

  public void setBrnLevel(String brnLevel) {
    this.brnLevel = brnLevel;
  }

  public CadresInforModel groupXL(String groupXL) {
    this.groupXL = groupXL;
    return this;
  }

  /**
   * Get groupXL
   * @return groupXL
  **/
  @ApiModelProperty(value = "")


  public String getGroupXL() {
    return groupXL;
  }

  public void setGroupXL(String groupXL) {
    this.groupXL = groupXL;
  }

  public CadresInforModel confirm(String confirm) {
    this.confirm = confirm;
    return this;
  }

  /**
   * Get confirm
   * @return confirm
  **/
  @ApiModelProperty(value = "")


  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }

  public CadresInforModel qualification(String qualification) {
    this.qualification = qualification;
    return this;
  }

  /**
   * Get qualification
   * @return qualification
  **/
  @ApiModelProperty(value = "")


  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public CadresInforModel contributePercent(String contributePercent) {
    this.contributePercent = contributePercent;
    return this;
  }

  /**
   * Get contributePercent
   * @return contributePercent
  **/
  @ApiModelProperty(value = "")


  public String getContributePercent() {
    return contributePercent;
  }

  public void setContributePercent(String contributePercent) {
    this.contributePercent = contributePercent;
  }

  public CadresInforModel dateofBirth(String dateofBirth) {
    this.dateofBirth = dateofBirth;
    return this;
  }

  /**
   * Get dateofBirth
   * @return dateofBirth
  **/
  @ApiModelProperty(value = "")


  public String getDateofBirth() {
    return dateofBirth;
  }

  public void setDateofBirth(String dateofBirth) {
    this.dateofBirth = dateofBirth;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CadresInforModel cadresInforModel = (CadresInforModel) o;
    return Objects.equals(this.id, cadresInforModel.id) &&
        Objects.equals(this.caseId, cadresInforModel.caseId) &&
        Objects.equals(this.userId, cadresInforModel.userId) &&
        Objects.equals(this.fullName, cadresInforModel.fullName) &&
        Objects.equals(this.jobTitle, cadresInforModel.jobTitle) &&
        Objects.equals(this.email, cadresInforModel.email) &&
        Objects.equals(this.phoneNumber, cadresInforModel.phoneNumber) &&
        Objects.equals(this.userName, cadresInforModel.userName) &&
        Objects.equals(this.bds, cadresInforModel.bds) &&
        Objects.equals(this.cra, cadresInforModel.cra) &&
        Objects.equals(this.brn, cadresInforModel.brn) &&
        Objects.equals(this.branch, cadresInforModel.branch) &&
        Objects.equals(this.deparmentCode, cadresInforModel.deparmentCode) &&
        Objects.equals(this.department, cadresInforModel.department) &&
        Objects.equals(this.brnLevel, cadresInforModel.brnLevel) &&
        Objects.equals(this.groupXL, cadresInforModel.groupXL) &&
        Objects.equals(this.confirm, cadresInforModel.confirm) &&
        Objects.equals(this.qualification, cadresInforModel.qualification) &&
        Objects.equals(this.contributePercent, cadresInforModel.contributePercent) &&
        Objects.equals(this.dateofBirth, cadresInforModel.dateofBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, userId, fullName, jobTitle, email, phoneNumber, userName, bds, cra, brn, branch, deparmentCode, department, brnLevel, groupXL, confirm, qualification, contributePercent, dateofBirth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CadresInforModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    bds: ").append(toIndentedString(bds)).append("\n");
    sb.append("    cra: ").append(toIndentedString(cra)).append("\n");
    sb.append("    brn: ").append(toIndentedString(brn)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    deparmentCode: ").append(toIndentedString(deparmentCode)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    brnLevel: ").append(toIndentedString(brnLevel)).append("\n");
    sb.append("    groupXL: ").append(toIndentedString(groupXL)).append("\n");
    sb.append("    confirm: ").append(toIndentedString(confirm)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    contributePercent: ").append(toIndentedString(contributePercent)).append("\n");
    sb.append("    dateofBirth: ").append(toIndentedString(dateofBirth)).append("\n");
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

