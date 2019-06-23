package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.validator.AdultGroupValidation;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("author", new Author());
        return "author";
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "showAllAuthors";
    }

    @PostMapping("/form")
    public String save(Model model, @ModelAttribute("author") @Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "author";
        }
        authorDao.save(author);
        return "redirect:showAll";
    }
}
