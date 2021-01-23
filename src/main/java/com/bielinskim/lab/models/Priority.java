package com.bielinskim.lab.models;

import javax.persistence.*;

@Entity
@Table(name = "priorities")
public class Priority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;

    public Priority() { }

    public Priority(String name) {
        this.name = name;
    }

    public Priority(int id, String name) {
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
