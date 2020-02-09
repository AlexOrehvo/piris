package com.piris.bank.domain;

import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Column(name = "place_of_birth", nullable = false)
    private String placeOfBirth;

    @Column(name = "authority", nullable = false)
    private String authority;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getDateOfIssue() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfIssue);
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
