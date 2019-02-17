package com.example.android.practicetest.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.practicetest.Entity.Student;
import com.example.android.practicetest.Repository.Repo;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    public LiveData<List<Student>> allStudents;
    Repo repo;

    public ViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo(application);
    }


    public void insert(Student student) {
        repo.insert(student);
    }

    public void update(Student student) {
        repo.update(student);
    }

    public void deleteOneRow(String studentId) {
        repo.deleteOneRow(studentId);
    }

    public LiveData<List<Student>> getAllStudents() {
        allStudents = repo.getAllStudent();
        return allStudents;
    }
}
