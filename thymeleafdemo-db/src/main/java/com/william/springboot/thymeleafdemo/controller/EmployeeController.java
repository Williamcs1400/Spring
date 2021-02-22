package com.william.springboot.thymeleafdemo.controller;

import com.william.springboot.thymeleafdemo.entity.Employee;
import com.william.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        List<Employee> theEmployee = employeeService.findAll();

        model.addAttribute("employees", theEmployee);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        Employee employee = employeeService.findById(theId);

        theModel.addAttribute("employee", employee);

        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);

        return "redirect:/employees/list";

    }


}
