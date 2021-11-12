package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstEvaluateInitiative
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstEvaluateInitiative   {
  @JsonProperty("EvaluateInitiativeModel")
  @Valid
  private List<EvaluateInitiativeModel> evaluateInitiativeModel = null;

  public LstEvaluateInitiative evaluateInitiativeModel(List<EvaluateInitiativeModel> evaluateInitiativeModel) {
    this.evaluateInitiativeModel = evaluateInitiativeModel;
    return this;
  }

  public LstEvaluateInitiative addEvaluateInitiativeModelItem(EvaluateInitiativeModel evaluateInitiativeModelItem) {
    if (this.evaluateInitiativeModel == null) {
      this.evaluateInitiativeModel = new ArrayList<EvaluateInitiativeModel>();
    }
    this.evaluateInitiativeModel.add(evaluateInitiativeModelItem);
    return this;
  }

  /**
   * Get evaluateInitiativeModel
   * @return evaluateInitiativeModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EvaluateInitiativeModel> getEvaluateInitiativeModel() {
    return evaluateInitiativeModel;
  }

  public void setEvaluateInitiativeModel(List<EvaluateInitiativeModel> evaluateInitiativeModel) {
    this.evaluateInitiativeModel = evaluateInitiativeModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstEvaluateInitiative lstEvaluateInitiative = (LstEvaluateInitiative) o;
    return Objects.equals(this.evaluateInitiativeModel, lstEvaluateInitiative.evaluateInitiativeModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evaluateInitiativeModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstEvaluateInitiative {\n");
    
    sb.append("    evaluateInitiativeModel: ").append(toIndentedString(evaluateInitiativeModel)).append("\n");
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

