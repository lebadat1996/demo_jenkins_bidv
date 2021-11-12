package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ConfigTopic
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-25T12:58:10.898040100+07:00[Asia/Bangkok]")

public class ConfigTopic   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("nameTopic")
  private String nameTopic;

  @JsonProperty("codeTopic")
  private String codeTopic;

  @JsonProperty("keyTopic")
  private String keyTopic;

  @JsonProperty("parentId")
  private String parentId;

  public ConfigTopic id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConfigTopic nameTopic(String nameTopic) {
    this.nameTopic = nameTopic;
    return this;
  }

  /**
   * Get nameTopic
   * @return nameTopic
  */
  @ApiModelProperty(value = "")


  public String getNameTopic() {
    return nameTopic;
  }

  public void setNameTopic(String nameTopic) {
    this.nameTopic = nameTopic;
  }

  public ConfigTopic codeTopic(String codeTopic) {
    this.codeTopic = codeTopic;
    return this;
  }

  /**
   * Get codeTopic
   * @return codeTopic
  */
  @ApiModelProperty(value = "")


  public String getCodeTopic() {
    return codeTopic;
  }

  public void setCodeTopic(String codeTopic) {
    this.codeTopic = codeTopic;
  }

  public ConfigTopic keyTopic(String keyTopic) {
    this.keyTopic = keyTopic;
    return this;
  }

  /**
   * Get keyTopic
   * @return keyTopic
  */
  @ApiModelProperty(value = "")


  public String getKeyTopic() {
    return keyTopic;
  }

  public void setKeyTopic(String keyTopic) {
    this.keyTopic = keyTopic;
  }

  public ConfigTopic parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Get parentId
   * @return parentId
  */
  @ApiModelProperty(value = "")


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigTopic configTopic = (ConfigTopic) o;
    return Objects.equals(this.id, configTopic.id) &&
        Objects.equals(this.nameTopic, configTopic.nameTopic) &&
        Objects.equals(this.codeTopic, configTopic.codeTopic) &&
        Objects.equals(this.keyTopic, configTopic.keyTopic) &&
        Objects.equals(this.parentId, configTopic.parentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nameTopic, codeTopic, keyTopic, parentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigTopic {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nameTopic: ").append(toIndentedString(nameTopic)).append("\n");
    sb.append("    codeTopic: ").append(toIndentedString(codeTopic)).append("\n");
    sb.append("    keyTopic: ").append(toIndentedString(keyTopic)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
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

