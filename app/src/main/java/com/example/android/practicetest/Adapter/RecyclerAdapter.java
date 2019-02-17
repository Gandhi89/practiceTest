package com.example.android.practicetest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.practicetest.Entity.Student;
import com.example.android.practicetest.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    List<Student> students;

    public RecyclerAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        if (students == null) {
            return 0;
        } else {
            return students.size();
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sName, sId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sId = itemView.findViewById(R.id.StudentID);
            sName = itemView.findViewById(R.id.StudentName);
        }

        public void bind(int i) {
            sName.setText(students.get(i).getStudentName());
            sId.setText(students.get(i).getStudentID());
        }
    }
}
