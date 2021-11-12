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
 * ContentStopModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class ContentStopModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("StopReason")
  private String stopReason = null;

  @JsonProperty("DutyCost")
  private Float dutyCost = null;

  @JsonProperty("OtherCost")
  private Float otherCost = null;

  @JsonProperty("TotalCost")
  private Float totalCost = null;

  public ContentStopModel id(Integer id) {
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

  public ContentStopModel caseId(Integer caseId) {
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

  public ContentStopModel stopReason(String stopReason) {
    this.stopReason = stopReason;
    return this;
  }

  /**
   * Get stopReason
   * @return stopReason
   **/
  @ApiModelProperty(value = "")


  public String getStopReason() {
    return stopReason;
  }

  public void setStopReason(String stopReason) {
    this.stopReason = stopReason;
  }

  public ContentStopModel dutyCost(Float dutyCost) {
    this.dutyCost = dutyCost;
    return this;
  }

  /**
   * Get dutyCost
   * @return dutyCost
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getDutyCost() {
    return dutyCost;
  }

  public void setDutyCost(Float dutyCost) {
    this.dutyCost = dutyCost;
  }

  public ContentStopModel otherCost(Float otherCost) {
    this.otherCost = otherCost;
    return this;
  }

  /**
   * Get otherCost
   * @return otherCost
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getOtherCost() {
    return otherCost;
  }

  public void setOtherCost(Float otherCost) {
    this.otherCost = otherCost;
  }

  public ContentStopModel totalCost(Float totalCost) {
    this.totalCost = totalCost;
    return this;
  }

  /**
   * Get totalCost
   * @return totalCost
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Float totalCost) {
    this.totalCost = totalCost;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentStopModel contentStopModel = (ContentStopModel) o;
    return Objects.equals(this.id, contentStopModel.id) &&
            Objects.equals(this.caseId, contentStopModel.caseId) &&
            Objects.equals(this.stopReason, contentStopModel.stopReason) &&
            Objects.equals(this.dutyCost, contentStopModel.dutyCost) &&
            Objects.equals(this.otherCost, contentStopModel.otherCost) &&
            Objects.equals(this.totalCost, contentStopModel.totalCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, stopReason, dutyCost, otherCost, totalCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentStopModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    stopReason: ").append(toIndentedString(stopReason)).append("\n");
    sb.append("    dutyCost: ").append(toIndentedString(dutyCost)).append("\n");
    sb.append("    otherCost: ").append(toIndentedString(otherCost)).append("\n");
    sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
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

