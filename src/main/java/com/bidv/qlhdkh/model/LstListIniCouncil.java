package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListIniCouncil
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListIniCouncil   {
  @JsonProperty("ListIniCouncilModel")
  @Valid
  private List<ListIniCouncilModel> listIniCouncilModel = null;

  public LstListIniCouncil listIniCouncilModel(List<ListIniCouncilModel> listIniCouncilModel) {
    this.listIniCouncilModel = listIniCouncilModel;
    return this;
  }

  public LstListIniCouncil addListIniCouncilModelItem(ListIniCouncilModel listIniCouncilModelItem) {
    if (this.listIniCouncilModel == null) {
      this.listIniCouncilModel = new ArrayList<ListIniCouncilModel>();
    }
    this.listIniCouncilModel.add(listIniCouncilModelItem);
    return this;
  }

  /**
   * Get listIniCouncilModel
   * @return listIniCouncilModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListIniCouncilModel> getListIniCouncilModel() {
    return listIniCouncilModel;
  }

  public void setListIniCouncilModel(List<ListIniCouncilModel> listIniCouncilModel) {
    this.listIniCouncilModel = listIniCouncilModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListIniCouncil lstListIniCouncil = (LstListIniCouncil) o;
    return Objects.equals(this.listIniCouncilModel, lstListIniCouncil.listIniCouncilModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listIniCouncilModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListIniCouncil {\n");
    
    sb.append("    listIniCouncilModel: ").append(toIndentedString(listIniCouncilModel)).append("\n");
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

