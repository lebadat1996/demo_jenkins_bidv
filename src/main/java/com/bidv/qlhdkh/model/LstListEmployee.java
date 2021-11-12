package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListEmployee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListEmployee   {
  @JsonProperty("ListEmployeeModel")
  @Valid
  private List<ListEmployeeModel> listEmployeeModel = null;

  public LstListEmployee listEmployeeModel(List<ListEmployeeModel> listEmployeeModel) {
    this.listEmployeeModel = listEmployeeModel;
    return this;
  }

  public LstListEmployee addListEmployeeModelItem(ListEmployeeModel listEmployeeModelItem) {
    if (this.listEmployeeModel == null) {
      this.listEmployeeModel = new ArrayList<ListEmployeeModel>();
    }
    this.listEmployeeModel.add(listEmployeeModelItem);
    return this;
  }

  /**
   * Get listEmployeeModel
   * @return listEmployeeModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListEmployeeModel> getListEmployeeModel() {
    return listEmployeeModel;
  }

  public void setListEmployeeModel(List<ListEmployeeModel> listEmployeeModel) {
    this.listEmployeeModel = listEmployeeModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListEmployee lstListEmployee = (LstListEmployee) o;
    return Objects.equals(this.listEmployeeModel, lstListEmployee.listEmployeeModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listEmployeeModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListEmployee {\n");
    
    sb.append("    listEmployeeModel: ").append(toIndentedString(listEmployeeModel)).append("\n");
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

