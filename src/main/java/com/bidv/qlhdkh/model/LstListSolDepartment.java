package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListSolDepartment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListSolDepartment   {
  @JsonProperty("ListSolDepartmentModel")
  @Valid
  private List<ListSolDepartmentModel> listSolDepartmentModel = null;

  public LstListSolDepartment listSolDepartmentModel(List<ListSolDepartmentModel> listSolDepartmentModel) {
    this.listSolDepartmentModel = listSolDepartmentModel;
    return this;
  }

  public LstListSolDepartment addListSolDepartmentModelItem(ListSolDepartmentModel listSolDepartmentModelItem) {
    if (this.listSolDepartmentModel == null) {
      this.listSolDepartmentModel = new ArrayList<ListSolDepartmentModel>();
    }
    this.listSolDepartmentModel.add(listSolDepartmentModelItem);
    return this;
  }

  /**
   * Get listSolDepartmentModel
   * @return listSolDepartmentModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListSolDepartmentModel> getListSolDepartmentModel() {
    return listSolDepartmentModel;
  }

  public void setListSolDepartmentModel(List<ListSolDepartmentModel> listSolDepartmentModel) {
    this.listSolDepartmentModel = listSolDepartmentModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListSolDepartment lstListSolDepartment = (LstListSolDepartment) o;
    return Objects.equals(this.listSolDepartmentModel, lstListSolDepartment.listSolDepartmentModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listSolDepartmentModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListSolDepartment {\n");
    
    sb.append("    listSolDepartmentModel: ").append(toIndentedString(listSolDepartmentModel)).append("\n");
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

