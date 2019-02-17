package com.example.android.practicetest.Dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.practicetest.Entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Query("DELETE FROM student_table WHERE studentID = :studentId")
    void deleteOneRow(String studentId);

    @Query("SELECT * FROM student_table")
    LiveData<List<Student>> getAllStudent();

}
