package com.example.asd.notesdelievery;

/**
 * Created by asd on 1/20/2019.
 */

public class User {
    private  String name,password,uid;
    public User(){
    }
    public User(String name,String password,String uid){
        this.name=name;
        this.password=password;
        this.uid=uid;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
