package com.springboot.webapi.springwebapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.webapi.springwebapi.entites.Book;

@Component
public class BookServices {


    private static List<Book> list = new ArrayList<>();

    //create static block
    static{

//    list.add(new Book(2,"java first!","Durgesh"));
//    list.add(new Book(7,"python first!","Alok"));
//    list.add(new Book(9,"CPP first!","Sachin"));
//    list.add(new Book(12,"C first!","Nissar"));
    }

    //get all all books
    public List<Book> getAllBooks(){
        return list;
    }
    
    //get single book by id 
    public Book getBookById(int id){
        Book book=null;
      book =  list.stream().filter(e->e.getId()==id).findFirst().get();
      return book;
    }

    // add a book data
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    // delete a book
    public void  deleteBook(int b){
        list = list.stream().filter(book->book.getId()!=b).collect(Collectors.toList());
        // return (Book) list;
    }

    public Book updateBook(Book book , int id) {
        list = list.stream().map(e->{

            if(e.getId()==id){
                e.setTitle(book.getTitle());
                e.setAuther(book.getAuther());
            }
            return e;
        }).collect(Collectors.toList());
        return book;
        
    }
}
