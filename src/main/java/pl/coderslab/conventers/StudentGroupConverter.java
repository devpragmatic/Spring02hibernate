package pl.coderslab.conventers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.StudentGroupDao;
import pl.coderslab.entity.StudentGroup;

public class StudentGroupConverter implements Converter<String, StudentGroup> {
    
    @Autowired
    private StudentGroupDao studentGroupDao;
 
    @Override
    public StudentGroup convert(String id) {
        return studentGroupDao.findById(Long.parseLong(id));
    }
}