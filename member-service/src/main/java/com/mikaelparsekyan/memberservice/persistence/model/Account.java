package com.mikaelparsekyan.memberservice.persistence.model;

import com.mikaelparsekyan.common.persistence.model.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Member owner;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(name = "max_with_draw_for_day",
        nullable = false,
        columnDefinition = "bigint default 800"
    )
    private BigDecimal maxWithDrawForDay;
}
