package ru.gromax.mybookshopapp.data.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    AuthorCRUDRepository authorCRUDRepository;

    @Autowired
    public AuthorsService(AuthorCRUDRepository authorCRUDRepository) {
        this.authorCRUDRepository = authorCRUDRepository;
    }

    public Map<String, List<Author>> getAuthors() {
        return authorCRUDRepository.findAll().stream().collect(Collectors.groupingBy((Author a)->{return a.getLastName().substring(0, 1);}));
    }

    private String getAuthorById(int author_id) {
        return  authorCRUDRepository.findById(author_id).get().toString();
    }
}
