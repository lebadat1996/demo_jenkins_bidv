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
 * ContentChangeModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class ContentChangeModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("StartDate")
  private String startDate = null;

  @JsonProperty("EndDate")
  private String endDate = null;

  @JsonProperty("ChangeTimeReason")
  private String changeTimeReason = null;

  @JsonProperty("ChangeHostReason")
  private String changeHostReason = null;

  public ContentChangeModel id(Integer id) {
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

  public ContentChangeModel caseId(Integer caseId) {
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

  public ContentChangeModel startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/
  @ApiModelProperty(value = "")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public ContentChangeModel endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
   **/
  @ApiModelProperty(value = "")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public ContentChangeModel changeTimeReason(String changeTimeReason) {
    this.changeTimeReason = changeTimeReason;
    return this;
  }

  /**
   * Get changeTimeReason
   * @return changeTimeReason
   **/
  @ApiModelProperty(value = "")


  public String getChangeTimeReason() {
    return changeTimeReason;
  }

  public void setChangeTimeReason(String changeTimeReason) {
    this.changeTimeReason = changeTimeReason;
  }

  public ContentChangeModel changeHostReason(String changeHostReason) {
    this.changeHostReason = changeHostReason;
    return this;
  }

  /**
   * Get changeHostReason
   * @return changeHostReason
   **/
  @ApiModelProperty(value = "")


  public String getChangeHostReason() {
    return changeHostReason;
  }

  public void setChangeHostReason(String changeHostReason) {
    this.changeHostReason = changeHostReason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentChangeModel contentChangeModel = (ContentChangeModel) o;
    return Objects.equals(this.id, contentChangeModel.id) &&
            Objects.equals(this.caseId, contentChangeModel.caseId) &&
            Objects.equals(this.startDate, contentChangeModel.startDate) &&
            Objects.equals(this.endDate, contentChangeModel.endDate) &&
            Objects.equals(this.changeTimeReason, contentChangeModel.changeTimeReason) &&
            Objects.equals(this.changeHostReason, contentChangeModel.changeHostReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, startDate, endDate, changeTimeReason, changeHostReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentChangeModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    changeTimeReason: ").append(toIndentedString(changeTimeReason)).append("\n");
    sb.append("    changeHostReason: ").append(toIndentedString(changeHostReason)).append("\n");
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

