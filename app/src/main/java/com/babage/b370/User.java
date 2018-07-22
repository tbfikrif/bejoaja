package com.babage.b370;


public class User {

    private int id;
    private String value;


    public User(String value) {
        this.value = value;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
