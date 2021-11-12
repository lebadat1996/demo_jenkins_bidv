package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstListAuthor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstListAuthor   {
  @JsonProperty("ListAuthorModel")
  @Valid
  private List<ListAuthorModel> listAuthorModel = null;

  public LstListAuthor listAuthorModel(List<ListAuthorModel> listAuthorModel) {
    this.listAuthorModel = listAuthorModel;
    return this;
  }

  public LstListAuthor addListAuthorModelItem(ListAuthorModel listAuthorModelItem) {
    if (this.listAuthorModel == null) {
      this.listAuthorModel = new ArrayList<ListAuthorModel>();
    }
    this.listAuthorModel.add(listAuthorModelItem);
    return this;
  }

  /**
   * Get listAuthorModel
   * @return listAuthorModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ListAuthorModel> getListAuthorModel() {
    return listAuthorModel;
  }

  public void setListAuthorModel(List<ListAuthorModel> listAuthorModel) {
    this.listAuthorModel = listAuthorModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstListAuthor lstListAuthor = (LstListAuthor) o;
    return Objects.equals(this.listAuthorModel, lstListAuthor.listAuthorModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listAuthorModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstListAuthor {\n");
    
    sb.append("    listAuthorModel: ").append(toIndentedString(listAuthorModel)).append("\n");
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

