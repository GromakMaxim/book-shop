package ru.gromax.mybookshopapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.gromax.mybookshopapp.data.AuthorsService;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        return authorsService.getAuthors();
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }
}
