package pl.coderslab.conventers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.dao.StudentGroupDao;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.StudentGroup;

public class PublisherConverter implements Converter<String, Publisher> {
    
    @Autowired
    private PublisherDao publisherDao;
 
    @Override
    public Publisher convert(String id) {
        return publisherDao.findById(Long.parseLong(id));
    }
}