package com.example.backendspring3.controller;

import com.example.backendspring3.dto.BookDto;
import com.example.backendspring3.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/book")
@Component
@CrossOrigin("*")
public class BookController {

    @Autowired
    private IBookService bookService;


    private Map<String, String> mapError = new HashMap<>();
    private Map<String, String> mapSuccess = new HashMap<>();
    private static final String MESSAGE = "message";


    @PostMapping("/create")
    public ResponseEntity<Object> createBook(@Valid @RequestBody BookDto bookDto, BindingResult bindingResult) {
        mapError.clear();
        mapSuccess.clear();
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                mapError.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", mapError);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            bookService.createBook(bookDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }


}
