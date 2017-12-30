package com.nxsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nxsol.beans.CustomerBean;
import com.nxsol.model.Customer;
import com.nxsol.services.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String get(@ModelAttribute("form")CustomerBean customerbean)
	{
			return "customerForm";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestParam("bName")String bName,@RequestParam("bGender")String bGender,@RequestParam("bDocument")String[] bDocument,@RequestParam("bAdd")String bAdd)
	{
		Customer c=new Customer();
		c.setcName(bName);
		c.setcGender(bGender);
		System.out.println("customer gender is:---------------------------------------------------------------"+bGender);
		c.setcDocument(bDocument);
		c.setcAdd(bAdd);
		service.save(c);
		return "redirect:form";
	}
	
}
