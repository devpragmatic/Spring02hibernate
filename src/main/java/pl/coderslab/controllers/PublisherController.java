package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("publisher", new Publisher());
        return "publisher";
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "showAllPublishers";
    }

    @PostMapping("/form")
    public String save(Model model, @ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisher";
        }
        publisherDao.save(publisher);
        return "redirect:showAll";
    }
}
