package com.example.myapplication.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.MessageReceiveAdapter;
import com.example.myapplication.adapters.MessageSendAdapter;
import com.example.myapplication.databinding.FragmentListMessageSendBinding;
import com.example.myapplication.entites.MessageEntity;
import com.example.myapplication.liste.ListMessageReceive;
import com.example.myapplication.liste.ListMessageSend;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListMessageSendFragment extends Fragment {

    private FragmentListMessageSendBinding binding;
    private RecyclerView recyclerViewListMessage;
    private MessageSendAdapter messageSendAdapter;

    public ListMessageSendFragment(){

    }

    public static  ListMessageSendFragment newInstance(){
        return  new ListMessageSendFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListMessageSendBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        addListMessageReceiver();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<MessageEntity> remplirListe(){
        Comparator<MessageEntity> reverseComparator = (c1, c2) -> {
            return c2.getDateTime().compareTo(c1.getDateTime());
        };
        List<MessageEntity> list = ListMessageSend.addListMessageSend();
        Collections.sort(list, reverseComparator);
        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addListMessageReceiver(){
        recyclerViewListMessage = binding.outboxRecyclerView;
        recyclerViewListMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        messageSendAdapter = new MessageSendAdapter(remplirListe(),getContext());
        recyclerViewListMessage.setAdapter(messageSendAdapter);
    }

}