package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute Person person){
        personRepository.save(person);
        return "person";
    }

    @GetMapping(value = "/change")
    @ResponseBody
    public String testCustom() {
        personRepository.changeLastName("kowal", "Kowalski");
        return "All data changed";
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
//        personRepository.save(person);
//        return "person";
//    }
}
