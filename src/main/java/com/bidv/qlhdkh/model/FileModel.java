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
 * FileModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-31T02:35:37.542Z")


public class FileModel   {
  @JsonProperty("contentURL")
  private String contentURL = null;

  @JsonProperty("serverName")
  private String serverName = null;

  @JsonProperty("objectId")
  private String objectId = null;

  @JsonProperty("caseId")
  private Integer caseId = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("docId")
  private String docId = null;

  @JsonProperty("docName")
  private String docName = null;

  public FileModel contentURL(String contentURL) {
    this.contentURL = contentURL;
    return this;
  }

  /**
   * Get contentURL
   * @return contentURL
   **/
  @ApiModelProperty(value = "")


  public String getContentURL() {
    return contentURL;
  }

  public void setContentURL(String contentURL) {
    this.contentURL = contentURL;
  }

  public FileModel serverName(String serverName) {
    this.serverName = serverName;
    return this;
  }

  /**
   * Get serverName
   * @return serverName
   **/
  @ApiModelProperty(value = "")


  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public FileModel objectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * Get objectId
   * @return objectId
   **/
  @ApiModelProperty(value = "")


  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public FileModel caseId(Integer caseId) {
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

  public FileModel mimeType(String mimeType) {
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

  public FileModel fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Get fileName
   * @return fileName
   **/
  @ApiModelProperty(value = "")


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public FileModel docId(String docId) {
    this.docId = docId;
    return this;
  }

  /**
   * Get docId
   * @return docId
   **/
  @ApiModelProperty(value = "")


  public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

  public FileModel docName(String docName) {
    this.docName = docName;
    return this;
  }

  /**
   * Get docName
   * @return docName
   **/
  @ApiModelProperty(value = "")


  public String getDocName() {
    return docName;
  }

  public void setDocName(String docName) {
    this.docName = docName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileModel fileModel = (FileModel) o;
    return Objects.equals(this.contentURL, fileModel.contentURL) &&
            Objects.equals(this.serverName, fileModel.serverName) &&
            Objects.equals(this.objectId, fileModel.objectId) &&
            Objects.equals(this.caseId, fileModel.caseId) &&
            Objects.equals(this.mimeType, fileModel.mimeType) &&
            Objects.equals(this.fileName, fileModel.fileName) &&
            Objects.equals(this.docId, fileModel.docId) &&
            Objects.equals(this.docName, fileModel.docName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentURL, serverName, objectId, caseId, mimeType, fileName, docId, docName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileModel {\n");

    sb.append("    contentURL: ").append(toIndentedString(contentURL)).append("\n");
    sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    docId: ").append(toIndentedString(docId)).append("\n");
    sb.append("    docName: ").append(toIndentedString(docName)).append("\n");
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

