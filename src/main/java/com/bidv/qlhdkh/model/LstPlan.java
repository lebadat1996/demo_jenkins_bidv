package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstPlan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstPlan   {
  @JsonProperty("PlanModel")
  @Valid
  private List<PlanModel> planModel = null;

  public LstPlan planModel(List<PlanModel> planModel) {
    this.planModel = planModel;
    return this;
  }

  public LstPlan addPlanModelItem(PlanModel planModelItem) {
    if (this.planModel == null) {
      this.planModel = new ArrayList<PlanModel>();
    }
    this.planModel.add(planModelItem);
    return this;
  }

  /**
   * Get planModel
   * @return planModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PlanModel> getPlanModel() {
    return planModel;
  }

  public void setPlanModel(List<PlanModel> planModel) {
    this.planModel = planModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstPlan lstPlan = (LstPlan) o;
    return Objects.equals(this.planModel, lstPlan.planModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstPlan {\n");
    
    sb.append("    planModel: ").append(toIndentedString(planModel)).append("\n");
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

