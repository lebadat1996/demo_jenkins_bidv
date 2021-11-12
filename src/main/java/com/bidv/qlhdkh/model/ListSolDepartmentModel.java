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
 * ListSolDepartmentModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class ListSolDepartmentModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("Represent")
  private String represent = null;

  @JsonProperty("DepartmentId")
  private String departmentId = null;

  @JsonProperty("DepartmentName")
  private String departmentName = null;

  public ListSolDepartmentModel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListSolDepartmentModel caseId(Integer caseId) {
    this.caseId = caseId;
    return this;
  }

  /**
   * Get caseId
   * @return caseId
   **/
  @ApiModelProperty(value = "")


  public Integer getCaseId() {
    return caseId;
  }

  public void setCaseId(Integer caseId) {
    this.caseId = caseId;
  }

  public ListSolDepartmentModel represent(String represent) {
    this.represent = represent;
    return this;
  }

  /**
   * Get represent
   * @return represent
   **/
  @ApiModelProperty(value = "")


  public String getRepresent() {
    return represent;
  }

  public void setRepresent(String represent) {
    this.represent = represent;
  }

  public ListSolDepartmentModel departmentId(String departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  /**
   * Get departmentId
   * @return departmentId
   **/
  @ApiModelProperty(value = "")


  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public ListSolDepartmentModel departmentName(String departmentName) {
    this.departmentName = departmentName;
    return this;
  }

  /**
   * Get departmentName
   * @return departmentName
   **/
  @ApiModelProperty(value = "")


  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListSolDepartmentModel listSolDepartmentModel = (ListSolDepartmentModel) o;
    return Objects.equals(this.id, listSolDepartmentModel.id) &&
            Objects.equals(this.caseId, listSolDepartmentModel.caseId) &&
            Objects.equals(this.represent, listSolDepartmentModel.represent) &&
            Objects.equals(this.departmentId, listSolDepartmentModel.departmentId) &&
            Objects.equals(this.departmentName, listSolDepartmentModel.departmentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, represent, departmentId, departmentName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSolDepartmentModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    represent: ").append(toIndentedString(represent)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    departmentName: ").append(toIndentedString(departmentName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

