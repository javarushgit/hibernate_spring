package org.example.dto;



import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class Person {
    @NotBlank(message = "Must be not blank")
    private String name;
    @Min(value = 0, message = "can not be lower than 0")
    @Max(value = 100, message = "too high age")
    private int age;

    @Email
    private String email;

    public Person(String name, int age, String email, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.birthDate = birthDate;
    }

    @PastOrPresent
    private LocalDate birthDate;
}
