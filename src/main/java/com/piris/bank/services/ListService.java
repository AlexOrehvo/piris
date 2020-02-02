package com.piris.bank.services;

import com.piris.bank.domain.*;

import java.util.List;

public interface ListService {

    List<Citizenship> getCitizenships();

    List<MaritalStatus> getMaritalStatuses();

    List<Gender> getGenders();

    List<Disability> getDisabilities();

    List<City> getCities();
}
