package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
@Transactional
public class StudentGroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(StudentGroup entity) {
        entityManager.persist(entity);
    }

    public StudentGroup findById(long id) {
        return entityManager.find(StudentGroup.class, id);
    }

    public void update(StudentGroup entity) {
        entityManager.merge(entity);
    }

    public void delete(StudentGroup entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    public Collection<StudentGroup> findAll() {
        TypedQuery<StudentGroup> query = entityManager.createQuery(
                "select s FROM StudentGroup s", StudentGroup.class);
                    //        select s.* from student_group s;
        return query.getResultList();
    }
}