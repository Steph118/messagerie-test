package com.example.myapplication.liste;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.entites.CategoryMessage;
import com.example.myapplication.entites.MessageEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListMessageSend {

    public ListMessageSend() {
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static List<MessageEntity> addListMessageSend(){
            List<MessageEntity> listMessageSend = new ArrayList<>();
            LocalDateTime lt = LocalDateTime.now();

            listMessageSend.add(new MessageEntity(1,"Comparing Two LocalDateTime Instances","The recommended way to compare two LocalDateTime objects is using provided methods which compare both date-time parts and return a boolean value – true or false.",
                    new CategoryMessage(0,"reçu"),LocalDateTime.of(2022,4,4,11,21)
            ));

            listMessageSend.add(new MessageEntity(2,"Premiers pas avec Messages","Messages vous permet d'envoyer et de recevoir des SMS, des photos, des messages vocaux et des vidéos. ",
                    new CategoryMessage(0,"reçu"), lt
            ));
            listMessageSend.add(new MessageEntity(3,"Agriculture : la Banque mondiale en faveur de la mobilisation des machines agricoles au Togo","Quelques mois après son lancement officiel, le 15 juin dernier, le Programme de résilience du système alimentaire en Afrique de l'Ouest (FSRP), appuyé par le groupe de la Banque mondiale (à hauteur d’environ 331,5 milliards FCFA), veut appuyer le Togo en matériel agricole motorisé.",
                    new CategoryMessage(0,"reçu"), LocalDateTime.of(2022,10,24,11,21)
            ));

            return listMessageSend;
        }
}
