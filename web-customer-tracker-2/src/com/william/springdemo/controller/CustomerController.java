package com.william.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.william.springdemo.dao.CustomerDAO;
import com.william.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		List<Customer> theCustomers = customerDAO.getCustomer();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
		
}
