package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstParty
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstParty   {
  @JsonProperty("PartyModel")
  @Valid
  private List<PartyModel> partyModel = null;

  public LstParty partyModel(List<PartyModel> partyModel) {
    this.partyModel = partyModel;
    return this;
  }

  public LstParty addPartyModelItem(PartyModel partyModelItem) {
    if (this.partyModel == null) {
      this.partyModel = new ArrayList<PartyModel>();
    }
    this.partyModel.add(partyModelItem);
    return this;
  }

  /**
   * Get partyModel
   * @return partyModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PartyModel> getPartyModel() {
    return partyModel;
  }

  public void setPartyModel(List<PartyModel> partyModel) {
    this.partyModel = partyModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstParty lstParty = (LstParty) o;
    return Objects.equals(this.partyModel, lstParty.partyModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstParty {\n");
    
    sb.append("    partyModel: ").append(toIndentedString(partyModel)).append("\n");
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

