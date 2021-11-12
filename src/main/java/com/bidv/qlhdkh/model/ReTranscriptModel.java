package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import io.swagger.models.auth.In;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReTranscriptModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class ReTranscriptModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("InterestAfterYear")
  private Integer interestAfterYear = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("Note")
  private String note = null;

  @JsonProperty("Author")
  private String author = null;

  public ReTranscriptModel id(Integer id) {
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

  public ReTranscriptModel caseId(Integer caseId) {
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

  public ReTranscriptModel interestAfterYear(Integer interestAfterYear) {
    this.interestAfterYear = interestAfterYear;
    return this;
  }

  /**
   * Get interestAfterYear
   * @return interestAfterYear
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getInterestAfterYear() {
    return interestAfterYear;
  }

  public void setInterestAfterYear(Integer interestAfterYear) {
    this.interestAfterYear = interestAfterYear;
  }

  public ReTranscriptModel content(String content) {
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

  public ReTranscriptModel note(String note) {
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

  public ReTranscriptModel author(String author) {
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
    ReTranscriptModel reTranscriptModel = (ReTranscriptModel) o;
    return Objects.equals(this.id, reTranscriptModel.id) &&
        Objects.equals(this.caseId, reTranscriptModel.caseId) &&
        Objects.equals(this.interestAfterYear, reTranscriptModel.interestAfterYear) &&
        Objects.equals(this.content, reTranscriptModel.content) &&
        Objects.equals(this.note, reTranscriptModel.note) &&
        Objects.equals(this.author, reTranscriptModel.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, interestAfterYear, content, note, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReTranscriptModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    interestAfterYear: ").append(toIndentedString(interestAfterYear)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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

