package com.koshkarov.student_group.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "university")
@Data
public class University {

    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "web")
    private String web;

}
