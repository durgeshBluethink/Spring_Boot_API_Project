package com.springboot.webapi.springwebapi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapi.springwebapi.entites.Book;
import com.springboot.webapi.springwebapi.services.BookServices;

@RestController
public class MainController {

    @Autowired(required=true)
    private  BookServices bookServices;


    //for all book details show this method
    //get all book handler
    @RequestMapping("/test")
    public ResponseEntity< List<Book>> getBook(){
        List<Book> list = bookServices.getAllBooks();
        if (list.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }


    // for this single book show by id
    // get single book handler
    @RequestMapping("/test/{id}")
    public Book getBook(@PathVariable("id") int id ){
        return bookServices.getBookById(id);
    }


    // new book handler

    @PostMapping("/test")
    public Book addBook(@RequestBody Book book){
        Book b =  this.bookServices.addBook(book);
        //    System.out.println(book);
        return b;

    }



    // delete book handler

    @DeleteMapping("/test/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookServices.deleteBook(id);
    }


    // update the book handler
    @PutMapping("/test/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
        this.bookServices.updateBook(book,id);
        return book;
    }


}
