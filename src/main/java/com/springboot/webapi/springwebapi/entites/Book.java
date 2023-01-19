package com.springboot.webapi.springwebapi.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String auther;

    
    public Book(int id, String title, String auther) {
        this.id = id;
        this.title = title;
        this.auther = auther;
    }


    public Book() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuther() {
        return auther;
    }


    public void setAuther(String auther) {
        this.auther = auther;
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", auther=" + auther + "]";
    }
    
    
    
}
