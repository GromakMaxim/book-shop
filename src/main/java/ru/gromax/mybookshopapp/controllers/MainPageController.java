package ru.gromax.mybookshopapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gromax.mybookshopapp.data.book.Book;
import ru.gromax.mybookshopapp.data.book.BookService;
import ru.gromax.mybookshopapp.data.book.RecommendedBooksPageDTO;

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
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public RecommendedBooksPageDTO getBooksPage(@RequestParam("offset") Integer offset,
                                                @RequestParam("limit") Integer limit){
        return new RecommendedBooksPageDTO(bookService.getPageOfRecommendedBooks(offset, limit).getContent());

    }
}
