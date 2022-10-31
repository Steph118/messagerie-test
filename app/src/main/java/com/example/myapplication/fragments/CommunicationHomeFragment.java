package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeCommunicationBinding;

public class CommunicationHomeFragment extends Fragment {

    FragmentHomeCommunicationBinding binding;
    ConstraintLayout messagerieConstraint, faqConstraint, newsConstraint;

    public CommunicationHomeFragment() {
    }

    public static CommunicationHomeFragment newInstance() {
       return  new CommunicationHomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeCommunicationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Bindoo Communication");
        //initView(view);
        choiceNavigation();
    }

    /*public void initView(View view){
        messagerieConstraint = view.findViewById(R.id.constraintLayoutMessagerieInterne);
        faqConstraint = view.findViewById(R.id.constraintLayoutFAQ);
        newsConstraint =view.findViewById(R.id.constraintLayoutNews);
    }*/

    public void choiceNavigation(){
        binding.constraintLayoutMessagerieInterne.setOnClickListener(view -> getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_message, MessagerieInterneFragment.newInstance(),null)
                .addToBackStack(null)
                .commit());

        binding.constraintLayoutFAQ.setOnClickListener(view -> getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_message, ListCategoryFaqFragment.newInstance(), null)
                .addToBackStack(null)
                .commit());

        binding.constraintLayoutNews.setOnClickListener(view -> getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_message, NewsFragment.newInstance(),null)
                .addToBackStack(null)
                .commit());
    }
}