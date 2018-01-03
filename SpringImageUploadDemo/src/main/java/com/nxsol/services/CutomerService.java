package com.nxsol.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nxsol.model.Customer;

public interface CutomerService {

	public void save(Customer customer);
	
	public List<Customer> getAllCutomer();
	
}
