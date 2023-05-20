package com.koshkarov.student_group.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "lessons")
@Data
public class Lesson {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group groupNumber;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
