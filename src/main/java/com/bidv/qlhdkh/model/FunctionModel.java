package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FunctionModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-01T03:58:53.501Z")


public class FunctionModel   {
  @JsonProperty("function")
  private String function = null;

  @JsonProperty("funCode")
  private String funCode = null;

  @JsonProperty("funName")
  private String funName = null;

  @JsonProperty("funLinnk")
  private String funLinnk = null;

  @JsonProperty("funCorder")
  private String funCorder = null;

  @JsonProperty("parentFunc")
  private String parentFunc = null;

  @JsonProperty("subFunc")
  private String subFunc = null;

  @JsonProperty("groupFuncName")
  private String groupFuncName = null;

  @JsonProperty("groupFuncId")
  private String groupFuncId = null;

  @JsonProperty("grFuncId")
  private String grFuncId = null;

  public FunctionModel function(String function) {
    this.function = function;
    return this;
  }

  /**
   * Get function
   * @return function
  **/
  @ApiModelProperty(value = "")


  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public FunctionModel funCode(String funCode) {
    this.funCode = funCode;
    return this;
  }

  /**
   * Get funCode
   * @return funCode
  **/
  @ApiModelProperty(value = "")


  public String getFunCode() {
    return funCode;
  }

  public void setFunCode(String funCode) {
    this.funCode = funCode;
  }

  public FunctionModel funName(String funName) {
    this.funName = funName;
    return this;
  }

  /**
   * Get funName
   * @return funName
  **/
  @ApiModelProperty(value = "")


  public String getFunName() {
    return funName;
  }

  public void setFunName(String funName) {
    this.funName = funName;
  }

  public FunctionModel funLinnk(String funLinnk) {
    this.funLinnk = funLinnk;
    return this;
  }

  /**
   * Get funLinnk
   * @return funLinnk
  **/
  @ApiModelProperty(value = "")


  public String getFunLinnk() {
    return funLinnk;
  }

  public void setFunLinnk(String funLinnk) {
    this.funLinnk = funLinnk;
  }

  public FunctionModel funCorder(String funCorder) {
    this.funCorder = funCorder;
    return this;
  }

  /**
   * Get funCorder
   * @return funCorder
  **/
  @ApiModelProperty(value = "")


  public String getFunCorder() {
    return funCorder;
  }

  public void setFunCorder(String funCorder) {
    this.funCorder = funCorder;
  }

  public FunctionModel parentFunc(String parentFunc) {
    this.parentFunc = parentFunc;
    return this;
  }

  /**
   * Get parentFunc
   * @return parentFunc
  **/
  @ApiModelProperty(value = "")


  public String getParentFunc() {
    return parentFunc;
  }

  public void setParentFunc(String parentFunc) {
    this.parentFunc = parentFunc;
  }

  public FunctionModel subFunc(String subFunc) {
    this.subFunc = subFunc;
    return this;
  }

  /**
   * Get subFunc
   * @return subFunc
  **/
  @ApiModelProperty(value = "")


  public String getSubFunc() {
    return subFunc;
  }

  public void setSubFunc(String subFunc) {
    this.subFunc = subFunc;
  }

  public FunctionModel groupFuncName(String groupFuncName) {
    this.groupFuncName = groupFuncName;
    return this;
  }

  /**
   * Get groupFuncName
   * @return groupFuncName
  **/
  @ApiModelProperty(value = "")


  public String getGroupFuncName() {
    return groupFuncName;
  }

  public void setGroupFuncName(String groupFuncName) {
    this.groupFuncName = groupFuncName;
  }

  public FunctionModel groupFuncId(String groupFuncId) {
    this.groupFuncId = groupFuncId;
    return this;
  }

  /**
   * Get groupFuncId
   * @return groupFuncId
  **/
  @ApiModelProperty(value = "")


  public String getGroupFuncId() {
    return groupFuncId;
  }

  public void setGroupFuncId(String groupFuncId) {
    this.groupFuncId = groupFuncId;
  }

  public FunctionModel grFuncId(String grFuncId) {
    this.grFuncId = grFuncId;
    return this;
  }

  /**
   * Get grFuncId
   * @return grFuncId
  **/
  @ApiModelProperty(value = "")


  public String getGrFuncId() {
    return grFuncId;
  }

  public void setGrFuncId(String grFuncId) {
    this.grFuncId = grFuncId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FunctionModel functionModel = (FunctionModel) o;
    return Objects.equals(this.function, functionModel.function) &&
        Objects.equals(this.funCode, functionModel.funCode) &&
        Objects.equals(this.funName, functionModel.funName) &&
        Objects.equals(this.funLinnk, functionModel.funLinnk) &&
        Objects.equals(this.funCorder, functionModel.funCorder) &&
        Objects.equals(this.parentFunc, functionModel.parentFunc) &&
        Objects.equals(this.subFunc, functionModel.subFunc) &&
        Objects.equals(this.groupFuncName, functionModel.groupFuncName) &&
        Objects.equals(this.groupFuncId, functionModel.groupFuncId) &&
        Objects.equals(this.grFuncId, functionModel.grFuncId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(function, funCode, funName, funLinnk, funCorder, parentFunc, subFunc, groupFuncName, groupFuncId, grFuncId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FunctionModel {\n");
    
    sb.append("    function: ").append(toIndentedString(function)).append("\n");
    sb.append("    funCode: ").append(toIndentedString(funCode)).append("\n");
    sb.append("    funName: ").append(toIndentedString(funName)).append("\n");
    sb.append("    funLinnk: ").append(toIndentedString(funLinnk)).append("\n");
    sb.append("    funCorder: ").append(toIndentedString(funCorder)).append("\n");
    sb.append("    parentFunc: ").append(toIndentedString(parentFunc)).append("\n");
    sb.append("    subFunc: ").append(toIndentedString(subFunc)).append("\n");
    sb.append("    groupFuncName: ").append(toIndentedString(groupFuncName)).append("\n");
    sb.append("    groupFuncId: ").append(toIndentedString(groupFuncId)).append("\n");
    sb.append("    grFuncId: ").append(toIndentedString(grFuncId)).append("\n");
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

