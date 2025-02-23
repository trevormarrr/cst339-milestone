package com.gcu.milestone.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

public class ProductModel {

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Genre is required")
    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @NotNull(message = "Author is required")
    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotNull(message = "Year is required")
    @Min(value = 0, message = "Year must be a valid number")
    private Integer year;

    @NotNull(message = "Checked out status is required")
    private Boolean checkedOut;

    // Constructor
    public ProductModel() {
    }

    public ProductModel(String title, String genre, String author, Integer year, Boolean checkedOut) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}