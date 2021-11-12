package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstEvaluateDuty
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstEvaluateDuty   {
  @JsonProperty("EvaluateDutyModel")
  @Valid
  private List<EvaluateDutyModel> evaluateDutyModel = null;

  public LstEvaluateDuty evaluateDutyModel(List<EvaluateDutyModel> evaluateDutyModel) {
    this.evaluateDutyModel = evaluateDutyModel;
    return this;
  }

  public LstEvaluateDuty addEvaluateDutyModelItem(EvaluateDutyModel evaluateDutyModelItem) {
    if (this.evaluateDutyModel == null) {
      this.evaluateDutyModel = new ArrayList<EvaluateDutyModel>();
    }
    this.evaluateDutyModel.add(evaluateDutyModelItem);
    return this;
  }

  /**
   * Get evaluateDutyModel
   * @return evaluateDutyModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EvaluateDutyModel> getEvaluateDutyModel() {
    return evaluateDutyModel;
  }

  public void setEvaluateDutyModel(List<EvaluateDutyModel> evaluateDutyModel) {
    this.evaluateDutyModel = evaluateDutyModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstEvaluateDuty lstEvaluateDuty = (LstEvaluateDuty) o;
    return Objects.equals(this.evaluateDutyModel, lstEvaluateDuty.evaluateDutyModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evaluateDutyModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstEvaluateDuty {\n");
    
    sb.append("    evaluateDutyModel: ").append(toIndentedString(evaluateDutyModel)).append("\n");
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

