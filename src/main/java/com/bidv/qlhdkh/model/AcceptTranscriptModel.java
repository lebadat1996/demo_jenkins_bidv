package com.bidv.qlhdkh.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AcceptTranscriptModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class AcceptTranscriptModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("NescesaryScore")
  private Integer nescesaryScore = null;

  @JsonProperty("SuiableScore")
  private Integer suiableScore = null;

  @JsonProperty("ProgressScore")
  private Integer progressScore = null;

  @JsonProperty("QualityScore")
  private Integer qualityScore = null;

  @JsonProperty("RealityScore")
  private Integer realityScore = null;

  @JsonProperty("ContributeScore")
  private Integer contributeScore = null;

  @JsonProperty("EffecScore")
  private Integer effecScore = null;

  @JsonProperty("RangeScore")
  private Integer rangeScore = null;

  @JsonProperty("AbilityDevelop")
  private Integer abilityDevelop = null;

  @JsonProperty("SpecificReview")
  private String specificReview = null;

  @JsonProperty("ContentConclusion")
  private String contentConclusion = null;

  @JsonProperty("Author")
  private String author = null;

  @JsonProperty("Sum")
  private Integer sum = null;

  public AcceptTranscriptModel id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AcceptTranscriptModel caseId(Integer caseId) {
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

  public AcceptTranscriptModel nescesaryScore(Integer nescesaryScore) {
    this.nescesaryScore = nescesaryScore;
    return this;
  }

  /**
   * Get nescesaryScore
   * @return nescesaryScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getNescesaryScore() {
    return nescesaryScore;
  }

  public void setNescesaryScore(Integer nescesaryScore) {
    this.nescesaryScore = nescesaryScore;
  }

  public AcceptTranscriptModel suiableScore(Integer suiableScore) {
    this.suiableScore = suiableScore;
    return this;
  }

  /**
   * Get suiableScore
   * @return suiableScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getSuiableScore() {
    return suiableScore;
  }

  public void setSuiableScore(Integer suiableScore) {
    this.suiableScore = suiableScore;
  }

  public AcceptTranscriptModel progressScore(Integer progressScore) {
    this.progressScore = progressScore;
    return this;
  }

  /**
   * Get progressScore
   * @return progressScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getProgressScore() {
    return progressScore;
  }

  public void setProgressScore(Integer progressScore) {
    this.progressScore = progressScore;
  }

  public AcceptTranscriptModel qualityScore(Integer qualityScore) {
    this.qualityScore = qualityScore;
    return this;
  }

  /**
   * Get qualityScore
   * @return qualityScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getQualityScore() {
    return qualityScore;
  }

  public void setQualityScore(Integer qualityScore) {
    this.qualityScore = qualityScore;
  }

  public AcceptTranscriptModel realityScore(Integer realityScore) {
    this.realityScore = realityScore;
    return this;
  }

  /**
   * Get realityScore
   * @return realityScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getRealityScore() {
    return realityScore;
  }

  public void setRealityScore(Integer realityScore) {
    this.realityScore = realityScore;
  }

  public AcceptTranscriptModel contributeScore(Integer contributeScore) {
    this.contributeScore = contributeScore;
    return this;
  }

  /**
   * Get contributeScore
   * @return contributeScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getContributeScore() {
    return contributeScore;
  }

  public void setContributeScore(Integer contributeScore) {
    this.contributeScore = contributeScore;
  }

  public AcceptTranscriptModel effecScore(Integer effecScore) {
    this.effecScore = effecScore;
    return this;
  }

  /**
   * Get effecScore
   * @return effecScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getEffecScore() {
    return effecScore;
  }

  public void setEffecScore(Integer effecScore) {
    this.effecScore = effecScore;
  }

  public AcceptTranscriptModel rangeScore(Integer rangeScore) {
    this.rangeScore = rangeScore;
    return this;
  }

  /**
   * Get rangeScore
   * @return rangeScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getRangeScore() {
    return rangeScore;
  }

  public void setRangeScore(Integer rangeScore) {
    this.rangeScore = rangeScore;
  }

  public AcceptTranscriptModel abilityDevelop(Integer abilityDevelop) {
    this.abilityDevelop = abilityDevelop;
    return this;
  }

  /**
   * Get abilityDevelop
   * @return abilityDevelop
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getAbilityDevelop() {
    return abilityDevelop;
  }

  public void setAbilityDevelop(Integer abilityDevelop) {
    this.abilityDevelop = abilityDevelop;
  }

  public AcceptTranscriptModel specificReview(String specificReview) {
    this.specificReview = specificReview;
    return this;
  }

  /**
   * Get specificReview
   * @return specificReview
   **/
  @ApiModelProperty(value = "")


  public String getSpecificReview() {
    return specificReview;
  }

  public void setSpecificReview(String specificReview) {
    this.specificReview = specificReview;
  }

  public AcceptTranscriptModel contentConclusion(String contentConclusion) {
    this.contentConclusion = contentConclusion;
    return this;
  }

  /**
   * Get contentConclusion
   * @return contentConclusion
   **/
  @ApiModelProperty(value = "")


  public String getContentConclusion() {
    return contentConclusion;
  }

  public void setContentConclusion(String contentConclusion) {
    this.contentConclusion = contentConclusion;
  }

  public AcceptTranscriptModel author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
  @ApiModelProperty(value = "")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public AcceptTranscriptModel sum(Integer sum) {
    this.sum = sum;
    return this;
  }

  /**
   * Get sum
   * @return sum
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getSum() {
    return sum;
  }

  public void setSum(Integer sum) {
    this.sum = sum;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcceptTranscriptModel acceptTranscriptModel = (AcceptTranscriptModel) o;
    return Objects.equals(this.id, acceptTranscriptModel.id) &&
            Objects.equals(this.caseId, acceptTranscriptModel.caseId) &&
            Objects.equals(this.nescesaryScore, acceptTranscriptModel.nescesaryScore) &&
            Objects.equals(this.suiableScore, acceptTranscriptModel.suiableScore) &&
            Objects.equals(this.progressScore, acceptTranscriptModel.progressScore) &&
            Objects.equals(this.qualityScore, acceptTranscriptModel.qualityScore) &&
            Objects.equals(this.realityScore, acceptTranscriptModel.realityScore) &&
            Objects.equals(this.contributeScore, acceptTranscriptModel.contributeScore) &&
            Objects.equals(this.effecScore, acceptTranscriptModel.effecScore) &&
            Objects.equals(this.rangeScore, acceptTranscriptModel.rangeScore) &&
            Objects.equals(this.abilityDevelop, acceptTranscriptModel.abilityDevelop) &&
            Objects.equals(this.specificReview, acceptTranscriptModel.specificReview) &&
            Objects.equals(this.contentConclusion, acceptTranscriptModel.contentConclusion) &&
            Objects.equals(this.author, acceptTranscriptModel.author) &&
            Objects.equals(this.sum, acceptTranscriptModel.sum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, nescesaryScore, suiableScore, progressScore, qualityScore, realityScore, contributeScore, effecScore, rangeScore, abilityDevelop, specificReview, contentConclusion, author, sum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcceptTranscriptModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    nescesaryScore: ").append(toIndentedString(nescesaryScore)).append("\n");
    sb.append("    suiableScore: ").append(toIndentedString(suiableScore)).append("\n");
    sb.append("    progressScore: ").append(toIndentedString(progressScore)).append("\n");
    sb.append("    qualityScore: ").append(toIndentedString(qualityScore)).append("\n");
    sb.append("    realityScore: ").append(toIndentedString(realityScore)).append("\n");
    sb.append("    contributeScore: ").append(toIndentedString(contributeScore)).append("\n");
    sb.append("    effecScore: ").append(toIndentedString(effecScore)).append("\n");
    sb.append("    rangeScore: ").append(toIndentedString(rangeScore)).append("\n");
    sb.append("    abilityDevelop: ").append(toIndentedString(abilityDevelop)).append("\n");
    sb.append("    specificReview: ").append(toIndentedString(specificReview)).append("\n");
    sb.append("    contentConclusion: ").append(toIndentedString(contentConclusion)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
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

