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
 * CouncilMemberModel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-01T06:35:03.714Z")


public class CouncilMemberModel   {
  @JsonProperty("memberid")
  private String memberid = null;

  @JsonProperty("councilId")
  private String councilId = null;

  @JsonProperty("NameMember")
  private String nameMember = null;

  @JsonProperty("Position")
  private String position = null;

  public CouncilMemberModel memberid(String memberid) {
    this.memberid = memberid;
    return this;
  }

  /**
   * Get memberid
   * @return memberid
  **/
  @ApiModelProperty(value = "")


  public String getMemberid() {
    return memberid;
  }

  public void setMemberid(String memberid) {
    this.memberid = memberid;
  }

  public CouncilMemberModel councilId(String councilId) {
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

  public CouncilMemberModel nameMember(String nameMember) {
    this.nameMember = nameMember;
    return this;
  }

  /**
   * Get nameMember
   * @return nameMember
  **/
  @ApiModelProperty(value = "")


  public String getNameMember() {
    return nameMember;
  }

  public void setNameMember(String nameMember) {
    this.nameMember = nameMember;
  }

  public CouncilMemberModel position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  **/
  @ApiModelProperty(value = "")


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouncilMemberModel councilMemberModel = (CouncilMemberModel) o;
    return Objects.equals(this.memberid, councilMemberModel.memberid) &&
        Objects.equals(this.councilId, councilMemberModel.councilId) &&
        Objects.equals(this.nameMember, councilMemberModel.nameMember) &&
        Objects.equals(this.position, councilMemberModel.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberid, councilId, nameMember, position);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouncilMemberModel {\n");
    
    sb.append("    memberid: ").append(toIndentedString(memberid)).append("\n");
    sb.append("    councilId: ").append(toIndentedString(councilId)).append("\n");
    sb.append("    nameMember: ").append(toIndentedString(nameMember)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

