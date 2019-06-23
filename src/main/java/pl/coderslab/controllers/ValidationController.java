package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }


    @RequestMapping("/validate")
    public String validateTest(Model model) {
        Book p2 = new Book();
        p2.setTitle("1");
        p2.setRating(0);
        p2.setPages(1);
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);
        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
            return "errors";
        } else {
            // save object }
            return "success";
        }
    }
}
