package com.mikaelparsekyan.common.persistence.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntityAudit extends BaseEntity {

    @CreatedBy
    private UUID createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private UUID lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
