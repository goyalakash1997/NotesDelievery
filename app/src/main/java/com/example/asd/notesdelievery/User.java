package com.example.asd.notesdelievery;

/**
 * Created by asd on 1/20/2019.
 */

public class User {
    private  String name,password;
    public User(){
    }
    public User(String name,String password){
        this.name=name;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
