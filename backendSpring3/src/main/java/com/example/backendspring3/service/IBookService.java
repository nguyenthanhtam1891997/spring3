package com.example.backendspring3.service;

import com.example.backendspring3.dto.BookDto;
import com.example.backendspring3.model.Book;

public interface IBookService extends IGeneralService<Book>{
    void createBook(BookDto bookDto);
}
