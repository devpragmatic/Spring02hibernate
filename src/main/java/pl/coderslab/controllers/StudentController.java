package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.StudentGroupDao;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentGroup;
import pl.coderslab.entity.StudentNew;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentGroupDao studentGroupDao;

    @Autowired
    public StudentController(StudentGroupDao studentGroupDao) {
        this.studentGroupDao = studentGroupDao;
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setName("Group1");
        studentGroupDao.save(studentGroup);
        StudentGroup studentGroup2 = new StudentGroup();
        studentGroup2.setName("Group2");
        studentGroupDao.save(studentGroup2);
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute Student student) {
        System.out.println(student);
        return "redirect:form";
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Ruby");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Snooker", "Programming");
    }

    @ModelAttribute("gender")
    public List<String> gender() {
        return Arrays.asList("Female", "Male");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }


    @GetMapping("/form2")
    public String form2(Model model) {
        model.addAttribute("student", new StudentNew());
        return "student2";
    }

    @PostMapping("/form2")
    public String save2(@ModelAttribute StudentNew student) {
        System.out.println(student);
        return "redirect:form2";
    }

    @ModelAttribute("groups")
    public Collection<StudentGroup> populateGroups() {
        //odpowiednia metoda zwracająca kolekcje
        return studentGroupDao.findAll();
    }
}
