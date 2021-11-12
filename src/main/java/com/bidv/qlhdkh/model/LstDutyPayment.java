package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstDutyPayment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstDutyPayment   {
  @JsonProperty("DutyPaymentModel")
  @Valid
  private List<DutyPaymentModel> dutyPaymentModel = null;

  public LstDutyPayment dutyPaymentModel(List<DutyPaymentModel> dutyPaymentModel) {
    this.dutyPaymentModel = dutyPaymentModel;
    return this;
  }

  public LstDutyPayment addDutyPaymentModelItem(DutyPaymentModel dutyPaymentModelItem) {
    if (this.dutyPaymentModel == null) {
      this.dutyPaymentModel = new ArrayList<DutyPaymentModel>();
    }
    this.dutyPaymentModel.add(dutyPaymentModelItem);
    return this;
  }

  /**
   * Get dutyPaymentModel
   * @return dutyPaymentModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<DutyPaymentModel> getDutyPaymentModel() {
    return dutyPaymentModel;
  }

  public void setDutyPaymentModel(List<DutyPaymentModel> dutyPaymentModel) {
    this.dutyPaymentModel = dutyPaymentModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstDutyPayment lstDutyPayment = (LstDutyPayment) o;
    return Objects.equals(this.dutyPaymentModel, lstDutyPayment.dutyPaymentModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dutyPaymentModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstDutyPayment {\n");
    
    sb.append("    dutyPaymentModel: ").append(toIndentedString(dutyPaymentModel)).append("\n");
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

