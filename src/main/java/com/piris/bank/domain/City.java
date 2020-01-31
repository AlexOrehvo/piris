package com.piris.bank.domain;

import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.*;

@Entity
@Table
public class City extends UUIDEntity {

    @Column
    private String name;
}
