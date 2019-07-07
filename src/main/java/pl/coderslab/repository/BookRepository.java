package pl.coderslab.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository, BookCustomRepository {

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(long id);

    List<Book> findByAuthors(Author author);

    List<Book> findByRatingBetween(int min, int max);

    List<Book> findByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.title = :title")
    //@Query("select b from Book b where b.title = ?1")
    List<Book> findByProvidedTitle(@Param("title") String title);

    @Query("select b from Book b where b.category = :category")
    List<Book> findByProvidedCategory(@Param("category") Category category);


    @Query(value = "select a.* from article a " +
            " left join article_category ac on ac.article_id = a.id " +
            " where ac.category_id = :categoryId",
            nativeQuery = true)
    List<Book> findByProvidedCategory1(@Param("category") Category category);


//    @Query("select b from Book b where b.rating >= :min and b.rating <= :max")
    @Query("select b from Book b where b.rating between :min and :max")
    List<Book> findByBetweenProvidedRating(@Param("min") int min, @Param("max") int max);

    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> findByPublisher(@Param("publisher")Publisher publisher);

    @Query(value = "SELECT b.* FROM books b " +
            " where b.category_id = :categoryId " +
            " ORDER BY b.myTitle " +
            " LIMIT 1",
            nativeQuery = true)
    Book findFirstByProvidedCategoryOrderByTitle(@Param("categoryId")long categoryId);

    @Query(value = "SELECT b FROM Book b " +
            " where b.category = :category " +
            " ORDER BY b.title ")
    List<Book> findByProvidedCategoryOrderByTitle(@Param("category")Category category, Pageable pageable);

    default Book findTopByProvidedCategoryOrderByTitle(Category category){
        return findByProvidedCategoryOrderByTitle(category, new PageRequest(0,1)).stream().findFirst().orElse(null);
    }

}
