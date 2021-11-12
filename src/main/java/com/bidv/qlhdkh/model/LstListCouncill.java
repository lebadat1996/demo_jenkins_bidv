package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListCouncill
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListCouncill   {
  @JsonProperty("ListCouncillModel")
  @Valid
  private List<ListCouncillModel> listCouncillModel = null;

  public LstListCouncill listCouncillModel(List<ListCouncillModel> listCouncillModel) {
    this.listCouncillModel = listCouncillModel;
    return this;
  }

  public LstListCouncill addListCouncillModelItem(ListCouncillModel listCouncillModelItem) {
    if (this.listCouncillModel == null) {
      this.listCouncillModel = new ArrayList<ListCouncillModel>();
    }
    this.listCouncillModel.add(listCouncillModelItem);
    return this;
  }

  /**
   * Get listCouncillModel
   * @return listCouncillModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListCouncillModel> getListCouncillModel() {
    return listCouncillModel;
  }

  public void setListCouncillModel(List<ListCouncillModel> listCouncillModel) {
    this.listCouncillModel = listCouncillModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListCouncill lstListCouncill = (LstListCouncill) o;
    return Objects.equals(this.listCouncillModel, lstListCouncill.listCouncillModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listCouncillModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListCouncill {\n");
    
    sb.append("    listCouncillModel: ").append(toIndentedString(listCouncillModel)).append("\n");
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

