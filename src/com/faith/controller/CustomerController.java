package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.model.Customer;
import com.faith.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerservice;        //field injection
	@GetMapping("/showformforadd")
	public String ShowFormForAdd (Model model) {
		
		//create model attributes to bind from data
		Customer theCustomer = new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	//update
	@GetMapping("/showformforupdate")
	public String ShowFormForUpdate (@RequestParam("customerId") int theId,Model model){
		//create model attributes to bind from data
		Customer theCustomer = customerservice.getCustomer(theId);
		model.addAttribute("customer", theCustomer);
		return "customer-form";
		
	}

	
	@GetMapping("/list")//@GetMapping
public String listCustomer(Model model) {
		
		List<Customer> thecustomer = customerservice.getCustomers();
		
		model.addAttribute("customer", thecustomer);
		return "list-customer";
	}
	//delete
	@GetMapping("/delete")
	public String deteleCustomer(@RequestParam("customerId") int theId){
		//deleting customer
		customerservice.deleteCustomer(theId);
		//retutn to list page
		return "redirect:/customer/list";
		
	}
	@PostMapping("/savecustomer")
	public String savecustomer (@ModelAttribute("customer")Customer thecustomer ) {
		customerservice.savecustomer(thecustomer);
	
		 return "redirect:/customer/list";
	}
}
