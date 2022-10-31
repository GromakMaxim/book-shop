package ru.gromax.mybookshopapp.data.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookCRUDRepository bookCRUDRepository;

    @Autowired
    public BookService(BookCRUDRepository bookCRUDRepository) {
        this.bookCRUDRepository = bookCRUDRepository;
    }

    public List<Book> getBookData() {
        return bookCRUDRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String authorName){
        return bookCRUDRepository.findBookByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title){
        return bookCRUDRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookCRUDRepository.findBooksByPriceOldBetween(min, max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookCRUDRepository.findBookByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return bookCRUDRepository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookCRUDRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookCRUDRepository.findAll(nextPage);
    }
}
