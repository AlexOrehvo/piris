package com.piris.bank.domain;

import com.piris.bank.domain.common.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marital_statuses")
public class MaritalStatus extends NamedEntity {
}
