package com.koshkarov.student_group.service;


import com.koshkarov.student_group.dto.UniversityInfoDto;

import java.util.List;

public interface UniversityParsService {
    public List<UniversityInfoDto> getCountryInfo(String countryName);

    List<UniversityInfoDto> getUniversityInfo(String universityName);
}
