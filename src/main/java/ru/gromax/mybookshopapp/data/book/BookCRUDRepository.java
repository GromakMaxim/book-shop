package ru.gromax.mybookshopapp.data.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCRUDRepository extends JpaRepository<Book, Integer> {

}
