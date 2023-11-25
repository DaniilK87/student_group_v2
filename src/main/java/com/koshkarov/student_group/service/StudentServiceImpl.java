package com.koshkarov.student_group.service;

import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.dto.GrantsResponseDto;
import com.koshkarov.student_group.dto.RatingResponseDTO;
import com.koshkarov.student_group.dto.StudentResponseDto;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;


    @Override
    public List<StudentResponseDto> getAllStudent() {
        List<com.koshkarov.student_group.entity.Student> students = studentRepository.findAll();
        List<StudentResponseDto> collect = students.stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setId(student.getId());
                    studentResponseDto.setStudentPS(student.getStudentFIO());
                    studentResponseDto.setAcceptDate(student.getAcceptDate());
                    return studentResponseDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentResponseDto> getStudentByName(String name) {
        List<Student> students = studentRepository.getStudentByStudentFIOContaining(name);
        List<StudentResponseDto> collect = students.stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setId(student.getId());
                    studentResponseDto.setStudentPS(student.getStudentFIO());
                    studentResponseDto.setAcceptDate(student.getAcceptDate());
                    return studentResponseDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StudentResponseDto> getAllStudentsByGroup(int groupId) {
        List<Student> students = studentRepository.getStudentsByGroup_Id(groupId);
        List<StudentResponseDto> collect = students.stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setId(student.getId());
                    studentResponseDto.setStudentPS(student.getStudentFIO());
                    studentResponseDto.setAcceptDate(student.getAcceptDate());
                    return studentResponseDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public RatingResponseDTO getRating(int id) {
        Student student = studentRepository.getReferenceById(id);
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();
        ratingResponseDTO.setId(student.getId());
        ratingResponseDTO.setRating(student.getRating());
        return ratingResponseDTO;
    }

    @Override
    public void getMoney(GrantsResponseDto grantsResponseDto, int id) {
        Student student = studentRepository.getReferenceById(id);
        if (student.getGrant() == null) {
            student.setGrant(grantsResponseDto.getGrant());
            studentRepository.save(student);
        } else {
            student.setGrant(student.getGrant() + grantsResponseDto.getGrant());
        }
        studentRepository.save(student);
    }


    @Override
    public String deleteStudent(int id) {
        Student student = studentRepository.getReferenceById(id);
        Group group = groupRepository.getReferenceById(student.getGroup().getId());
        group.setStudentCount(group.getStudents().size() - 1);

        studentRepository.delete(student);
        return "Student with ID = " + id + "delete";
    }
}
