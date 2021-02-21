package com.william.springboot.thymeleafdemo.controller;

import com.william.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployee;

    @PostConstruct
    private void loadData(){

        Employee emp1 = new Employee(1, "William", "Coelho", "will@coei.com");
        Employee emp2 = new Employee(2, "Leandro", "Coelho", "leo@coei.com");
        Employee emp3 = new Employee(3, "Maria", "Coelho", "maria@coei.com");

        theEmployee = new ArrayList<>();

        theEmployee.add(emp1);
        theEmployee.add(emp2);
        theEmployee.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        model.addAttribute("employees", theEmployee);

        return "list-employees";
    }

}
