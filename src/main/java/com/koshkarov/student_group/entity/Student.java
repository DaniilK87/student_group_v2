package com.koshkarov.student_group.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "accept_date")
    private String acceptDate;

    @Column(name = "student_fio")
    private String studentFIO;


    @ManyToOne()
    @JoinColumn(name = "fk_group_id")
    private Group group;




}
