package com.bidv.qlhdkh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Email
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-25T12:58:10.898040100+07:00[Asia/Bangkok]")

public class Email {
    @JsonProperty("subject")
    private String subject = null;

    @JsonProperty("toMails")
    @Valid
    private List<String> toMails = null;

    @JsonProperty("mailType")
    private String mailType = null;

    @JsonProperty("codeGen")
    private String codeGen = null;

    @JsonProperty("mailContent")
    private MailContent mailContent = null;

    public Email subject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get subject
     *
     * @return subject
     **/
    @ApiModelProperty(value = "")


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Email toMails(List<String> toMails) {
        this.toMails = toMails;
        return this;
    }

    public Email addToMailsItem(String toMailsItem) {
        if (this.toMails == null) {
            this.toMails = new ArrayList<String>();
        }
        this.toMails.add(toMailsItem);
        return this;
    }

    /**
     * Get toMails
     *
     * @return toMails
     **/
    @ApiModelProperty(value = "")


    public List<String> getToMails() {
        return toMails;
    }

    public void setToMails(List<String> toMails) {
        this.toMails = toMails;
    }

    public Email mailType(String mailType) {
        this.mailType = mailType;
        return this;
    }

    /**
     * Get mailType
     *
     * @return mailType
     **/
    @ApiModelProperty(value = "")


    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public Email codeGen(String codeGen) {
        this.codeGen = codeGen;
        return this;
    }

    /**
     * Get codeGen
     *
     * @return codeGen
     **/
    @ApiModelProperty(value = "")


    public String getCodeGen() {
        return codeGen;
    }

    public void setCodeGen(String codeGen) {
        this.codeGen = codeGen;
    }

    public Email mailContent(MailContent mailContent) {
        this.mailContent = mailContent;
        return this;
    }

    /**
     * Get mailContent
     *
     * @return mailContent
     **/
    @ApiModelProperty(value = "")

    @Valid

    public MailContent getMailContent() {
        return mailContent;
    }

    public void setMailContent(MailContent mailContent) {
        this.mailContent = mailContent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(this.subject, email.subject) &&
                Objects.equals(this.toMails, email.toMails) &&
                Objects.equals(this.mailType, email.mailType) &&
                Objects.equals(this.codeGen, email.codeGen) &&
                Objects.equals(this.mailContent, email.mailContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, toMails, mailType, codeGen, mailContent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Email {\n");

        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    toMails: ").append(toIndentedString(toMails)).append("\n");
        sb.append("    mailType: ").append(toIndentedString(mailType)).append("\n");
        sb.append("    codeGen: ").append(toIndentedString(codeGen)).append("\n");
        sb.append("    mailContent: ").append(toIndentedString(mailContent)).append("\n");
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

