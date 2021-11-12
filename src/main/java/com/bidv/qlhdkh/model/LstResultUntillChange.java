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
 * LstResultUntillChange
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstResultUntillChange   {
  @JsonProperty("ResultUntillChangeModel")
  @Valid
  private List<ResultUntillChangeModel> resultUntillChangeModel = null;

  public LstResultUntillChange resultUntillChangeModel(List<ResultUntillChangeModel> resultUntillChangeModel) {
    this.resultUntillChangeModel = resultUntillChangeModel;
    return this;
  }

  public LstResultUntillChange addResultUntillChangeModelItem(ResultUntillChangeModel resultUntillChangeModelItem) {
    if (this.resultUntillChangeModel == null) {
      this.resultUntillChangeModel = new ArrayList<ResultUntillChangeModel>();
    }
    this.resultUntillChangeModel.add(resultUntillChangeModelItem);
    return this;
  }

  /**
   * Get resultUntillChangeModel
   * @return resultUntillChangeModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResultUntillChangeModel> getResultUntillChangeModel() {
    return resultUntillChangeModel;
  }

  public void setResultUntillChangeModel(List<ResultUntillChangeModel> resultUntillChangeModel) {
    this.resultUntillChangeModel = resultUntillChangeModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstResultUntillChange lstResultUntillChange = (LstResultUntillChange) o;
    return Objects.equals(this.resultUntillChangeModel, lstResultUntillChange.resultUntillChangeModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultUntillChangeModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstResultUntillChange {\n");
    
    sb.append("    resultUntillChangeModel: ").append(toIndentedString(resultUntillChangeModel)).append("\n");
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

