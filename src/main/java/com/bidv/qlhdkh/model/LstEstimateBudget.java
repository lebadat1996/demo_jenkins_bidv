package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LstEstimateBudget
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstEstimateBudget   {
  @JsonProperty("EstimateBudgetModel")
  @Valid
  private List<EstimateBudgetModel> estimateBudgetModel = null;

  public LstEstimateBudget estimateBudgetModel(List<EstimateBudgetModel> estimateBudgetModel) {
    this.estimateBudgetModel = estimateBudgetModel;
    return this;
  }

  public LstEstimateBudget addEstimateBudgetModelItem(EstimateBudgetModel estimateBudgetModelItem) {
    if (this.estimateBudgetModel == null) {
      this.estimateBudgetModel = new ArrayList<EstimateBudgetModel>();
    }
    this.estimateBudgetModel.add(estimateBudgetModelItem);
    return this;
  }

  /**
   * Get estimateBudgetModel
   * @return estimateBudgetModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EstimateBudgetModel> getEstimateBudgetModel() {
    return estimateBudgetModel;
  }

  public void setEstimateBudgetModel(List<EstimateBudgetModel> estimateBudgetModel) {
    this.estimateBudgetModel = estimateBudgetModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstEstimateBudget lstEstimateBudget = (LstEstimateBudget) o;
    return Objects.equals(this.estimateBudgetModel, lstEstimateBudget.estimateBudgetModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(estimateBudgetModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstEstimateBudget {\n");
    
    sb.append("    estimateBudgetModel: ").append(toIndentedString(estimateBudgetModel)).append("\n");
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

