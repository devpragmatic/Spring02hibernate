package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByNip(String nip);

    Publisher findByRegon(String regon);
}
