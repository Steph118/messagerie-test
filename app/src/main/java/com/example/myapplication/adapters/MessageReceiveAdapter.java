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

public class MessageReceiveAdapter extends RecyclerView.Adapter<MessageReceiveAdapter.MsgReceiveViewHolder>{

    public interface OnClickListener{
        void onItemClick(View v, int position);
    }

    private List<MessageEntity> listeMessageReceive ;
    private Context context;
    private OnClickListener onClickListener;

    public MessageReceiveAdapter(List<MessageEntity> listeMessageReceive, Context context) {
        this.listeMessageReceive = listeMessageReceive;
        this.context = context;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public MessageReceiveAdapter.MsgReceiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_receive_item,parent,false);
        return new MsgReceiveViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MsgReceiveViewHolder holder, int position) {
        holder.nomSfd.setText("CECA");
        holder.messageReceive.setText(listeMessageReceive.get(position).getContent());
        holder.objetReceive.setText(listeMessageReceive.get(position).getObject());

        holder.dateTimeReceive.setText(formaterDateTime(listeMessageReceive.get(position).getDateTime())
        );

    }

    @Override
    public int getItemCount() {
        return listeMessageReceive.size();
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


    public class MsgReceiveViewHolder extends RecyclerView.ViewHolder{
        public MaterialTextView nomSfd,objetReceive,messageReceive,dateTimeReceive ;

        public MsgReceiveViewHolder(@NonNull View itemView) {
            super(itemView);
            nomSfd=itemView.findViewById(R.id.nomSFD);
            objetReceive=itemView.findViewById(R.id.objetMessageReceiveItem);
            messageReceive = itemView.findViewById(R.id.messageReceiveItem);
            dateTimeReceive=itemView.findViewById(R.id.dateOfMessageReceiveItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener!=null){
                        onClickListener.onItemClick(view,getLayoutPosition());
                    }
                }
            });
        }
    }

    /*
    private void showMemberDistributionDetail() {
        WithdrawalRequestMembersDialog dialog = new WithdrawalRequestMembersDialog();
        Bundle b = new Bundle();
        b.putSerializable("withdrawal_request", selectedDemande);
        b.putString("currency", selectedCompte.getCodeDevise());
        b.putSerializable("member", personneInfo.getMembreGroupe());
        dialog.setArguments(b);
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        dialog.show(ft, WithdrawalRequestMembersDialog.TAG);
    }
     */
}
