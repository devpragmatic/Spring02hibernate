package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.validator.AdultGroupValidation;
import pl.coderslab.validator.ChildGroupValidation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Validator validator;

    @Autowired
    public UserController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String valid(Model model, @Validated({Default.class}) User user, BindingResult result){
        if(result.hasErrors()){
            return "user/add";
        }
        if(user.getAge() >= 18){
            Set<ConstraintViolation<User>> validate = validator.validate(user, AdultGroupValidation.class);
            model.addAttribute("errors", validate);
        }else{
            Set<ConstraintViolation<User>> validate = validator.validate(user, ChildGroupValidation.class);
            model.addAttribute("errors", validate);
        }
        return "user/add";
    }
}