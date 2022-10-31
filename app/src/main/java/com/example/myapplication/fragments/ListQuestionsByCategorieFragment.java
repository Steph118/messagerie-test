package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class ListQuestionsByCategorieFragment extends Fragment {


    public ListQuestionsByCategorieFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListQuestionsByCategorieFragment newInstance(String param1, String param2) {
        ListQuestionsByCategorieFragment fragment = new ListQuestionsByCategorieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_questions_by_categorie, container, false);
    }
}