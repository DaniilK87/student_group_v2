package com.koshkarov.student_group.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "group_number")
    private String groupNumber;

    @Column(name = "student_count")
    private int studentCount;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;


}
