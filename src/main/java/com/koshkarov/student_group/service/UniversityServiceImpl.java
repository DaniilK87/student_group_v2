package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dao.UniversityRepository;
import com.koshkarov.student_group.dto.AddUniversityDto;
import com.koshkarov.student_group.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public void addNewUniversity(AddUniversityDto addUniversityDto) {
        University university = new University();
        university.setCountry(addUniversityDto.getCountry());
        university.setName(addUniversityDto.getName());
        university.setWeb(addUniversityDto.getWeb());
        universityRepository.save(university);
    }
}
