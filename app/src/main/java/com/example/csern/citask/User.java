package com.example.csern.citask;

import java.io.Serializable;

/**
 * Created by csern on 12/08/2017.
 */

public class User implements Serializable {

    private String name;
    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
