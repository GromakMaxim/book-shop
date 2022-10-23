package ru.gromax.mybookshopapp.data.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookCRUDRepository bookCRUDRepository;

    @Autowired
    public BookService(BookCRUDRepository bookCRUDRepository) {
        this.bookCRUDRepository = bookCRUDRepository;
    }

    public List<Book> getBookData() {
        return bookCRUDRepository.findAll();
    }
}
