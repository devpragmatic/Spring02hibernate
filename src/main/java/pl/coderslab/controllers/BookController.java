package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final Validator validator;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, Validator validator) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.validator = validator;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "showAllBooks";
    }

    @PostMapping("/form")
    public String save(Model model, @ModelAttribute("book") @Valid Book book, BindingResult result){
        model.asMap().forEach((k, v) -> System.err.println(k + ": " + v));
        if(result.hasErrors()){
            return "book";
        }
        bookDao.save(book);
        return "redirect:showAll";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers(){
        return publisherDao.findAll();
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validateTest() {
        Book p2 = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        } else {
            // save object }
            return "validateResult";
        }
        return violations.toString();
    }

    @RequestMapping("/validate2")
    @ResponseBody
    public String validate2Test() {
        Author p2 = new Author();
        Set<ConstraintViolation<Author>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Author> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        } else {
            // save object }
            return "validateResult";
        }
        return violations.toString();
    }
}
