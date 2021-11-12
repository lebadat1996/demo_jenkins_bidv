package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LstHistories
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstHistories   {
  @JsonProperty("HistoriesModel")
  @Valid
  private List<HistoriesModel> historiesModel = null;

  public LstHistories historiesModel(List<HistoriesModel> historiesModel) {
    this.historiesModel = historiesModel;
    return this;
  }

  public LstHistories addHistoriesModelItem(HistoriesModel historiesModelItem) {
    if (this.historiesModel == null) {
      this.historiesModel = new ArrayList<HistoriesModel>();
    }
    this.historiesModel.add(historiesModelItem);
    return this;
  }

  /**
   * Get historiesModel
   * @return historiesModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<HistoriesModel> getHistoriesModel() {
    return historiesModel;
  }

  public void setHistoriesModel(List<HistoriesModel> historiesModel) {
    this.historiesModel = historiesModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstHistories lstHistories = (LstHistories) o;
    return Objects.equals(this.historiesModel, lstHistories.historiesModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(historiesModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstHistories {\n");
    
    sb.append("    historiesModel: ").append(toIndentedString(historiesModel)).append("\n");
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

