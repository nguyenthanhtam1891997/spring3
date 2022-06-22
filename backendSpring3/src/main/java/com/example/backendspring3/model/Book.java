package com.example.backendspring3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer quantity;
    private Integer rest;
    private String writer;
    private String translator;
    private String producer;
    private int pages;
    private String size;

    @Column(columnDefinition = "Date")
    private String date;

    private Double price;
    private Double promotion;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private Integer numberOfSale;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;


    @JsonBackReference
    @OneToMany(mappedBy = "book")
    private List<OderBook> oderBookList;


    public Book() {
    }

    public Book(Long id, String code, Integer quantity, Integer rest, String writer, String translator, String producer, int pages, String size, String date, Double price, Double promotion, String description, Integer numberOfSale, Category category, List<OderBook> oderBookList) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.rest = rest;
        this.writer = writer;
        this.translator = translator;
        this.producer = producer;
        this.pages = pages;
        this.size = size;
        this.date = date;
        this.price = price;
        this.promotion = promotion;
        this.description = description;
        this.numberOfSale = numberOfSale;
        this.category = category;
        this.oderBookList = oderBookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromotion() {
        return promotion;
    }

    public void setPromotion(Double promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfSale() {
        return numberOfSale;
    }

    public void setNumberOfSale(Integer numberOfSale) {
        this.numberOfSale = numberOfSale;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OderBook> getOderBookList() {
        return oderBookList;
    }

    public void setOderBookList(List<OderBook> oderBookList) {
        this.oderBookList = oderBookList;
    }
}
