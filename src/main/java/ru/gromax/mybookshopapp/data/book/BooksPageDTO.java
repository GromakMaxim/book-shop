package ru.gromax.mybookshopapp.data.book;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BooksPageDTO {
    private Integer count;
    private List<Book> books;

    public BooksPageDTO(List<Book> books) {
        this.count = books.size();
        this.books = books;
    }
}
