package com.mikaelparsekyan.memberservice.persistence.model;


import com.mikaelparsekyan.common.persistence.model.BaseEntity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @Size(min = 3, max = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 50)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Account> accounts;
}
