package com.mikaelparsekyan.eventservice.persistence.model;

import com.mikaelparsekyan.common.enumeration.EventStatus;
import com.mikaelparsekyan.common.enumeration.EventType;
import com.mikaelparsekyan.common.persistence.model.BaseEntity;
import com.mikaelparsekyan.common.persistence.model.BaseEntityAudit;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "event")
public class Event extends BaseEntityAudit {

    @Column(nullable = false, columnDefinition = "VARCHAR(50) default 'UNKNOWN'")
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Column(columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private EventType type;

    @Column(name = "user_id")
    private String userId;
}
