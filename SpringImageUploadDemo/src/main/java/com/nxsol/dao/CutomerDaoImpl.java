package com.nxsol.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nxsol.model.Customer;

@Repository("dao")
@Transactional
public class CutomerDaoImpl implements CustomerDao{
	
			@Autowired
			private SessionFactory sessionFactory;

			public void save(Customer customer) {
				// TODO Auto-generated method stub
				
				sessionFactory.getCurrentSession().saveOrUpdate(customer);
			}

			public List<Customer> getAllCutomer() {
				// TODO Auto-generated method stub
				
				return (List<Customer>)sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
				
			}

			public Customer getById(int cId) {
				// TODO Auto-generated method stub
				return (Customer)sessionFactory.getCurrentSession().get(Customer.class,	cId);
			}
	
			
}
