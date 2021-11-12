package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * NumberModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-25T12:58:10.898040100+07:00[Asia/Bangkok]")

public class NumberModel   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("numberSequence")
  private Integer numberSequence;

  @JsonProperty("keyNumber")
  private String keyNumber;

  public NumberModel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public NumberModel numberSequence(Integer numberSequence) {
    this.numberSequence = numberSequence;
    return this;
  }

  /**
   * Get numberSequence
   * @return numberSequence
  */
  @ApiModelProperty(value = "")


  public Integer getNumberSequence() {
    return numberSequence;
  }

  public void setNumberSequence(Integer numberSequence) {
    this.numberSequence = numberSequence;
  }

  public NumberModel keyNumber(String keyNumber) {
    this.keyNumber = keyNumber;
    return this;
  }

  /**
   * Get keyNumber
   * @return keyNumber
  */
  @ApiModelProperty(value = "")


  public String getKeyNumber() {
    return keyNumber;
  }

  public void setKeyNumber(String keyNumber) {
    this.keyNumber = keyNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberModel numberModel = (NumberModel) o;
    return Objects.equals(this.id, numberModel.id) &&
        Objects.equals(this.numberSequence, numberModel.numberSequence) &&
        Objects.equals(this.keyNumber, numberModel.keyNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numberSequence, keyNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numberSequence: ").append(toIndentedString(numberSequence)).append("\n");
    sb.append("    keyNumber: ").append(toIndentedString(keyNumber)).append("\n");
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

