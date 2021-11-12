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
 * RoleInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-01T03:58:53.501Z")


public class RoleInfo   {
  @JsonProperty("roleId")
  private String roleId = null;

  @JsonProperty("roleName")
  private String roleName = null;

  @JsonProperty("usrlvl")
  private String usrlvl = null;

  public RoleInfo roleId(String roleId) {
    this.roleId = roleId;
    return this;
  }

  /**
   * Get roleId
   * @return roleId
  **/
  @ApiModelProperty(value = "")


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public RoleInfo roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * Get roleName
   * @return roleName
  **/
  @ApiModelProperty(value = "")


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RoleInfo usrlvl(String usrlvl) {
    this.usrlvl = usrlvl;
    return this;
  }

  /**
   * Get usrlvl
   * @return usrlvl
  **/
  @ApiModelProperty(value = "")


  public String getUsrlvl() {
    return usrlvl;
  }

  public void setUsrlvl(String usrlvl) {
    this.usrlvl = usrlvl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleInfo roleInfo = (RoleInfo) o;
    return Objects.equals(this.roleId, roleInfo.roleId) &&
        Objects.equals(this.roleName, roleInfo.roleName) &&
        Objects.equals(this.usrlvl, roleInfo.usrlvl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, roleName, usrlvl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleInfo {\n");
    
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    usrlvl: ").append(toIndentedString(usrlvl)).append("\n");
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

