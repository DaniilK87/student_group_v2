package com.koshkarov.student_group.dto;


import com.koshkarov.student_group.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditGroupRequestDto {

    private Integer groupId;
    private List<Student> studentList;
}
