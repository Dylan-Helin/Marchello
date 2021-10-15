package fr.marchello.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
public class Message {

    @Id
    private int id;

    private String message;

    private String senderName;

    @Temporal(TemporalType.DATE)
    private Date date;
}
