package com.example.android.practicetest.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey
    @NonNull
    String studentID;
    String studentName;
    String instructor;
    String course;

    public Student(String studentID, String studentName, String instructor, String course) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.instructor = instructor;
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourse() {
        return course;
    }
}
