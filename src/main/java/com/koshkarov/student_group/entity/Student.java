package com.koshkarov.student_group.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private int id;

    @Column(name = "accept_date")
    private String acceptDate;

    @Column(name = "student_fio")
    private String studentPS;

    @Column(name = "fk_group_id")
    private int fkGroupId;

    public Student(int id, String acceptDate, String studentPS, int fkGroupId) {
        this.id = id;
        this.acceptDate = acceptDate;
        this.studentPS = studentPS;
        this.fkGroupId = fkGroupId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getStudentPS() {
        return studentPS;
    }

    public void setStudentPS(String studentPS) {
        this.studentPS = studentPS;
    }

    public int getFkGroupId() {
        return fkGroupId;
    }

    public void setFkGroupId(int fkGroupId) {
        this.fkGroupId = fkGroupId;
    }
}
