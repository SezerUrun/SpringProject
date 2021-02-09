package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data")
    private String data="";

    /*
    Entry(String data){
        this.data=data;
    }
    */
}
