package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListAcceprtCouncil
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListAcceprtCouncil   {
  @JsonProperty("ListAcceprtCouncilModel")
  @Valid
  private List<ListAcceprtCouncilModel> listAcceprtCouncilModel = null;

  public LstListAcceprtCouncil listAcceprtCouncilModel(List<ListAcceprtCouncilModel> listAcceprtCouncilModel) {
    this.listAcceprtCouncilModel = listAcceprtCouncilModel;
    return this;
  }

  public LstListAcceprtCouncil addListAcceprtCouncilModelItem(ListAcceprtCouncilModel listAcceprtCouncilModelItem) {
    if (this.listAcceprtCouncilModel == null) {
      this.listAcceprtCouncilModel = new ArrayList<ListAcceprtCouncilModel>();
    }
    this.listAcceprtCouncilModel.add(listAcceprtCouncilModelItem);
    return this;
  }

  /**
   * Get listAcceprtCouncilModel
   * @return listAcceprtCouncilModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListAcceprtCouncilModel> getListAcceprtCouncilModel() {
    return listAcceprtCouncilModel;
  }

  public void setListAcceprtCouncilModel(List<ListAcceprtCouncilModel> listAcceprtCouncilModel) {
    this.listAcceprtCouncilModel = listAcceprtCouncilModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListAcceprtCouncil lstListAcceprtCouncil = (LstListAcceprtCouncil) o;
    return Objects.equals(this.listAcceprtCouncilModel, lstListAcceprtCouncil.listAcceprtCouncilModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listAcceprtCouncilModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListAcceprtCouncil {\n");
    
    sb.append("    listAcceprtCouncilModel: ").append(toIndentedString(listAcceprtCouncilModel)).append("\n");
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

