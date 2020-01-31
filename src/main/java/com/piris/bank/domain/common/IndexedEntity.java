package com.piris.bank.domain.common;

import javax.persistence.*;

@MappedSuperclass
public abstract class IndexedEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
