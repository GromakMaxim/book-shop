package ru.gromax.mybookshopapp.data.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.gromax.mybookshopapp.data.author.Author;

@Entity
@Table(name = "books")
@Getter @Setter @ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    private String title;
    private Integer priceOld;
    private Integer price;

}
