package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstPlanPlusTable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstPlanPlusTable   {
  @JsonProperty("PlanPlusTableModel")
  @Valid
  private List<PlanPlusTableModel> planPlusTableModel = null;

  public LstPlanPlusTable planPlusTableModel(List<PlanPlusTableModel> planPlusTableModel) {
    this.planPlusTableModel = planPlusTableModel;
    return this;
  }

  public LstPlanPlusTable addPlanPlusTableModelItem(PlanPlusTableModel planPlusTableModelItem) {
    if (this.planPlusTableModel == null) {
      this.planPlusTableModel = new ArrayList<PlanPlusTableModel>();
    }
    this.planPlusTableModel.add(planPlusTableModelItem);
    return this;
  }

  /**
   * Get planPlusTableModel
   * @return planPlusTableModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PlanPlusTableModel> getPlanPlusTableModel() {
    return planPlusTableModel;
  }

  public void setPlanPlusTableModel(List<PlanPlusTableModel> planPlusTableModel) {
    this.planPlusTableModel = planPlusTableModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstPlanPlusTable lstPlanPlusTable = (LstPlanPlusTable) o;
    return Objects.equals(this.planPlusTableModel, lstPlanPlusTable.planPlusTableModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planPlusTableModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstPlanPlusTable {\n");
    
    sb.append("    planPlusTableModel: ").append(toIndentedString(planPlusTableModel)).append("\n");
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

