package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * LstFunctionModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-01T03:58:53.501Z")


public class LstFunctionModel   {
  @JsonProperty("RoleInfo")
  @Valid
  private List<FunctionModel> roleInfo = null;

  public LstFunctionModel roleInfo(List<FunctionModel> roleInfo) {
    this.roleInfo = roleInfo;
    return this;
  }

  public LstFunctionModel addRoleInfoItem(FunctionModel roleInfoItem) {
    if (this.roleInfo == null) {
      this.roleInfo = new ArrayList<FunctionModel>();
    }
    this.roleInfo.add(roleInfoItem);
    return this;
  }

  /**
   * Get roleInfo
   * @return roleInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FunctionModel> getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(List<FunctionModel> roleInfo) {
    this.roleInfo = roleInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstFunctionModel lstFunctionModel = (LstFunctionModel) o;
    return Objects.equals(this.roleInfo, lstFunctionModel.roleInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstFunctionModel {\n");
    
    sb.append("    roleInfo: ").append(toIndentedString(roleInfo)).append("\n");
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

