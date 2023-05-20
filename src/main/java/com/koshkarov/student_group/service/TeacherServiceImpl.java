package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.GrantsDto;
import com.koshkarov.student_group.dto.RatingDto;
import com.koshkarov.student_group.dto.TeacherDto;
import com.koshkarov.student_group.entity.Student;
import com.koshkarov.student_group.entity.Teacher;
import com.koshkarov.student_group.exception_handling.NoSuchDataException;
import com.koshkarov.student_group.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDto> getAllTeacher() {
        return teacherRepository.findAll().stream().map(
                teacher -> {
                    TeacherDto teacherDto = new TeacherDto();
                    teacherDto.setName(teacher.getName());
                    teacherDto.setProfile(teacher.getProfile());
                    teacherDto.setRating(teacher.getRating());
                    return teacherDto;
                }).collect(Collectors.toList());
    }
    @Override
    public TeacherDto getTeacherById(int id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName(teacher.getName());
        teacherDto.setProfile(teacher.getProfile());
        teacherDto.setRating(teacher.getRating());
        return teacherDto;
    }
    @Override
    public void addNewTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setProfile(teacherDto.getProfile());
        teacher.setRating(teacherDto.getRating());
        teacherRepository.save(teacher);
    }
    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = teacherRepository.getReferenceById(id);
        teacherRepository.delete(teacher);
    }
    @Override
    public RatingDto getRating(int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchDataException("перподавателя с таким id не существует"));
        RatingDto ratingDTO = new RatingDto();
        ratingDTO.setId(teacher.getId());
        ratingDTO.setRating(teacher.getRating());
        return ratingDTO;
    }
    @Override
    public void getMoney(GrantsDto grantsDto, int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchDataException("перподавателя с таким id не существует"));
        if (teacher.getSalary() == null) {
            teacher.setSalary(grantsDto.getSum());
            teacherRepository.save(teacher);
        } else {
            teacher.setSalary(teacher.getSalary() + grantsDto.getSum());
        }
        teacherRepository.save(teacher);
    }
}
