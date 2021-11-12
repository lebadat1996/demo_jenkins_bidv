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
 * EvaluateTranscriptModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-22T14:21:57.637Z")


public class EvaluateTranscriptModel   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("CaseId")
  private Integer caseId = null;

  @JsonProperty("ClearScore")
  private Integer clearScore = null;

  @JsonProperty("TargetScore")
  private Integer targetScore = null;

  @JsonProperty("ContentScore")
  private Integer contentScore = null;

  @JsonProperty("MethodScore")
  private Integer methodScore = null;

  @JsonProperty("SatifyScore")
  private Integer satifyScore = null;

  @JsonProperty("BenefitScore")
  private Integer benefitScore = null;

  @JsonProperty("RealityScore")
  private Integer realityScore = null;

  @JsonProperty("ProgressScore")
  private Integer progressScore = null;

  @JsonProperty("AbilityOwner")
  private Integer abilityOwner = null;

  @JsonProperty("EvaluateBudget")
  private String evaluateBudget = null;

  @JsonProperty("BudgetComment")
  private String budgetComment = null;

  @JsonProperty("Conclusion")
  private String conclusion = null;

  @JsonProperty("ContentConclusion")
  private String contentConclusion = null;

  @JsonProperty("EstimateConclusion")
  private String estimateConclusion = null;

  @JsonProperty("Author")
  private String author = null;

  @JsonProperty("Sum")
  private Integer sum = null;

  public EvaluateTranscriptModel id(Integer id) {
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

  public EvaluateTranscriptModel caseId(Integer caseId) {
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

  public EvaluateTranscriptModel clearScore(Integer clearScore) {
    this.clearScore = clearScore;
    return this;
  }

  /**
   * Get clearScore
   * @return clearScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getClearScore() {
    return clearScore;
  }

  public void setClearScore(Integer clearScore) {
    this.clearScore = clearScore;
  }

  public EvaluateTranscriptModel targetScore(Integer targetScore) {
    this.targetScore = targetScore;
    return this;
  }

  /**
   * Get targetScore
   * @return targetScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getTargetScore() {
    return targetScore;
  }

  public void setTargetScore(Integer targetScore) {
    this.targetScore = targetScore;
  }

  public EvaluateTranscriptModel contentScore(Integer contentScore) {
    this.contentScore = contentScore;
    return this;
  }

  /**
   * Get contentScore
   * @return contentScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getContentScore() {
    return contentScore;
  }

  public void setContentScore(Integer contentScore) {
    this.contentScore = contentScore;
  }

  public EvaluateTranscriptModel methodScore(Integer methodScore) {
    this.methodScore = methodScore;
    return this;
  }

  /**
   * Get methodScore
   * @return methodScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getMethodScore() {
    return methodScore;
  }

  public void setMethodScore(Integer methodScore) {
    this.methodScore = methodScore;
  }

  public EvaluateTranscriptModel satifyScore(Integer satifyScore) {
    this.satifyScore = satifyScore;
    return this;
  }

  /**
   * Get satifyScore
   * @return satifyScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getSatifyScore() {
    return satifyScore;
  }

  public void setSatifyScore(Integer satifyScore) {
    this.satifyScore = satifyScore;
  }

  public EvaluateTranscriptModel benefitScore(Integer benefitScore) {
    this.benefitScore = benefitScore;
    return this;
  }

  /**
   * Get benefitScore
   * @return benefitScore
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getBenefitScore() {
    return benefitScore;
  }

  public void setBenefitScore(Integer benefitScore) {
    this.benefitScore = benefitScore;
  }

  public EvaluateTranscriptModel realityScore(Integer realityScore) {
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

  public EvaluateTranscriptModel progressScore(Integer progressScore) {
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

  public EvaluateTranscriptModel abilityOwner(Integer abilityOwner) {
    this.abilityOwner = abilityOwner;
    return this;
  }

  /**
   * Get abilityOwner
   * @return abilityOwner
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Integer getAbilityOwner() {
    return abilityOwner;
  }

  public void setAbilityOwner(Integer abilityOwner) {
    this.abilityOwner = abilityOwner;
  }

  public EvaluateTranscriptModel evaluateBudget(String evaluateBudget) {
    this.evaluateBudget = evaluateBudget;
    return this;
  }

  /**
   * Get evaluateBudget
   * @return evaluateBudget
   **/
  @ApiModelProperty(value = "")


  public String getEvaluateBudget() {
    return evaluateBudget;
  }

  public void setEvaluateBudget(String evaluateBudget) {
    this.evaluateBudget = evaluateBudget;
  }

  public EvaluateTranscriptModel budgetComment(String budgetComment) {
    this.budgetComment = budgetComment;
    return this;
  }

  /**
   * Get budgetComment
   * @return budgetComment
   **/
  @ApiModelProperty(value = "")


  public String getBudgetComment() {
    return budgetComment;
  }

  public void setBudgetComment(String budgetComment) {
    this.budgetComment = budgetComment;
  }

  public EvaluateTranscriptModel conclusion(String conclusion) {
    this.conclusion = conclusion;
    return this;
  }

  /**
   * Get conclusion
   * @return conclusion
   **/
  @ApiModelProperty(value = "")


  public String getConclusion() {
    return conclusion;
  }

  public void setConclusion(String conclusion) {
    this.conclusion = conclusion;
  }

  public EvaluateTranscriptModel contentConclusion(String contentConclusion) {
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

  public EvaluateTranscriptModel estimateConclusion(String estimateConclusion) {
    this.estimateConclusion = estimateConclusion;
    return this;
  }

  /**
   * Get estimateConclusion
   * @return estimateConclusion
   **/
  @ApiModelProperty(value = "")


  public String getEstimateConclusion() {
    return estimateConclusion;
  }

  public void setEstimateConclusion(String estimateConclusion) {
    this.estimateConclusion = estimateConclusion;
  }

  public EvaluateTranscriptModel author(String author) {
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

  public EvaluateTranscriptModel sum(Integer sum) {
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
    EvaluateTranscriptModel evaluateTranscriptModel = (EvaluateTranscriptModel) o;
    return Objects.equals(this.id, evaluateTranscriptModel.id) &&
            Objects.equals(this.caseId, evaluateTranscriptModel.caseId) &&
            Objects.equals(this.clearScore, evaluateTranscriptModel.clearScore) &&
            Objects.equals(this.targetScore, evaluateTranscriptModel.targetScore) &&
            Objects.equals(this.contentScore, evaluateTranscriptModel.contentScore) &&
            Objects.equals(this.methodScore, evaluateTranscriptModel.methodScore) &&
            Objects.equals(this.satifyScore, evaluateTranscriptModel.satifyScore) &&
            Objects.equals(this.benefitScore, evaluateTranscriptModel.benefitScore) &&
            Objects.equals(this.realityScore, evaluateTranscriptModel.realityScore) &&
            Objects.equals(this.progressScore, evaluateTranscriptModel.progressScore) &&
            Objects.equals(this.abilityOwner, evaluateTranscriptModel.abilityOwner) &&
            Objects.equals(this.evaluateBudget, evaluateTranscriptModel.evaluateBudget) &&
            Objects.equals(this.budgetComment, evaluateTranscriptModel.budgetComment) &&
            Objects.equals(this.conclusion, evaluateTranscriptModel.conclusion) &&
            Objects.equals(this.contentConclusion, evaluateTranscriptModel.contentConclusion) &&
            Objects.equals(this.estimateConclusion, evaluateTranscriptModel.estimateConclusion) &&
            Objects.equals(this.author, evaluateTranscriptModel.author) &&
            Objects.equals(this.sum, evaluateTranscriptModel.sum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, caseId, clearScore, targetScore, contentScore, methodScore, satifyScore, benefitScore, realityScore, progressScore, abilityOwner, evaluateBudget, budgetComment, conclusion, contentConclusion, estimateConclusion, author, sum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvaluateTranscriptModel {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    clearScore: ").append(toIndentedString(clearScore)).append("\n");
    sb.append("    targetScore: ").append(toIndentedString(targetScore)).append("\n");
    sb.append("    contentScore: ").append(toIndentedString(contentScore)).append("\n");
    sb.append("    methodScore: ").append(toIndentedString(methodScore)).append("\n");
    sb.append("    satifyScore: ").append(toIndentedString(satifyScore)).append("\n");
    sb.append("    benefitScore: ").append(toIndentedString(benefitScore)).append("\n");
    sb.append("    realityScore: ").append(toIndentedString(realityScore)).append("\n");
    sb.append("    progressScore: ").append(toIndentedString(progressScore)).append("\n");
    sb.append("    abilityOwner: ").append(toIndentedString(abilityOwner)).append("\n");
    sb.append("    evaluateBudget: ").append(toIndentedString(evaluateBudget)).append("\n");
    sb.append("    budgetComment: ").append(toIndentedString(budgetComment)).append("\n");
    sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
    sb.append("    contentConclusion: ").append(toIndentedString(contentConclusion)).append("\n");
    sb.append("    estimateConclusion: ").append(toIndentedString(estimateConclusion)).append("\n");
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

