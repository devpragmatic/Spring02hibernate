package pl.coderslab.repository;

import pl.coderslab.entity.Person;

public interface PersonRepoCustom {
    Person myCustomFindById(Long id);
    void changeLastName(String originalLastName, String newLastName);
}