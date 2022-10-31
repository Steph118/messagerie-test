package com.example.myapplication.fragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.myapplication.databinding.FragmentDetailReceiveMessageBinding;
import com.example.myapplication.entites.MessageEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DetailReceiveMessageFragment extends Fragment {

    FragmentDetailReceiveMessageBinding binding;
    MessageEntity messageEntity;

    public DetailReceiveMessageFragment(){
    }

    public static  DetailReceiveMessageFragment newInstance(){
        return  new DetailReceiveMessageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailReceiveMessageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getFragmentArguments();

        /*Bundle bundle = getArguments();
        sfd =bundle.getString("sfd");
        objet = bundle.getString("objet");
        binding.detailObjetReceiveMessage.setText(sfd);
        binding.detailObjetReceiveMessage.setText(objet);*/
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getFragmentArguments() {
        Bundle bundle = getArguments();
        /*sfd =bundle.getString("sfd");
        objet = bundle.getString("objet");
        content = bundle.getString("content");
        date = bundle.getString("date");*/
        messageEntity = (MessageEntity) bundle.getSerializable("message");
        binding.detailMessageReceiveMessage.setText(messageEntity.getContent());
        binding.detailDateReceiveMessage.setText(formatter(messageEntity.getDateTime()));
        binding.detailObjetReceiveMessage.setText(messageEntity.getObject());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String formatter(LocalDateTime ldt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return ldt.format(formatter);
    }

    /*public void display(){
        binding.detailObjetReceiveMessage.setText(sfd);
        binding.detailObjetReceiveMessage.setText(objet);
    }*/
}