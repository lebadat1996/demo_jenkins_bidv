package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstContentChange
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstContentChange   {
  @JsonProperty("ContentChangeModel")
  @Valid
  private List<ContentChangeModel> contentChangeModel = null;

  public LstContentChange contentChangeModel(List<ContentChangeModel> contentChangeModel) {
    this.contentChangeModel = contentChangeModel;
    return this;
  }

  public LstContentChange addContentChangeModelItem(ContentChangeModel contentChangeModelItem) {
    if (this.contentChangeModel == null) {
      this.contentChangeModel = new ArrayList<ContentChangeModel>();
    }
    this.contentChangeModel.add(contentChangeModelItem);
    return this;
  }

  /**
   * Get contentChangeModel
   * @return contentChangeModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ContentChangeModel> getContentChangeModel() {
    return contentChangeModel;
  }

  public void setContentChangeModel(List<ContentChangeModel> contentChangeModel) {
    this.contentChangeModel = contentChangeModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstContentChange lstContentChange = (LstContentChange) o;
    return Objects.equals(this.contentChangeModel, lstContentChange.contentChangeModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentChangeModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstContentChange {\n");
    
    sb.append("    contentChangeModel: ").append(toIndentedString(contentChangeModel)).append("\n");
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

