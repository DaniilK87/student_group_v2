package com.koshkarov.student_group.entity;

import jakarta.persistence.*;
import lombok.Data;
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

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE,
            CascadeType.PERSIST}, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students;
}
