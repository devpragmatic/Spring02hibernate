package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a from Author a where a.email like %:end")
    List<Author> findByEmailEndsWith(@Param("end") String end);

    @Query("SELECT a from Author a where a.pesel like %:end")
    List<Author> findByPeselEndsWith(@Param("end") String end);

}
