package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstCoHost
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstCoHost   {
  @JsonProperty("CoHostModel")
  @Valid
  private List<CoHostModel> coHostModel = null;

  public LstCoHost coHostModel(List<CoHostModel> coHostModel) {
    this.coHostModel = coHostModel;
    return this;
  }

  public LstCoHost addCoHostModelItem(CoHostModel coHostModelItem) {
    if (this.coHostModel == null) {
      this.coHostModel = new ArrayList<CoHostModel>();
    }
    this.coHostModel.add(coHostModelItem);
    return this;
  }

  /**
   * Get coHostModel
   * @return coHostModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CoHostModel> getCoHostModel() {
    return coHostModel;
  }

  public void setCoHostModel(List<CoHostModel> coHostModel) {
    this.coHostModel = coHostModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstCoHost lstCoHost = (LstCoHost) o;
    return Objects.equals(this.coHostModel, lstCoHost.coHostModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coHostModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstCoHost {\n");
    
    sb.append("    coHostModel: ").append(toIndentedString(coHostModel)).append("\n");
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

