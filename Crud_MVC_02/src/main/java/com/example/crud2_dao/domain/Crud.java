package com.example.crud2_dao.domain;

import lombok.Data;

@Data
public class Crud {
    
    private String email;
    private String name;
    private String address;

    public Crud(){

    }

    public Crud(String email, String name, String address) {
        this.email = email;
        this.name = name;
        this.address = address;
    }

}
