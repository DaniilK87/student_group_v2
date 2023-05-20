package com.koshkarov.student_group.controller;


import com.koshkarov.student_group.dto.AddUniversityDto;
import com.koshkarov.student_group.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Data
@AllArgsConstructor
public class UniversityController {

    private UniversityService universityService;

    @PostMapping("/university")
    public void addNewUniversity(@RequestBody AddUniversityDto addUniversityDto) {
        universityService.addNewUniversity(addUniversityDto);
    }

}
