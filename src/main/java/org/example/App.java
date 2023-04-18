package org.example;

import org.example.config.SpringConfig;
import org.example.dto.Human;
import org.example.dto.Person;
import org.example.dto.TeamDto;
import org.example.jdbctemplate.model.User;
import org.example.jdbctemplate.repository.UserRepo;
import org.example.repo.CustomRepository;
import org.example.resourse.ResourceReaderService;
import org.example.service.PlayerService;
import org.example.service.TeamService;
import org.example.service.UserService;
import org.example.service.impl.PlayerServiceImpl;
import org.example.validator.HumanValidator;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;
import org.springframework.validation.DataBinder;

import javax.swing.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Hello world!
 *
 */

public class App {
    public static void main( String[] args ) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example.config");
//        ResourceReaderService service = applicationContext.getBean(ResourceReaderService.class);
//        service.readFile("order.yaml");
//        HumanValidator humanValidator = applicationContext.getBean(HumanValidator.class);
//        Human human = applicationContext.getBean(Human.class);
//        Map<String, String> properties = Map.ofEntries(
//                Map.entry("name", ""),
//                Map.entry("age", "20000")
//        );
//
//        Human human = applicationContext.getBean(Human.class);
////        System.out.println(human);
//        BeanWrapper beanWrapper = applicationContext.getBean(BeanWrapper.class);
//        beanWrapper.setPropertyValues(properties);
//
//        DataBinder dataBinder = new DataBinder(human);
//        MutablePropertyValues propertyValues = new MutablePropertyValues(properties);
//        dataBinder.bind(propertyValues);
//        System.out.println(human);
//        dataBinder.addValidators(humanValidator);
//        dataBinder.validate();




//        DefaultConversionService service = applicationContext.getBean(DefaultConversionService.class);
//        System.out.println("toHexConverter.convert(human.getAge(), String.class) = " + service.convert(human.getAge(), String.class));
//
//
//        BigDecimal bigDecimal = service.convert(human.getAge(), BigDecimal.class);
//        bigDecimal = bigDecimal.pow(10000);
//        System.out.println(bigDecimal.toString());

//        BigDecimal bigDecimal = service.convert(100L, BigDecimal.class);
//        System.out.println(bigDecimal);
//        Person person = new Person("Ilya", -1, "someText", LocalDate.now());
//        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory();) {
//            Validator validator = factory.getValidator();
//            Set<ConstraintViolation<Person>> validate = validator.validate(person);
//
//            if(!validate.isEmpty()) {
//                validate.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
//            }
//
//        }



        // AOP

//       PlayerService playerService = applicationContext.getBean(PlayerService.class);
//        playerService.getById(1L);
//        System.out.println("========================");
//        TeamService teamService = applicationContext.getBean(TeamService.class);
//        TeamDto byId = teamService.getById(1L);

        // JDBC Template

        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println("userService.getById(1L).orElseThrow() = " + userService.m("a"));

        CustomRepository bean = applicationContext.getBean(CustomRepository.class);
        System.out.println("bean.findAllByName(\"Ilya\") = " + bean.findAllByName("Ilya"));


    }
}