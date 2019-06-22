package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute Person person){
        personDao.save(person);
        return "person";
    }
//    @GetMapping("/form")
//    public String form(){
//        return "person";
//    }
//
//    @PostMapping("/form")
//    public String save(@RequestParam("login") String login,
//                       @RequestParam("password") String password,
//                       @RequestParam("email") String email){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDao.save(person);
//        return "person";
//    }
}
