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

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMessagerieInterneBinding;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MessagerieInterneFragment extends Fragment {

    FragmentMessagerieInterneBinding binding;
    ExtendedFloatingActionButton writeMessageFloatButton;
    //Button inbox,outbox;

    public MessagerieInterneFragment(){

    }

    public static  MessagerieInterneFragment newInstance(){
        return  new MessagerieInterneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMessagerieInterneBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Messagerie interne");
        displayRecevingMessages();
        applyStyleReceiveButtonClick();
        setActionClick();

    }

   /* public void init(View view){
        writeMessageFloatButton = view.findViewById(R.id.floatButtonWriteMessage);
        outbox = view.findViewById(R.id.sendMessageButton);
        inbox= view.findViewById(R.id.receiveMessageButton);
    }*/

    public void setActionClick(){
        binding.floatButtonWriteMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_message,WriteMessageFragment.newInstance(),null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.receiveMessageButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                applyStyleReceiveButtonClick();
                displayRecevingMessages();
            }
        });

        binding.sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyStyleSendButtonClick();
                displaySendingMessage();
            }
        });

    }

    public void applyStyleReceiveButtonClick(){
        binding.receiveMessageButton.setTextColor(getResources().getColor(R.color.white));
        binding.receiveMessageButton.setBackgroundColor(getResources().getColor(R.color.pinkA200));

        binding.sendMessageButton.setBackgroundColor(getResources().getColor(R.color.white));
        binding.sendMessageButton.setTextColor(getResources().getColor(R.color.pinkA200));
    }

    public void applyStyleSendButtonClick(){
        binding.receiveMessageButton.setTextColor(getResources().getColor(R.color.pinkA200));
        binding.receiveMessageButton.setBackgroundColor(getResources().getColor(R.color.white));

        binding.sendMessageButton.setBackgroundColor(getResources().getColor(R.color.pinkA200));
        binding.sendMessageButton.setTextColor(getResources().getColor(R.color.white));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void displayRecevingMessages(){
        getParentFragmentManager().beginTransaction()
                .replace(R.id.viewPagerOfMessage,ListMessageReceiveFragment.newInstance(),null)
                .commit();
    }
    public void displaySendingMessage(){
        getParentFragmentManager().beginTransaction()
                .replace(binding.viewPagerOfMessage.getId(),ListMessageSendFragment.newInstance(),null)
                .commit();
    }
}