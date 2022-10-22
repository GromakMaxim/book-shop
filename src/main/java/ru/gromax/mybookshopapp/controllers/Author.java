package ru.gromax.mybookshopapp.controllers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.gromax.mybookshopapp.data.Book;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private List<Book> bookList = new ArrayList<>();


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
