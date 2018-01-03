package com.nxsol.dao;

import java.util.List;

import com.nxsol.model.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);
	
	public List<Customer> getAllCutomer();
	
	public Customer getById(int cId);
}
