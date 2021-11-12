package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LstCouncilMemberModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-01T06:35:03.714Z")


public class LstCouncilMemberModel   {
  @JsonProperty("CouncilMemberModel")
  @Valid
  private List<CouncilMemberModel> councilMemberModel = null;

  public LstCouncilMemberModel councilMemberModel(List<CouncilMemberModel> councilMemberModel) {
    this.councilMemberModel = councilMemberModel;
    return this;
  }

  public LstCouncilMemberModel addCouncilMemberModelItem(CouncilMemberModel councilMemberModelItem) {
    if (this.councilMemberModel == null) {
      this.councilMemberModel = new ArrayList<CouncilMemberModel>();
    }
    this.councilMemberModel.add(councilMemberModelItem);
    return this;
  }

  /**
   * Get councilMemberModel
   * @return councilMemberModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CouncilMemberModel> getCouncilMemberModel() {
    return councilMemberModel;
  }

  public void setCouncilMemberModel(List<CouncilMemberModel> councilMemberModel) {
    this.councilMemberModel = councilMemberModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstCouncilMemberModel lstCouncilMemberModel = (LstCouncilMemberModel) o;
    return Objects.equals(this.councilMemberModel, lstCouncilMemberModel.councilMemberModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(councilMemberModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstCouncilMemberModel {\n");
    
    sb.append("    councilMemberModel: ").append(toIndentedString(councilMemberModel)).append("\n");
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

