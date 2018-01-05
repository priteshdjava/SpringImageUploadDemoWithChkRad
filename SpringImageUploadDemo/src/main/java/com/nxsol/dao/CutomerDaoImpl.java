package com.nxsol.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
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

			public void updateCutomer(Customer cs, int bId) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().createQuery("update Customer set cName='" + cs.getcName() + "',cGender='"
						+ cs.getcGender() + "',cAdd='" + cs.getcAdd() + "',cDocument='"+cs.getcDocument()+"',cuploadImage='"+cs.getCuploadImage()+"' where cId='" + bId + "'").executeUpdate();
				
			}

			public void deleteStudent(int bId) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().createQuery("delete from Customer where cId='"+bId+"'").executeUpdate();
				
				
			}

			public Customer getImageById(int cId) {
				// TODO Auto-generated method stub
			/*	String oldImage=sessionFactory.getCurrentSession().createCriteria(Customer.class).setProjection(Projections.property("uploadImage"));*/
				return (Customer)sessionFactory.getCurrentSession().get(Customer.class, cId);
			}
	
			
}
