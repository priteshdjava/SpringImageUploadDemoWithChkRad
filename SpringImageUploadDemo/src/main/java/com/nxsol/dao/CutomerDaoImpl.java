package com.nxsol.dao;

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
	
			
}
