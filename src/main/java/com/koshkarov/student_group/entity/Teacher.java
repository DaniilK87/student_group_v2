package com.koshkarov.student_group.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "profile")
    private String profile;
}
