package com.example.android.practicetest.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.practicetest.Dao.StudentDao;
import com.example.android.practicetest.Database.StudentDb;
import com.example.android.practicetest.Entity.Student;

import java.util.List;

public class Repo {

    LiveData<List<Student>> allStudents;
    StudentDb studentDb;
    StudentDao studentDao;

    public Repo(Application application) {
        studentDb = StudentDb.getINSTANCE(application);
        studentDao = studentDb.studentDao();
        allStudents = studentDb.studentDao().getAllStudent();
    }

    public void insert(Student student) {
        new insertAsyncTask(studentDao).execute(student);
    }

    public void update(Student student) {
        new updateAsyncTask(studentDao).execute(student);
    }

    public LiveData<List<Student>> getAllStudent() {
        return allStudents;
    }

    public void deleteOneRow(String studentId) {
        new deleteAsyncTask(studentDao).execute(studentId);
    }

    private class insertAsyncTask extends android.os.AsyncTask<Student, Void, Void> {

        StudentDao studentDao;

        public insertAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insert(students[0]);
            return null;
        }
    }

    private class updateAsyncTask extends AsyncTask<Student, Void, Void> {

        StudentDao studentDao;

        public updateAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.update(students[0]);
            return null;
        }
    }

    private class deleteAsyncTask extends android.os.AsyncTask<String, Void, Void> {

        StudentDao studentDao;

        public deleteAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(String... strings) {
            studentDao.deleteOneRow(strings[0]);
            return null;
        }
    }

}
