package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Repository
public class AuthorDao extends GenericDao<Author>{
    public AuthorDao() {
        super(Author.class);
    }
}