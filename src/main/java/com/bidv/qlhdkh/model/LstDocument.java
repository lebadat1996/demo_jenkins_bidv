package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * LstDocument
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-31T08:09:22.261Z")


public class LstDocument   {
  @JsonProperty("DocModel")
  @Valid
  private List<FileModel> docModel = null;

  public LstDocument docModel(List<FileModel> docModel) {
    this.docModel = docModel;
    return this;
  }

  public LstDocument addDocModelItem(FileModel docModelItem) {
    if (this.docModel == null) {
      this.docModel = new ArrayList<FileModel>();
    }
    this.docModel.add(docModelItem);
    return this;
  }

  /**
   * Get docModel
   * @return docModel
   **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FileModel> getDocModel() {
    return docModel;
  }

  public void setDocModel(List<FileModel> docModel) {
    this.docModel = docModel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LstDocument lstDocument = (LstDocument) o;
    return Objects.equals(this.docModel, lstDocument.docModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LstDocument {\n");

    sb.append("    docModel: ").append(toIndentedString(docModel)).append("\n");
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

