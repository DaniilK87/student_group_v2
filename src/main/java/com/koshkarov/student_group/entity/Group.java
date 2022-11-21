package com.koshkarov.student_group.entity;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Column(name = "group_id")
    @GeneratedValue
    @Id
    private int id;

    @Column(name = "group_number")
    private String groupNumber;

    @Column(name = "student_count")
    private int studentCount;

    public Group() {
    }

    public Group(int id, String groupNumber, int studentCount) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.studentCount = studentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
}
