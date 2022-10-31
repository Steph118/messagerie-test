package com.example.myapplication.entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MessageEntity implements Comparable<MessageEntity>,Serializable{
    private  int id;
    private String object;
    private String content;
    private CategoryMessage categorieMessage;
    private LocalDateTime dateTime;

    public MessageEntity() {
    }

    public MessageEntity(int id,String object, String content, CategoryMessage categorieMessage) {
        this.id=id;
        this.object = object;
        this.content = content;
        this.categorieMessage = categorieMessage;
    }

    public MessageEntity(String object, String content) {
        this.object = object;
        this.content = content;
    }

    public MessageEntity(int id, String object, String content, CategoryMessage categorieMessage, LocalDateTime dateTime) {
        this.id = id;
        this.object = object;
        this.content = content;
        this.categorieMessage = categorieMessage;
        this.dateTime = dateTime;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryMessage getCategorieMessage() {
        return categorieMessage;
    }

    public void setCategorieMessage(CategoryMessage categorieMessage) {
        this.categorieMessage = categorieMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", object='" + object + '\'' +
                ", content='" + content + '\'' +
                ", categorieMessage=" + categorieMessage +
                '}';
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int compareTo(MessageEntity messageEntity) {
        return 0;
    }
}
