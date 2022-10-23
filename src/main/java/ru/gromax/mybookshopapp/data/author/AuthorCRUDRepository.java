package ru.gromax.mybookshopapp.data.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCRUDRepository extends JpaRepository<Author, Integer> {
}
