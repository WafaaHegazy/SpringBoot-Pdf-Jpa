package me.aboullaite.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the message_header database table.
 *
 */
@Entity
@Table(name="message_header")
@NamedQuery(name="MessageHeader.findAll", query="SELECT m FROM MessageHeader m")
public class MessageHeader implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="MESSAGE_ID")
    private int messageId;

    private String email;

    private String message;

    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="record_add_date")
    private Date recordAddDate;

    @Column(name="record_status")
    private String recordStatus;

    private String subject;

    private String website;

    public MessageHeader() {
    }

    public int getMessageId() {
        return this.messageId;
    }

    public void setMessageId(final int messageId) {
        this.messageId = messageId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getRecordAddDate() {
        return this.recordAddDate;
    }

    public void setRecordAddDate(final Date recordAddDate) {
        this.recordAddDate = recordAddDate;
    }

    public String getRecordStatus() {
        return this.recordStatus;
    }

    public void setRecordStatus(final String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

}