package com.example.backendspring3.repository;

import com.example.backendspring3.dto.BookDto;
import com.example.backendspring3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Long> {


    @Modifying
    @Query(value = "insert into book(code,quantity,writer,translator,producer,pages,size,date,price,promotion,description,image) value " +
            " (:#{#bookDto.code},:#{#bookDto.quantity},:#{#bookDto.writer},:#{#bookDto.translator},:#{#bookDto.producer},:#{#bookDto.pages}, " +
            " :#{#bookDto.size},:#{#bookDto.date},:#{#bookDto.price},:#{#bookDto.promotion},:#{#bookDto.description},:#{#bookDto.image})", nativeQuery = true)
    void createBook(BookDto bookDto);
}
