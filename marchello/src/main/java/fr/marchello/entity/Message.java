package fr.marchello.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;

import java.util.Date;

@Entity
public class Message {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String message;

    private String senderName;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Set the date to a format without hours, minutes and seconds.
     */
    public void fixDate() {
        this.date.setHours(0);
        this.date.setMinutes(0);
        this.date.setSeconds(0);
    }
}
