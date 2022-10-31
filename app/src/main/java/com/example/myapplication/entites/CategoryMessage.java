package com.example.myapplication.entites;

public class CategoryMessage {

    private int id;
    private String type;

    public CategoryMessage(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public CategoryMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String isType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CategoryMessage{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
