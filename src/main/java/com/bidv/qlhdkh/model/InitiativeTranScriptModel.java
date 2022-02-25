package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InitiativeTranScriptModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class InitiativeTranScriptModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("CreativityScore")
  private Float creativityScore = null;

  @JsonProperty("ScienceScore")
  private Float scienceScore = null;

  @JsonProperty("RealityScore")
  private Float realityScore = null;

  @JsonProperty("EffecScore")
  private Float effecScore = null;

  @JsonProperty("Average")
  private Float average = null;

  @JsonProperty("Conclusion")
  private String conclusion = null;

  @JsonProperty("Sugguest")
  private String sugguest = null;

  @JsonProperty("AddRequest")
  private String addRequest = null;

  @JsonProperty("Department")
  private String department = null;

  @JsonProperty("ProjectName")
  private String projectName = null;

  @JsonProperty("Interest")
  private String interest = null;

  @JsonProperty("Author")
  private String author = null;

  public InitiativeTranScriptModel id(Integer id) {
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

  public InitiativeTranScriptModel caseId(Integer caseId) {
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

  public InitiativeTranScriptModel creativityScore(Float creativityScore) {
    this.creativityScore = creativityScore;
    return this;
  }

  /**
   * Get creativityScore
   * @return creativityScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getCreativityScore() {
    return creativityScore;
  }

  public void setCreativityScore(Float creativityScore) {
    this.creativityScore = creativityScore;
  }

  public InitiativeTranScriptModel scienceScore(Float scienceScore) {
    this.scienceScore = scienceScore;
    return this;
  }

  /**
   * Get scienceScore
   * @return scienceScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getScienceScore() {
    return scienceScore;
  }

  public void setScienceScore(Float scienceScore) {
    this.scienceScore = scienceScore;
  }

  public InitiativeTranScriptModel realityScore(Float realityScore) {
    this.realityScore = realityScore;
    return this;
  }

  /**
   * Get realityScore
   * @return realityScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getRealityScore() {
    return realityScore;
  }

  public void setRealityScore(Float realityScore) {
    this.realityScore = realityScore;
  }

  public InitiativeTranScriptModel effecScore(Float effecScore) {
    this.effecScore = effecScore;
    return this;
  }

  /**
   * Get effecScore
   * @return effecScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getEffecScore() {
    return effecScore;
  }

  public void setEffecScore(Float effecScore) {
    this.effecScore = effecScore;
  }

  public InitiativeTranScriptModel average(Float average) {
    this.average = average;
    return this;
  }

  /**
   * Get average
   * @return average
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getAverage() {
    return average;
  }

  public void setAverage(Float average) {
    this.average = average;
  }

  public InitiativeTranScriptModel conclusion(String conclusion) {
    this.conclusion = conclusion;
    return this;
  }

  /**
   * Get conclusion
   * @return conclusion
   **/
  @ApiModelProperty(value = "")


  public String getConclusion() {
    return conclusion;
  }

  public void setConclusion(String conclusion) {
    this.conclusion = conclusion;
  }

  public InitiativeTranScriptModel sugguest(String sugguest) {
    this.sugguest = sugguest;
    return this;
  }

  /**
   * Get sugguest
   * @return sugguest
   **/
  @ApiModelProperty(value = "")


  public String getSugguest() {
    return sugguest;
  }

  public void setSugguest(String sugguest) {
    this.sugguest = sugguest;
  }

  public InitiativeTranScriptModel addRequest(String addRequest) {
    this.addRequest = addRequest;
    return this;
  }

  /**
   * Get addRequest
   * @return addRequest
   **/
  @ApiModelProperty(value = "")


  public String getAddRequest() {
    return addRequest;
  }

  public void setAddRequest(String addRequest) {
    this.addRequest = addRequest;
  }

  public InitiativeTranScriptModel department(String department) {
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

  public InitiativeTranScriptModel projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Get projectName
   * @return projectName
   **/
  @ApiModelProperty(value = "")


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public InitiativeTranScriptModel interest(String interest) {
    this.interest = interest;
    return this;
  }

  /**
   * Get interest
   * @return interest
   **/
  @ApiModelProperty(value = "")

  @Valid

  public String getInterest() {
    return interest;
  }

  public void setInterest(String interest) {
    this.interest = interest;
  }

  public InitiativeTranScriptModel author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
  @ApiModelProperty(value = "")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitiativeTranScriptModel initiativeTranScriptModel = (InitiativeTranScriptModel) o;
    return Objects.equals(this.id, initiativeTranScriptModel.id) &&
            Objects.equals(this.caseId, initiativeTranScriptModel.caseId) &&
            Objects.equals(this.creativityScore, initiativeTranScriptModel.creativityScore) &&
            Objects.equals(this.scienceScore, initiativeTranScriptModel.scienceScore) &&
            Objects.equals(this.realityScore, initiativeTranScriptModel.realityScore) &&
            Objects.equals(this.effecScore, initiativeTranScriptModel.effecScore) &&
            Objects.equals(this.average, initiativeTranScriptModel.average) &&
            Objects.equals(this.conclusion, initiativeTranScriptModel.conclusion) &&
            Objects.equals(this.sugguest, initiativeTranScriptModel.sugguest) &&
            Objects.equals(this.addRequest, initiativeTranScriptModel.addRequest) &&
            Objects.equals(this.department, initiativeTranScriptModel.department) &&
            Objects.equals(this.projectName, initiativeTranScriptModel.projectName) &&
            Objects.equals(this.interest, initiativeTranScriptModel.interest) &&
            Objects.equals(this.author, initiativeTranScriptModel.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, creativityScore, scienceScore, realityScore, effecScore, average, conclusion, sugguest, addRequest, department, projectName, interest, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitiativeTranScriptModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    creativityScore: ").append(toIndentedString(creativityScore)).append("\n");
    sb.append("    scienceScore: ").append(toIndentedString(scienceScore)).append("\n");
    sb.append("    realityScore: ").append(toIndentedString(realityScore)).append("\n");
    sb.append("    effecScore: ").append(toIndentedString(effecScore)).append("\n");
    sb.append("    average: ").append(toIndentedString(average)).append("\n");
    sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
    sb.append("    sugguest: ").append(toIndentedString(sugguest)).append("\n");
    sb.append("    addRequest: ").append(toIndentedString(addRequest)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
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

