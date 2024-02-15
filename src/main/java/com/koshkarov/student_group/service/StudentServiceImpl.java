package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.exception_handling.NoSuchGroupException;
import com.koshkarov.student_group.exception_handling.NoSuchStudentException;
import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;


    @Override
    public List<StudentDto> getAllStudent() {
        List<com.koshkarov.student_group.entity.Student> students = studentRepository.findAll();
        List<StudentDto> collect = students.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentDto> getStudentByName(String name) {
        List<Student> students = studentRepository.getStudentByStudentFIOContaining(name);
        List<StudentDto> collect = students.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentDto> getAllStudentsByGroup(int groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchGroupException("группы с таким id нет"));
        List<Student> students = studentRepository.getStudentsByGroup_Id(group.getId());
        List<StudentDto> collect = students.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public RatingDTO getRating(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentException("студента с таким id не существует"));
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setId(student.getId());
        ratingDTO.setRating(student.getRating());
        return ratingDTO;
    }

    @Override
    public void getMoney(GrantsDto grantsDto, int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentException("студента с таким id не существует"));
        if (student.getGrant() == null) {
            student.setGrant(grantsDto.getGrant());
            studentRepository.save(student);
        } else {
            student.setGrant(student.getGrant() + grantsDto.getGrant());
        }
        studentRepository.save(student);
    }

    @Override
    public void editStudent(EditStudentDto editStudentDto, int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentException("студента с таким id не существует"));
        student.setAcceptDate(editStudentDto.getAcceptDate());
        student.setStudentFIO(editStudentDto.getStudentFIO());
        student.setRating(editStudentDto.getRating());
        studentRepository.save(student);
    }

    @Override
    public String deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentException("студента с таким id не существует"));
        studentRepository.deleteById(studentId);
        Group group = groupRepository.getReferenceById(student.getGroup().getId());
        group.setStudentCount(group.getStudents().size() - 1);
        return "Student with ID = " + studentId + " delete";
    }
}
