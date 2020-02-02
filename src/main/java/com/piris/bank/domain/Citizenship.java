package com.piris.bank.domain;

import com.piris.bank.domain.common.NamedEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "citizenships")
public class Citizenship extends NamedEntity {
}
