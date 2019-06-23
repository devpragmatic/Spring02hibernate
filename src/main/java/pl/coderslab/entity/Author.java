package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.validator.Adult;
import pl.coderslab.validator.AdultGroupValidation;
import pl.coderslab.validator.StartWith;

import javax.persistence.*;

@Entity
@Table(name= "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @NotBlank
    @StartWith(value = "Dupa", groups = AdultGroupValidation.class)
    private String firstName;
    @NotBlank
    private String lastName;
    @PESEL(groups = AdultGroupValidation.class)
    private String pesel;
    @Email(groups = AdultGroupValidation.class)
    private String email;
    @Adult
    private Integer yearOfBirth;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}