package com.example.myapplication.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entites.MessageEntity;
import com.google.android.material.textview.MaterialTextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageSendAdapter extends RecyclerView.Adapter<MessageSendAdapter.MsgSendViewHolder>{

    private List<MessageEntity> listeMessageSend;
    private Context context;

    public MessageSendAdapter(List<MessageEntity> listeMessageReceive, Context context) {
        this.listeMessageSend = listeMessageReceive;
        this.context = context;
    }

    @NonNull
    @Override
    public MsgSendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_send_item,parent,false);
        return new MsgSendViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MsgSendViewHolder holder, int position) {
        holder.nomSfd.setText("COCEC");
        holder.messageSend.setText(listeMessageSend.get(position).getContent());
        holder.objetSend.setText(listeMessageSend.get(position).getObject());

        holder.dateTimeSend.setText(formaterDateTime(listeMessageSend.get(position).getDateTime())
        );

    }

    @Override
    public int getItemCount() {
        return listeMessageSend.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String formaterDateTime(LocalDateTime ldt){
        String dateTime;

        if ( isToday(ldt) )
            dateTime = "Ajourd'hui";
        else if (isYesterday(ldt)){
                dateTime="hier";
        }
        else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateTime = ldt.format(formatter);
        }

        return dateTime;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isToday(LocalDateTime ldt){
        LocalDateTime ld = LocalDateTime.now();
        return  (ldt.getDayOfMonth()==ld.getDayOfMonth() &&  ldt.getYear()==ld.getYear() && ldt.getMonthValue()==ld.getMonthValue());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isYesterday(LocalDateTime ldt){
        LocalDateTime ld = LocalDateTime.now();
        return  (ldt.getDayOfMonth()==(ld.getDayOfMonth()-1) &&  ldt.getYear()==ld.getYear() && ldt.getMonthValue()==ld.getMonthValue());
    }


    public class MsgSendViewHolder extends RecyclerView.ViewHolder{
        public MaterialTextView nomSfd, objetSend, messageSend, dateTimeSend;

        public MsgSendViewHolder(@NonNull View itemView) {
            super(itemView);
            nomSfd=itemView.findViewById(R.id.nomSFD);
            objetSend =itemView.findViewById(R.id.objetMessageSendItem);
            messageSend = itemView.findViewById(R.id.messageSendItem);
            dateTimeSend =itemView.findViewById(R.id.dateOfMessageSendItem);
        }
    }
}
