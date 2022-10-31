package com.example.myapplication.liste;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.entites.CategoryMessage;
import com.example.myapplication.entites.MessageEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListMessageReceive {

    public ListMessageReceive() {
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<MessageEntity> addListMessageReceive(){
        List<MessageEntity> listMessageReceive = new ArrayList<>();
        LocalDateTime lt = LocalDateTime.now();

        listMessageReceive.add(new MessageEntity(1,"Comparing Two LocalDateTime Instances","The recommended way to compare two LocalDateTime objects is using provided methods which compare both date-time parts and return a boolean value – true or false.",
                new CategoryMessage(0,"reçu"),LocalDateTime.of(2022,4,4,11,21)
                ));

        listMessageReceive.add(new MessageEntity(2,"Premiers pas avec Messages","Messages vous permet d'envoyer et de recevoir des SMS, des photos, des messages vocaux et des vidéos. ",
                new CategoryMessage(0,"reçu"), lt
        ));
        listMessageReceive.add(new MessageEntity(3,"Agriculture : la Banque mondiale en faveur de la mobilisation des machines agricoles au Togo","Quelques mois après son lancement officiel, le 15 juin dernier, le Programme de résilience du système alimentaire en Afrique de l'Ouest (FSRP), appuyé par le groupe de la Banque mondiale (à hauteur d’environ 331,5 milliards FCFA), veut appuyer le Togo en matériel agricole motorisé.",
                new CategoryMessage(0,"reçu"), LocalDateTime.of(2022,10,26,11,21)
        ));
        /*listMessageReceive.add(new MessageEntity(4,"Work-life balance ","When you try to be available all the time, you not only play with your work-life balance but also disappoint your customers when you can't respond. Communicating to your customers when you are not available helps in setting the right expectations. ",
                new CategoryMessage(0,"reçu"),LocalDateTime.of(2022,9,12,22,21)
        ));

        listMessageReceive.add(new MessageEntity(5,"Le text-to-win","Le text-to-win fait référence à un concours SMS. L’objectif est d’augmenter l’engagement et d’enrichir votre base de données.\n" +
                "Pour promouvoir votre concours, envoyez vos contacts vers une landing page ou invitez-les à répondre par SMS.",
                new CategoryMessage(0,"reçu"), LocalDateTime.of(2022,10,25,20,1)
        ));
        listMessageReceive.add(new MessageEntity(6,"Le drip SMS","Littéralement, « drip » signifie « goutte ». Il s’agit d’envoyer des SMS au compte-goutte, à intervalles réguliers, pour remplir un objectif. Généralement, il s’agit d’inciter à l’achat.",
                new CategoryMessage(0,"reçu"), LocalDateTime.of(2000,10,26,13,21)
        ));
        listMessageReceive.add(new MessageEntity(7,"Comparing Two LocalDateTime Instances","The recommended way to compare two LocalDateTime objects is using provided methods which compare both date-time parts and return a boolean value – true or false.",
                new CategoryMessage(0,"reçu"),LocalDateTime.of(2021,2,12,11,21)
        ));*/

        return listMessageReceive;
    }
}
