package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListMember
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListMember   {
  @JsonProperty("ListMemberModel")
  @Valid
  private List<ListMemberModel> listMemberModel = null;

  public LstListMember listMemberModel(List<ListMemberModel> listMemberModel) {
    this.listMemberModel = listMemberModel;
    return this;
  }

  public LstListMember addListMemberModelItem(ListMemberModel listMemberModelItem) {
    if (this.listMemberModel == null) {
      this.listMemberModel = new ArrayList<ListMemberModel>();
    }
    this.listMemberModel.add(listMemberModelItem);
    return this;
  }

  /**
   * Get listMemberModel
   * @return listMemberModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListMemberModel> getListMemberModel() {
    return listMemberModel;
  }

  public void setListMemberModel(List<ListMemberModel> listMemberModel) {
    this.listMemberModel = listMemberModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListMember lstListMember = (LstListMember) o;
    return Objects.equals(this.listMemberModel, lstListMember.listMemberModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listMemberModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListMember {\n");
    
    sb.append("    listMemberModel: ").append(toIndentedString(listMemberModel)).append("\n");
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

