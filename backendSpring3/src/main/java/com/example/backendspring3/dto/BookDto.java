package com.example.backendspring3.dto;

public class BookDto {

    private String code;
    private Integer quantity;
    private String writer;
    private String translator;
    private String producer;
    private Integer pages;
    private String size;
    private String date;
    private Integer price;
    private Integer promotion;

    private String description;

    private String image;

    public BookDto() {
    }

    public BookDto(String code, Integer quantity, String writer, String translator, String producer, Integer pages, String size, String date, Integer price, Integer promotion, String description, String image) {
        this.code = code;
        this.quantity = quantity;
        this.writer = writer;
        this.translator = translator;
        this.producer = producer;
        this.pages = pages;
        this.size = size;
        this.date = date;
        this.price = price;
        this.promotion = promotion;
        this.description = description;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
