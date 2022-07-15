package com.example.backendspring3.service.impl;

import com.example.backendspring3.dto.BookDto;
import com.example.backendspring3.model.Book;
import com.example.backendspring3.repository.IBookRepository;
import com.example.backendspring3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
            bookRepository.deleteById(id);
    }

    @Override
    public void createBook(BookDto bookDto) {
        bookRepository.createBook(bookDto);
    }
}
