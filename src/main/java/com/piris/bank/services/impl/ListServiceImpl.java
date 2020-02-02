package com.piris.bank.services.impl;

import com.piris.bank.domain.*;
import com.piris.bank.repository.*;
import com.piris.bank.services.ListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    private CitizenshipRepository citizenshipRepository;
    private DisabilityRepository disabilityRepository;
    private GenderRepository genderRepository;
    private MaritalStatusRepository maritalStatusRepository;
    private CityRepository cityRepository;

    public ListServiceImpl(CitizenshipRepository citizenshipRepository, DisabilityRepository disabilityRepository, GenderRepository genderRepository, MaritalStatusRepository maritalStatusRepository, CityRepository cityRepository) {
        this.citizenshipRepository = citizenshipRepository;
        this.disabilityRepository = disabilityRepository;
        this.genderRepository = genderRepository;
        this.maritalStatusRepository = maritalStatusRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Citizenship> getCitizenships() {
        return citizenshipRepository.findAll();
    }

    @Override
    public List<MaritalStatus> getMaritalStatuses() {
        return maritalStatusRepository.findAll();
    }

    @Override
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }

    @Override
    public List<Disability> getDisabilities() {
        return disabilityRepository.findAll();
    }

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
