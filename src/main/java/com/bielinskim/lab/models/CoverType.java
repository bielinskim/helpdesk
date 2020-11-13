package com.bielinskim.lab.models;

public class CoverType {

    long id;
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoverType() {
    }

    public CoverType(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
