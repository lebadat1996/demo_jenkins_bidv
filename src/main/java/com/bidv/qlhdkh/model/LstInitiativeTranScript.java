package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstInitiativeTranScript
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstInitiativeTranScript   {
  @JsonProperty("InitiativeTranScriptModel")
  @Valid
  private List<InitiativeTranScriptModel> initiativeTranScriptModel = null;

  public LstInitiativeTranScript initiativeTranScriptModel(List<InitiativeTranScriptModel> initiativeTranScriptModel) {
    this.initiativeTranScriptModel = initiativeTranScriptModel;
    return this;
  }

  public LstInitiativeTranScript addInitiativeTranScriptModelItem(InitiativeTranScriptModel initiativeTranScriptModelItem) {
    if (this.initiativeTranScriptModel == null) {
      this.initiativeTranScriptModel = new ArrayList<InitiativeTranScriptModel>();
    }
    this.initiativeTranScriptModel.add(initiativeTranScriptModelItem);
    return this;
  }

  /**
   * Get initiativeTranScriptModel
   * @return initiativeTranScriptModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<InitiativeTranScriptModel> getInitiativeTranScriptModel() {
    return initiativeTranScriptModel;
  }

  public void setInitiativeTranScriptModel(List<InitiativeTranScriptModel> initiativeTranScriptModel) {
    this.initiativeTranScriptModel = initiativeTranScriptModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstInitiativeTranScript lstInitiativeTranScript = (LstInitiativeTranScript) o;
    return Objects.equals(this.initiativeTranScriptModel, lstInitiativeTranScript.initiativeTranScriptModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiativeTranScriptModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstInitiativeTranScript {\n");
    
    sb.append("    initiativeTranScriptModel: ").append(toIndentedString(initiativeTranScriptModel)).append("\n");
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

