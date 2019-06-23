package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Transactional
public class GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;

    public GenericDao(Class<T> clazz){
        this.clazz = clazz;
    }
    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    public Collection<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery(
                String.format("select s FROM %s s", clazz.getSimpleName()), clazz);
        //        select s.* from student_group s;
        return query.getResultList();
    }
}