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
 * ResponseFile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T09:08:04.701Z")


public class ResponseFile   {
  @JsonProperty("nameFile")
  private String nameFile = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  public ResponseFile nameFile(String nameFile) {
    this.nameFile = nameFile;
    return this;
  }

  /**
   * Get nameFile
   * @return nameFile
  **/
  @ApiModelProperty(value = "")


  public String getNameFile() {
    return nameFile;
  }

  public void setNameFile(String nameFile) {
    this.nameFile = nameFile;
  }

  public ResponseFile content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(value = "")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ResponseFile mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * Get mimeType
   * @return mimeType
  **/
  @ApiModelProperty(value = "")


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseFile responseFile = (ResponseFile) o;
    return Objects.equals(this.nameFile, responseFile.nameFile) &&
        Objects.equals(this.content, responseFile.content) &&
        Objects.equals(this.mimeType, responseFile.mimeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameFile, content, mimeType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseFile {\n");
    
    sb.append("    nameFile: ").append(toIndentedString(nameFile)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
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

