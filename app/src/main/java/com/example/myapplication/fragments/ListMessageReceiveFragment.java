package com.example.myapplication.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.MessageReceiveAdapter;
import com.example.myapplication.databinding.FragmentListMessageReceiveBinding;
import com.example.myapplication.entites.MessageEntity;
import com.example.myapplication.liste.ListMessageReceive;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ListMessageReceiveFragment extends Fragment {
    FragmentListMessageReceiveBinding binding;
    private RecyclerView recyclerViewListMessage;
    MessageReceiveAdapter messageReceiveAdapter;
    List<MessageEntity> listMessageEntity = remplirListe();
    MessageEntity messageEntity;

    public ListMessageReceiveFragment(){
    }

    public static  ListMessageReceiveFragment newInstance(){
        return  new ListMessageReceiveFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListMessageReceiveBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        addListMessageReceiver();
        onRecyclerViewClick();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<MessageEntity> remplirListe(){
        Comparator<MessageEntity> reverseComparator = (c1, c2) -> {
            return c2.getDateTime().compareTo(c1.getDateTime());
        };
        List<MessageEntity> list = ListMessageReceive.addListMessageReceive();
        Collections.sort(list, reverseComparator);
       return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addListMessageReceiver(){
        recyclerViewListMessage = binding.inboxRecyclerView;
        recyclerViewListMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        messageReceiveAdapter = new MessageReceiveAdapter(listMessageEntity,getContext());
        recyclerViewListMessage.setAdapter(messageReceiveAdapter);
    }

    public void onRecyclerViewClick(){
        messageReceiveAdapter.setOnClickListener(new MessageReceiveAdapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                messageEntity = listMessageEntity.get(position);

                Bundle b = new Bundle();
                /*b.putString("sfd","CECA");
                b.putString("objet",messageEntity.getObject());
                b.putString("content",messageEntity.getContent());
                b.putString("date",messageEntity.getDateTime().toString());*/
                b.putSerializable("message",messageEntity);

                DetailReceiveMessageFragment detailReceiveMessageFragment = DetailReceiveMessageFragment.newInstance();
                detailReceiveMessageFragment.setArguments(b);

                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_message, detailReceiveMessageFragment,null)
                        .addToBackStack(null)
                        .commit();
                }
        });
    }
}