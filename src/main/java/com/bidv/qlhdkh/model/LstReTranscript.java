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
 * LstReTranscript
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class LstReTranscript   {
  @JsonProperty("ReTranscriptModel")
  @Valid
  private List<ReTranscriptModel> reTranscriptModel = null;

  public LstReTranscript reTranscriptModel(List<ReTranscriptModel> reTranscriptModel) {
    this.reTranscriptModel = reTranscriptModel;
    return this;
  }

  public LstReTranscript addReTranscriptModelItem(ReTranscriptModel reTranscriptModelItem) {
    if (this.reTranscriptModel == null) {
      this.reTranscriptModel = new ArrayList<ReTranscriptModel>();
    }
    this.reTranscriptModel.add(reTranscriptModelItem);
    return this;
  }

  /**
   * Get reTranscriptModel
   * @return reTranscriptModel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ReTranscriptModel> getReTranscriptModel() {
    return reTranscriptModel;
  }

  public void setReTranscriptModel(List<ReTranscriptModel> reTranscriptModel) {
    this.reTranscriptModel = reTranscriptModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstReTranscript lstReTranscript = (LstReTranscript) o;
    return Objects.equals(this.reTranscriptModel, lstReTranscript.reTranscriptModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reTranscriptModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstReTranscript {\n");
    
    sb.append("    reTranscriptModel: ").append(toIndentedString(reTranscriptModel)).append("\n");
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

