package com.piris.bank.domain;

import com.piris.bank.common.enums.GenderType;
import com.piris.bank.common.enums.MaritalStatusType;
import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table
@Entity
public class User extends UUIDEntity {

    private String firstName;

    private String lastName;

    private String middleName;

    private Date birthday;

    private GenderType gender;

    private Passport passport;

    private String homePhoneNumber;

    private String mobilePhoneNumber;

    private String email;

    private MaritalStatusType maritalStatus;


}
