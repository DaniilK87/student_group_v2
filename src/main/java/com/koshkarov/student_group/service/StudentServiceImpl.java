package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.exception_handling.NoSuchDataException;
import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    @Override
    public List<StudentDto> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void addStudent(StudentDto studentDto, int groupId) {
        Student student = new Student();
        LocalDate date = LocalDate.now();
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchDataException("группы с таким id нет"));
        student.setId(studentDto.getId());
        student.setAcceptDate(studentDto.getAcceptDate());
        student.setStudentFIO(studentDto.getStudentFIO());
        if (group.getStudents().size() != 0) {
            group.setStudentCount(group.getStudents().size() + 1);
        } else {
            group.setStudentCount(1);
        }
        student.setAcceptDate(date.toString());
        student.setGroup(group);
        studentRepository.save(student);
    }
    @Override
    public List<StudentDto> getStudentByName(String name) {
        return studentRepository.findStudentByStudentFIOEquals(name).stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
    }
    @Override
    public List<StudentDto> getAllStudentsByGroup(int groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchDataException("группы с таким id нет"));
        return studentRepository.getStudentsByGroup_Id(group.getId()).stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setStudentFIO(student.getStudentFIO());
                    studentDto.setAcceptDate(student.getAcceptDate());
                    return studentDto;
                }).collect(Collectors.toList());
    }
    @Override
    public RatingDto getRating(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchDataException("студента с таким id не существует"));
        RatingDto ratingDTO = new RatingDto();
        ratingDTO.setId(student.getId());
        ratingDTO.setRating(student.getRating());
        return ratingDTO;
    }
    @Override
    public void getMoney(GrantsDto grantsDto, int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchDataException("студента с таким id не существует"));
        if (student.getGrant() == null) {
            student.setGrant(grantsDto.getSum());
            studentRepository.save(student);
        } else {
            student.setGrant(student.getGrant() + grantsDto.getSum());
        }
        studentRepository.save(student);
    }
    @Override
    @Transactional
    public void editStudent(StudentDto studentDto, int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchDataException("студента с таким id не существует"));
        student.setAcceptDate(studentDto.getAcceptDate());
        student.setStudentFIO(studentDto.getStudentFIO());
        student.setRating(studentDto.getRating());
        studentRepository.save(student);
    }
    @Override
    @Transactional
    public void transferStudent(int groupId, int studentId) {
        Group newGroup = groupRepository.findById(groupId).orElseThrow(
                ()-> new NoSuchDataException("нет группы с таким id"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchDataException("студента с таким id не существует"));
        Group oldGroup = groupRepository.findById(student.getGroup().getId()).orElseThrow(
                ()-> new NoSuchDataException("нет группы с таким id"));
        oldGroup.setStudentCount(oldGroup.getStudents().size() - 1);

        if (newGroup.equals(oldGroup)) throw new RuntimeException("перевод невозможен, " +
                "номер новой группы не должен совпадать со старой");

        groupRepository.save(oldGroup);
        student.setGroup(newGroup);
        studentRepository.save(student);
        newGroup.setStudentCount(newGroup.getStudents().size() + 1);
        groupRepository.save(newGroup);
    }
    @Override
    public void deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchDataException("студента с таким id не существует"));
        Group group = groupRepository.getReferenceById(student.getGroup().getId());
        group.setStudentCount(group.getStudents().size() - 1);
        studentRepository.delete(student);
    }
}
