package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookRepositoryImpl implements CustomBookRepository, BookCustomRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findFirstByProvidedCategoryOrderedByTitle(Category category) {
        Query q = entityManager
                .createQuery("SELECT b FROM Book b " +
                        " where b.category = :category " +
                        " ORDER BY b.title ");
        return (Book) q.setParameter("category", category)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public void resetRating(int rating) {
        Query q = entityManager
                .createQuery("Update Book p set p.rating = :rating");
        q.setParameter(rating, rating)
                .executeUpdate();
    }
}
