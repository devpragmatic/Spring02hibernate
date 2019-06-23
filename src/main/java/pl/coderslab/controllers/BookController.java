package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.Collection;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        Publisher publisher = new Publisher();
        publisher.setName("Test");
        publisherDao.save(publisher);
        Publisher publisher2 = new Publisher();
        publisher2.setName("Test2");
        publisherDao.save(publisher2);
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
    public String save(@ModelAttribute Book book){
        bookDao.save(book);
        return "redirect:showAll";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers(){
        return publisherDao.findAll();
    }
}
