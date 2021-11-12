package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstCouncilModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-08T08:44:46.369Z")


public class LstCouncilModel   {
  @JsonProperty("CouncilModel")
  @Valid
  private List<CouncilModel> councilModel = null;

  public LstCouncilModel councilModel(List<CouncilModel> councilModel) {
    this.councilModel = councilModel;
    return this;
  }

  public LstCouncilModel addCouncilModelItem(CouncilModel councilModelItem) {
    if (this.councilModel == null) {
      this.councilModel = new ArrayList<CouncilModel>();
    }
    this.councilModel.add(councilModelItem);
    return this;
  }

  /**
   * Get councilModel
   * @return councilModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CouncilModel> getCouncilModel() {
    return councilModel;
  }

  public void setCouncilModel(List<CouncilModel> councilModel) {
    this.councilModel = councilModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstCouncilModel lstCouncilModel = (LstCouncilModel) o;
    return Objects.equals(this.councilModel, lstCouncilModel.councilModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(councilModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstCouncilModel {\n");
    
    sb.append("    councilModel: ").append(toIndentedString(councilModel)).append("\n");
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

