package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstAcceptTranscript
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstAcceptTranscript   {
  @JsonProperty("AcceptTranscriptModel")
  @Valid
  private List<AcceptTranscriptModel> acceptTranscriptModel = null;

  public LstAcceptTranscript acceptTranscriptModel(List<AcceptTranscriptModel> acceptTranscriptModel) {
    this.acceptTranscriptModel = acceptTranscriptModel;
    return this;
  }

  public LstAcceptTranscript addAcceptTranscriptModelItem(AcceptTranscriptModel acceptTranscriptModelItem) {
    if (this.acceptTranscriptModel == null) {
      this.acceptTranscriptModel = new ArrayList<AcceptTranscriptModel>();
    }
    this.acceptTranscriptModel.add(acceptTranscriptModelItem);
    return this;
  }

  /**
   * Get acceptTranscriptModel
   * @return acceptTranscriptModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AcceptTranscriptModel> getAcceptTranscriptModel() {
    return acceptTranscriptModel;
  }

  public void setAcceptTranscriptModel(List<AcceptTranscriptModel> acceptTranscriptModel) {
    this.acceptTranscriptModel = acceptTranscriptModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstAcceptTranscript lstAcceptTranscript = (LstAcceptTranscript) o;
    return Objects.equals(this.acceptTranscriptModel, lstAcceptTranscript.acceptTranscriptModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptTranscriptModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstAcceptTranscript {\n");
    
    sb.append("    acceptTranscriptModel: ").append(toIndentedString(acceptTranscriptModel)).append("\n");
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

