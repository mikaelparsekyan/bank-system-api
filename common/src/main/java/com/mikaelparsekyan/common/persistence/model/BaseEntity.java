package com.mikaelparsekyan.common.persistence.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id()
    @NotNull
    @Type(type = "pg-uuid")
    @Column(columnDefinition = "uuid", unique = true)
    private UUID id;

    /**
     * Make sure id exists before insert
     */
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}
