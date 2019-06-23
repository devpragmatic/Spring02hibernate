package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

@Repository
public class PublisherDao extends GenericDao<Publisher> {
    public PublisherDao() {
        super(Publisher.class);
    }
}
