package com.example.android.practicetest.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.android.practicetest.Dao.StudentDao;
import com.example.android.practicetest.Entity.Student;

@Database(entities = Student.class, version = 1, exportSchema = false)
public abstract class StudentDb extends RoomDatabase {

    private static volatile StudentDb INSTANCE;
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new AddDataAsyncTask(INSTANCE).execute();
            super.onCreate(db);

        }
    };
    
//     static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//         @Override
//         public void migrate(SupportSQLiteDatabase database) {
//             database.execSQL("CREATE TABLE `student_table` (`studentId` VARCHAR(50), "
//                     + "`studentName` VARCHAR(50),`Instructor` VARCHAR(50),`Course` VARCHAR(50), PRIMARY KEY(`studentId`))");
//         }
//     };
    
    public static StudentDb getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, StudentDb.class, "studentDB")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();

        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

    private static class AddDataAsyncTask extends AsyncTask<Void, Void, Void> {

        StudentDao studentDao;

        public AddDataAsyncTask(StudentDb studentDb) {
            studentDao = studentDb.studentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.insert(new Student("c0767899", "Bill Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767829", "Jill Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767599", "Sam Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767199", "What Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767999", "F*ck Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767399", "Hell Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0765499", "Heaven Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0734299", "Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0778629", "Really Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0434349", "Stop Gates", "Mukesh Ambani", "Business"));
            studentDao.insert(new Student("c0767669", "Go Away Gates", "Mukesh Ambani", "Business"));
            return null;
        }
    }
}
