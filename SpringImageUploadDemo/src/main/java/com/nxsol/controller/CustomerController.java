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
		System.out.println("customer gender is:---------------------------------------------------------------"+bGender);
		System.out.println("checkbox value is:------------------------------------------------------------"+bDocument[0]);
		/*String bDocument1=bDocument[0];
		String bDocument2=bDocument[1];
		c.setcDocument(bDocument1);
		c.setcDocument(bDocument2);*/
		String doc = "";
		for(int i=0 ; i<bDocument.length ; i++)
		{
			doc+=bDocument[i];
			for(int j=0; j<(bDocument.length)-1;j++ ){
			doc+=",";
			}
			/*service.save(c);*/
		}
		System.out.println("doc is------------------------------------------------------------"+doc);
		c.setcDocument(doc);
		c.setcName(bName);
		c.setcGender(bGender);
		c.setcAdd(bAdd);
		service.save(c);
		return "redirect:form";
	}
	
}
