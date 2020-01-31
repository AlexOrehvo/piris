package com.piris.bank.domain;

import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "passports")
@Entity
public class Passport extends UUIDEntity {

    @Column(name = "passport_number", nullable = false, unique = true)
    private String passportNumber;

    @Column(name = "passport_series", nullable = false)
    private String passportSeries;

    @Column(name = "identification_number", nullable =  false, unique =  true)
    private String  identificationNumber;

    @Column(name = "date_of_issue", nullable = false)
    private Date dateOfIssue;

    @Column(name = "placeOfBirth", nullable = false)
    private String placeOfBirth;

    @Column(name = "authority", nullable = false)
    private String authority;
}
