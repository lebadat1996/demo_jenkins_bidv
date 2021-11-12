package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstInitiativeStatus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstInitiativeStatus   {
  @JsonProperty("InitiativeStatusModel")
  @Valid
  private List<InitiativeStatusModel> initiativeStatusModel = null;

  public LstInitiativeStatus initiativeStatusModel(List<InitiativeStatusModel> initiativeStatusModel) {
    this.initiativeStatusModel = initiativeStatusModel;
    return this;
  }

  public LstInitiativeStatus addInitiativeStatusModelItem(InitiativeStatusModel initiativeStatusModelItem) {
    if (this.initiativeStatusModel == null) {
      this.initiativeStatusModel = new ArrayList<InitiativeStatusModel>();
    }
    this.initiativeStatusModel.add(initiativeStatusModelItem);
    return this;
  }

  /**
   * Get initiativeStatusModel
   * @return initiativeStatusModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<InitiativeStatusModel> getInitiativeStatusModel() {
    return initiativeStatusModel;
  }

  public void setInitiativeStatusModel(List<InitiativeStatusModel> initiativeStatusModel) {
    this.initiativeStatusModel = initiativeStatusModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstInitiativeStatus lstInitiativeStatus = (LstInitiativeStatus) o;
    return Objects.equals(this.initiativeStatusModel, lstInitiativeStatus.initiativeStatusModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiativeStatusModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstInitiativeStatus {\n");
    
    sb.append("    initiativeStatusModel: ").append(toIndentedString(initiativeStatusModel)).append("\n");
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

