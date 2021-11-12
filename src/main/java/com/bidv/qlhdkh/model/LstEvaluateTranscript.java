package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstEvaluateTranscript
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstEvaluateTranscript   {
  @JsonProperty("EvaluateTranscriptModel")
  @Valid
  private List<EvaluateTranscriptModel> evaluateTranscriptModel = null;

  public LstEvaluateTranscript evaluateTranscriptModel(List<EvaluateTranscriptModel> evaluateTranscriptModel) {
    this.evaluateTranscriptModel = evaluateTranscriptModel;
    return this;
  }

  public LstEvaluateTranscript addEvaluateTranscriptModelItem(EvaluateTranscriptModel evaluateTranscriptModelItem) {
    if (this.evaluateTranscriptModel == null) {
      this.evaluateTranscriptModel = new ArrayList<EvaluateTranscriptModel>();
    }
    this.evaluateTranscriptModel.add(evaluateTranscriptModelItem);
    return this;
  }

  /**
   * Get evaluateTranscriptModel
   * @return evaluateTranscriptModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EvaluateTranscriptModel> getEvaluateTranscriptModel() {
    return evaluateTranscriptModel;
  }

  public void setEvaluateTranscriptModel(List<EvaluateTranscriptModel> evaluateTranscriptModel) {
    this.evaluateTranscriptModel = evaluateTranscriptModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstEvaluateTranscript lstEvaluateTranscript = (LstEvaluateTranscript) o;
    return Objects.equals(this.evaluateTranscriptModel, lstEvaluateTranscript.evaluateTranscriptModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evaluateTranscriptModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstEvaluateTranscript {\n");
    
    sb.append("    evaluateTranscriptModel: ").append(toIndentedString(evaluateTranscriptModel)).append("\n");
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

