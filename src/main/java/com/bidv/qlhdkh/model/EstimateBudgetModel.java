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
 * EstimateBudgetModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class EstimateBudgetModel   {

  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("Rate")
  private Float rate = null;

  @JsonProperty("Quanity")
  private Integer quanity = null;

  @JsonProperty("Amount")
  private Float amount = null;

  @JsonProperty("Note")
  private String note = null;

  public EstimateBudgetModel id(Integer id) {
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

  public EstimateBudgetModel caseId(Integer caseId) {
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

  public EstimateBudgetModel content(String content) {
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

  public EstimateBudgetModel rate(Float rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getRate() {
    return rate;
  }

  public void setRate(Float rate) {
    this.rate = rate;
  }

  public EstimateBudgetModel quanity(Integer quanity) {
    this.quanity = quanity;
    return this;
  }

  /**
   * Get quanity
   * @return quanity
   **/
  @ApiModelProperty(value = "")


  public Integer getQuanity() {
    return quanity;
  }

  public void setQuanity(Integer quanity) {
    this.quanity = quanity;
  }

  public EstimateBudgetModel amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public EstimateBudgetModel note(String note) {
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
    EstimateBudgetModel estimateBudgetModel = (EstimateBudgetModel) o;
    return Objects.equals(this.id, estimateBudgetModel.id) &&
            Objects.equals(this.caseId, estimateBudgetModel.caseId) &&
            Objects.equals(this.content, estimateBudgetModel.content) &&
            Objects.equals(this.rate, estimateBudgetModel.rate) &&
            Objects.equals(this.quanity, estimateBudgetModel.quanity) &&
            Objects.equals(this.amount, estimateBudgetModel.amount) &&
            Objects.equals(this.note, estimateBudgetModel.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, content, rate, quanity, amount, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstimateBudgetModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    quanity: ").append(toIndentedString(quanity)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

