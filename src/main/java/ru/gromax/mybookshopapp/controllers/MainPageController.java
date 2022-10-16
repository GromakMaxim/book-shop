package ru.gromax.mybookshopapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.gromax.mybookshopapp.data.Book;
import ru.gromax.mybookshopapp.data.BookService;

import java.util.List;

@Controller
public class MainPageController {
    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBookData();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
