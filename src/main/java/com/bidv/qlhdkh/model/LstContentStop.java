package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LstContentStop
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstContentStop   {
  @JsonProperty("ContentStopModel")
  @Valid
  private List<ContentStopModel> contentStopModel = null;

  public LstContentStop contentStopModel(List<ContentStopModel> contentStopModel) {
    this.contentStopModel = contentStopModel;
    return this;
  }

  public LstContentStop addContentStopModelItem(ContentStopModel contentStopModelItem) {
    if (this.contentStopModel == null) {
      this.contentStopModel = new ArrayList<ContentStopModel>();
    }
    this.contentStopModel.add(contentStopModelItem);
    return this;
  }

  /**
   * Get contentStopModel
   * @return contentStopModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ContentStopModel> getContentStopModel() {
    return contentStopModel;
  }

  public void setContentStopModel(List<ContentStopModel> contentStopModel) {
    this.contentStopModel = contentStopModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstContentStop lstContentStop = (LstContentStop) o;
    return Objects.equals(this.contentStopModel, lstContentStop.contentStopModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentStopModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstContentStop {\n");
    
    sb.append("    contentStopModel: ").append(toIndentedString(contentStopModel)).append("\n");
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

