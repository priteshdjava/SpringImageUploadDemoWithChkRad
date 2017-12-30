package com.nxsol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxsol.dao.CustomerDao;
import com.nxsol.model.Customer;

@Service("service")
public class CustomerServiceImpl implements CutomerService{
	
	@Autowired
	private CustomerDao dao;

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
		
	}
	
}
