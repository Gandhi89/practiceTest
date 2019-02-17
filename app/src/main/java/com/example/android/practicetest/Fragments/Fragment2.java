package com.example.android.practicetest.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.practicetest.Adapter.RecyclerAdapter;
import com.example.android.practicetest.Entity.Student;
import com.example.android.practicetest.R;
import com.example.android.practicetest.ViewModel.ViewModel;

import java.util.List;


public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    ViewModel viewModel;
    RecyclerAdapter adapter;

    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container, false);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.fragment2_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerAdapter(view.getContext(), null);
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);

        viewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                adapter.setStudents(students);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
