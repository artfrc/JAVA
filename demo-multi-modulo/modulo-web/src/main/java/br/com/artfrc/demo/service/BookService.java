package br.com.artfrc.demo.service;

import br.com.artfrc.demo.model.Book;
import br.com.artfrc.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public String addBook(Book book) {
        repository.save(book);
        return "Salvo com sucesso!";
    }
}
