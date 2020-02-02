package com.piris.bank.resource.rest;

import com.piris.bank.domain.*;
import com.piris.bank.services.ListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListResource {

    private ListService listService;

    public ListResource(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("/maritalStatus")
    public List<MaritalStatus> getMaritalStatuses() {
        return listService.getMaritalStatuses();
    }

    @GetMapping("/gender")
    public List<Gender> getGenders() {
        return listService.getGenders();
    }

    @GetMapping("/disability")
    public List<Disability> getDisabilities() {
        return listService.getDisabilities();
    }

    @GetMapping("/citizenship")
    public List<Citizenship> getCitizenships() {
        return listService.getCitizenships();
    }

    @GetMapping("/city")
    public List<City> getCities() {
        return listService.getCities();
    }
}
