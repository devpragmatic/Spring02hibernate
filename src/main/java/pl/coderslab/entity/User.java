package pl.coderslab.entity;

import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.validator.AdultGroupValidation;
import pl.coderslab.validator.ChildGroupValidation;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private Integer age;

    @NotNull(groups = ChildGroupValidation.class)
    @AssertTrue(groups = ChildGroupValidation.class, message = "Zgoda rodzicow jest wymagana, gdy jestes dzieckiem")
    private Boolean zgodaRodzicow;

    @PESEL(groups = AdultGroupValidation.class)
    @NotNull(groups = AdultGroupValidation.class, message = "Pesel jest wymagany, gdy jestes dorosly")
    private String pesel;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getZgodaRodzicow() {
        return zgodaRodzicow;
    }

    public void setZgodaRodzicow(Boolean zgodaRodzicow) {
        this.zgodaRodzicow = zgodaRodzicow;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
