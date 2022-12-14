package ru.gromax.mybookshopapp.data.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookCRUDRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByAuthorFirstNameContaining(String authorFirstName);
    List<Book> findBooksByTitleContaining(String bookTitle);
    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);
    List<Book> findBookByPriceOldIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value="SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bootTitle, Pageable nextPage);

}
