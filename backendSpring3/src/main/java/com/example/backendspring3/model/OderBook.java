package com.example.backendspring3.model;

import javax.persistence.*;

@Entity
@Table(name = "oder_book")
public class OderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private String timeOder;

    private Double sumPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public OderBook() {
    }

    public OderBook(Long id, String timeOder, Double sumPrice, Customer customer, Book book) {
        this.id = id;
        this.timeOder = timeOder;
        this.sumPrice = sumPrice;
        this.customer = customer;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeOder() {
        return timeOder;
    }

    public void setTimeOder(String timeOder) {
        this.timeOder = timeOder;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
