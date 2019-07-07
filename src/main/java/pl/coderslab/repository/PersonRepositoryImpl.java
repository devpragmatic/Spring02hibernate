package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person myCustomFindById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void changeLastName(String originalLastName, String newLastName) {
        Query q = entityManager
                .createQuery("Update Person p set p.login = :newLastName" +
                        " where p.login= :originalLastName");
        q.setParameter("newLastName", newLastName)
                .setParameter("originalLastName", originalLastName)
                .executeUpdate();
    }
}