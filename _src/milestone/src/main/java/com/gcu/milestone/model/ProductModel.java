package com.gcu.milestone.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

/**
 * product model for books
 */
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

    /**
     * Default Constructor
     */
    public ProductModel() {
    }

    /**
     * Constructor
     */
    public ProductModel(String title, String genre, String author, Integer year, Boolean checkedOut) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    // Getters and Setters
    /**
     * getter for title
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter for title
     * 
     * @param title title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter for genre
     * 
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * setter for genre
     * 
     * @param genre genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * getter for author
     * 
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter for author
     * 
     * @param author author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * getter for year
     * 
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * setter for year
     * 
     * @param year year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * getter for checkout
     * 
     * @return checkout
     */
    public Boolean getCheckedOut() {
        return checkedOut;
    }

    /**
     * setter for checkout
     * 
     * @param checkedOut checkout to set
     */
    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}