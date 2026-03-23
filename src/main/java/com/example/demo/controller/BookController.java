package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/")
    public  void  addBook(@RequestBody Book book){bookServiceImpl.addBook(book);}

    @GetMapping("findall")
    public HashSet<Book> getAllBook(){return bookServiceImpl.findAllBook();}

    @GetMapping("/findbyid/{id}")
    public  Book getBookById(@PathVariable long id){return bookServiceImpl.findBookByID(id);}

    @DeleteMapping("/delete")
    public void deleteBook(){bookServiceImpl.deleteAllData();}
}
