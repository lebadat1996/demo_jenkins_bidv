package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstCadresInfor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstCadresInfor   {
  @JsonProperty("CadresInforModel")
  @Valid
  private List<CadresInforModel> cadresInforModel = null;

  public LstCadresInfor cadresInforModel(List<CadresInforModel> cadresInforModel) {
    this.cadresInforModel = cadresInforModel;
    return this;
  }

  public LstCadresInfor addCadresInforModelItem(CadresInforModel cadresInforModelItem) {
    if (this.cadresInforModel == null) {
      this.cadresInforModel = new ArrayList<CadresInforModel>();
    }
    this.cadresInforModel.add(cadresInforModelItem);
    return this;
  }

  /**
   * Get cadresInforModel
   * @return cadresInforModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CadresInforModel> getCadresInforModel() {
    return cadresInforModel;
  }

  public void setCadresInforModel(List<CadresInforModel> cadresInforModel) {
    this.cadresInforModel = cadresInforModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstCadresInfor lstCadresInfor = (LstCadresInfor) o;
    return Objects.equals(this.cadresInforModel, lstCadresInfor.cadresInforModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cadresInforModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstCadresInfor {\n");
    
    sb.append("    cadresInforModel: ").append(toIndentedString(cadresInforModel)).append("\n");
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

