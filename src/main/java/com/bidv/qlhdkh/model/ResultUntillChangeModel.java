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
 * ResultUntillChangeModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class ResultUntillChangeModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("ExpectProduct")
  private String expectProduct = null;

  @JsonProperty("ActualProduct")
  private String actualProduct = null;

  public ResultUntillChangeModel id(Integer id) {
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

  public ResultUntillChangeModel caseId(Integer caseId) {
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

  public ResultUntillChangeModel expectProduct(String expectProduct) {
    this.expectProduct = expectProduct;
    return this;
  }

  /**
   * Get expectProduct
   * @return expectProduct
  **/
  @ApiModelProperty(value = "")


  public String getExpectProduct() {
    return expectProduct;
  }

  public void setExpectProduct(String expectProduct) {
    this.expectProduct = expectProduct;
  }

  public ResultUntillChangeModel actualProduct(String actualProduct) {
    this.actualProduct = actualProduct;
    return this;
  }

  /**
   * Get actualProduct
   * @return actualProduct
  **/
  @ApiModelProperty(value = "")


  public String getActualProduct() {
    return actualProduct;
  }

  public void setActualProduct(String actualProduct) {
    this.actualProduct = actualProduct;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultUntillChangeModel resultUntillChangeModel = (ResultUntillChangeModel) o;
    return Objects.equals(this.id, resultUntillChangeModel.id) &&
        Objects.equals(this.caseId, resultUntillChangeModel.caseId) &&
        Objects.equals(this.expectProduct, resultUntillChangeModel.expectProduct) &&
        Objects.equals(this.actualProduct, resultUntillChangeModel.actualProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, expectProduct, actualProduct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultUntillChangeModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    expectProduct: ").append(toIndentedString(expectProduct)).append("\n");
    sb.append("    actualProduct: ").append(toIndentedString(actualProduct)).append("\n");
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

