package com.example.entity;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.MultitenantType;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
@Multitenant(MultitenantType.SINGLE_TABLE)
@TenantDiscriminatorColumn(name = "C_TENANT_ID")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "C_PK")
    private Long id;

    @Column(name = "C_NAME")
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
