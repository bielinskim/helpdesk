package com.bielinskim.lab.models;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;

    public Status() { }

    public Status(String name) {
        this.name = name;
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
