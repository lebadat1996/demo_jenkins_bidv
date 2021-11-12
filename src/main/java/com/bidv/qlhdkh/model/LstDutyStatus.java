package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstDutyStatus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstDutyStatus   {
  @JsonProperty("DutyStatusModel")
  @Valid
  private List<DutyStatusModel> dutyStatusModel = null;

  public LstDutyStatus dutyStatusModel(List<DutyStatusModel> dutyStatusModel) {
    this.dutyStatusModel = dutyStatusModel;
    return this;
  }

  public LstDutyStatus addDutyStatusModelItem(DutyStatusModel dutyStatusModelItem) {
    if (this.dutyStatusModel == null) {
      this.dutyStatusModel = new ArrayList<DutyStatusModel>();
    }
    this.dutyStatusModel.add(dutyStatusModelItem);
    return this;
  }

  /**
   * Get dutyStatusModel
   * @return dutyStatusModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<DutyStatusModel> getDutyStatusModel() {
    return dutyStatusModel;
  }

  public void setDutyStatusModel(List<DutyStatusModel> dutyStatusModel) {
    this.dutyStatusModel = dutyStatusModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstDutyStatus lstDutyStatus = (LstDutyStatus) o;
    return Objects.equals(this.dutyStatusModel, lstDutyStatus.dutyStatusModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dutyStatusModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstDutyStatus {\n");
    
    sb.append("    dutyStatusModel: ").append(toIndentedString(dutyStatusModel)).append("\n");
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

