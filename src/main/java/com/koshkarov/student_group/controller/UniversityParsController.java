package com.koshkarov.student_group.controller;


import com.koshkarov.student_group.dto.UniversityInfoDto;
import com.koshkarov.student_group.service.UniversityParsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Data
@AllArgsConstructor
public class UniversityParsController {

    private UniversityParsService universityParsService;


    @GetMapping("/country/{countryName}")
    public List<UniversityInfoDto> getCountryInfo(@PathVariable String countryName) {
        return universityParsService.getCountryInfo(countryName);
    }

    @GetMapping("/university/{universityName}")
    public List<UniversityInfoDto> getUniversityInfo(@PathVariable String universityName) {
        return universityParsService.getUniversityInfo(universityName);
    }





}
