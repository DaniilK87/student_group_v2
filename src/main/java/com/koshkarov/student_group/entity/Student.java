package com.koshkarov.student_group.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "accept_date")
    private String acceptDate;

    @Column(name = "student_fio")
    private String studentFIO;

    @Column(name = "grants")
    private Integer grant;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,
            CascadeType.PERSIST})
    @JoinColumn(name = "group_id")
    private Group group;

}
