package com.teamtreehouse.giflib.model;

import java.time.LocalDate;

/**
 * Created by User on 2016.07.19..
 */
public class Gif {

    private String name;
    private int categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Gif() { }

    public Gif(String name, int categoryId, LocalDate dateUploaded, String username, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    /* Getters and Setters. Thymeleaf and JPA will reference to them */

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        System.out.println("Gif.getName=" + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Gif.setName = " + name);
        this.name = name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
