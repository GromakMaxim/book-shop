package ru.gromax.mybookshopapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gromax.mybookshopapp.data.BookService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {
    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", this.bookService.getBookData());
        model.addAttribute("searchPlaceholder", "new search placeholder");
        model.addAttribute("serverTime", new SimpleDateFormat("hh:mm:ss").format(new Date()));
        model.addAttribute("placeholderTextPart2", "SERVER");
        return "index";
    }
}
