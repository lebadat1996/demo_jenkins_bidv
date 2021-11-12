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
 * DutyPaymentModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class DutyPaymentModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("Cost")
  private Float cost = null;

  @JsonProperty("EvaluateEffect")
  private String evaluateEffect = null;

  @JsonProperty("Note")
  private String note = null;

  public DutyPaymentModel id(Integer id) {
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

  public DutyPaymentModel caseId(Integer caseId) {
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

  public DutyPaymentModel content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
   **/
  @ApiModelProperty(value = "")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public DutyPaymentModel cost(Float cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getCost() {
    return cost;
  }

  public void setCost(Float cost) {
    this.cost = cost;
  }

  public DutyPaymentModel evaluateEffect(String evaluateEffect) {
    this.evaluateEffect = evaluateEffect;
    return this;
  }

  /**
   * Get evaluateEffect
   * @return evaluateEffect
   **/
  @ApiModelProperty(value = "")


  public String getEvaluateEffect() {
    return evaluateEffect;
  }

  public void setEvaluateEffect(String evaluateEffect) {
    this.evaluateEffect = evaluateEffect;
  }

  public DutyPaymentModel note(String note) {
    this.note = note;
    return this;
  }

  /**
   * Get note
   * @return note
   **/
  @ApiModelProperty(value = "")


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DutyPaymentModel dutyPaymentModel = (DutyPaymentModel) o;
    return Objects.equals(this.id, dutyPaymentModel.id) &&
            Objects.equals(this.caseId, dutyPaymentModel.caseId) &&
            Objects.equals(this.content, dutyPaymentModel.content) &&
            Objects.equals(this.cost, dutyPaymentModel.cost) &&
            Objects.equals(this.evaluateEffect, dutyPaymentModel.evaluateEffect) &&
            Objects.equals(this.note, dutyPaymentModel.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, content, cost, evaluateEffect, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DutyPaymentModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    evaluateEffect: ").append(toIndentedString(evaluateEffect)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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

