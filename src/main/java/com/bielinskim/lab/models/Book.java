package com.bielinskim.lab.models;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    long id;
    String author;
    String title;
    LocalDate releaseDate;
    Float price;
    Boolean bestseller;
    CoverType coverType;
    Date createdDate;

    public Book() {
        this.coverType = new CoverType();
        this.createdDate = new Date();
    }

    public Book(long id, String author, String title, LocalDate releaseDate, Float price, Boolean bestseller, CoverType coverType) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.bestseller = bestseller;
        this.coverType = coverType;
        this.createdDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }
}
