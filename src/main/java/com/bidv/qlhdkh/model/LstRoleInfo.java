package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * LstRoleInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-01T03:58:53.501Z")


public class LstRoleInfo   {
  @JsonProperty("RoleInfo")
  @Valid
  private List<RoleInfo> roleInfo = null;

  public LstRoleInfo roleInfo(List<RoleInfo> roleInfo) {
    this.roleInfo = roleInfo;
    return this;
  }

  public LstRoleInfo addRoleInfoItem(RoleInfo roleInfoItem) {
    if (this.roleInfo == null) {
      this.roleInfo = new ArrayList<RoleInfo>();
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

  public List<RoleInfo> getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(List<RoleInfo> roleInfo) {
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
    LstRoleInfo lstRoleInfo = (LstRoleInfo) o;
    return Objects.equals(this.roleInfo, lstRoleInfo.roleInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstRoleInfo {\n");
    
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

