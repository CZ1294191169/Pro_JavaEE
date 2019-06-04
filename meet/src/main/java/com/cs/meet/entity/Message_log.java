package com.cs.meet.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@DynamicUpdate
@Entity
public class Message_log {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer messageId;

    public Integer userId;

    public String message;

    public Integer status;
}
