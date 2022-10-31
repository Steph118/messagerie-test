package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentWriteMessageBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class WriteMessageFragment extends Fragment {

    private FragmentWriteMessageBinding binding;

    public WriteMessageFragment() {
    }

    public static WriteMessageFragment newInstance(){
        return new WriteMessageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentWriteMessageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Write a message");
        //sendMessage();
    }
/*
    public void goodFeedBack(View view){
        Snackbar.make(view,"Message envoyé", BaseTransientBottomBar.LENGTH_LONG)
                .setAction("retour", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();

    }
    public void sendMessage(){
        binding.buttonSendMessageWriting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goodFeedBack(view);
            }
        });
    }*/
}