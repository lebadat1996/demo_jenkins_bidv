package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CouncilModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-02T01:44:17.865Z")


public class CouncilModel {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("councilId")
    private String councilId = null;

    @JsonProperty("subject")
    private String subject = null;

    @JsonProperty("dateCreate")
    private String dateCreate = null;

    @JsonProperty("dateModify")
    private String dateModify = null;

    @JsonProperty("creator")
    private String creator = null;

    @JsonProperty("modifier")
    private String modifier = null;

    @JsonProperty("timeActive")
    private String timeActive = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("councilName")
    private String councilName = null;

    @JsonProperty("LstCouncilMemberModel")
    private LstListCouncill lstCouncilMemberModel = null;

    public CouncilModel id(Integer id) {
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

    public CouncilModel councilId(String councilId) {
        this.councilId = councilId;
        return this;
    }

    /**
     * Get councilId
     * @return councilId
     **/
    @ApiModelProperty(value = "")


    public String getCouncilId() {
        return councilId;
    }

    public void setCouncilId(String councilId) {
        this.councilId = councilId;
    }

    public CouncilModel subject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get subject
     * @return subject
     **/
    @ApiModelProperty(value = "")


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CouncilModel dateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    /**
     * Get dateCreate
     * @return dateCreate
     **/
    @ApiModelProperty(value = "")


    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public CouncilModel dateModify(String dateModify) {
        this.dateModify = dateModify;
        return this;
    }

    /**
     * Get dateModify
     * @return dateModify
     **/
    @ApiModelProperty(value = "")


    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public CouncilModel creator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * Get creator
     * @return creator
     **/
    @ApiModelProperty(value = "")


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public CouncilModel modifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    /**
     * Get modifier
     * @return modifier
     **/
    @ApiModelProperty(value = "")


    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public CouncilModel timeActive(String timeActive) {
        this.timeActive = timeActive;
        return this;
    }

    /**
     * Get timeActive
     * @return timeActive
     **/
    @ApiModelProperty(value = "")


    public String getTimeActive() {
        return timeActive;
    }

    public void setTimeActive(String timeActive) {
        this.timeActive = timeActive;
    }

    public CouncilModel status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @ApiModelProperty(value = "")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CouncilModel councilName(String councilName) {
        this.councilName = councilName;
        return this;
    }

    /**
     * Get councilName
     * @return councilName
     **/
    @ApiModelProperty(value = "")


    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public CouncilModel lstCouncilMemberModel(LstListCouncill lstCouncilMemberModel) {
        this.lstCouncilMemberModel = lstCouncilMemberModel;
        return this;
    }

    /**
     * Get lstCouncilMemberModel
     * @return lstCouncilMemberModel
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LstListCouncill getLstCouncilMemberModel() {
        return lstCouncilMemberModel;
    }

    public void setLstCouncilMemberModel(LstListCouncill lstCouncilMemberModel) {
        this.lstCouncilMemberModel = lstCouncilMemberModel;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CouncilModel councilModel = (CouncilModel) o;
        return Objects.equals(this.id, councilModel.id) &&
                Objects.equals(this.councilId, councilModel.councilId) &&
                Objects.equals(this.subject, councilModel.subject) &&
                Objects.equals(this.dateCreate, councilModel.dateCreate) &&
                Objects.equals(this.dateModify, councilModel.dateModify) &&
                Objects.equals(this.creator, councilModel.creator) &&
                Objects.equals(this.modifier, councilModel.modifier) &&
                Objects.equals(this.timeActive, councilModel.timeActive) &&
                Objects.equals(this.status, councilModel.status) &&
                Objects.equals(this.councilName, councilModel.councilName) &&
                Objects.equals(this.lstCouncilMemberModel, councilModel.lstCouncilMemberModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, councilId, subject, dateCreate, dateModify, creator, modifier, timeActive, status, councilName, lstCouncilMemberModel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CouncilModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    councilId: ").append(toIndentedString(councilId)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    dateCreate: ").append(toIndentedString(dateCreate)).append("\n");
        sb.append("    dateModify: ").append(toIndentedString(dateModify)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    modifier: ").append(toIndentedString(modifier)).append("\n");
        sb.append("    timeActive: ").append(toIndentedString(timeActive)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    councilName: ").append(toIndentedString(councilName)).append("\n");
        sb.append("    lstCouncilMemberModel: ").append(toIndentedString(lstCouncilMemberModel)).append("\n");
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


