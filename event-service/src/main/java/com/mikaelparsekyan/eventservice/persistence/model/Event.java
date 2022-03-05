package com.mikaelparsekyan.eventservice.persistence.model;

import com.mikaelparsekyan.eventservice.enumeration.EventStatus;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(50) default 'UNKNOWN'")
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Column(name = "user_id")
    private String userId;
}
