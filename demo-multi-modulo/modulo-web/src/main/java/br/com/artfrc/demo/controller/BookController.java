package br.com.artfrc.demo.controller;

import br.com.artfrc.demo.model.Book;
import br.com.artfrc.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public String addBook(@RequestBody Book book) {
        return service.addBook(book);
    }
}
