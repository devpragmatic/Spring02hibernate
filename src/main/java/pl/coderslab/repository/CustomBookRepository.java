package pl.coderslab.repository;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface CustomBookRepository {

    Book findFirstByProvidedCategoryOrderedByTitle(Category category);
}
