package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.Idao.Idao;
import com.helloPojo.UserPojo;

@Repository
public class RegisterDao implements Idao {//com.dao.RegisterDao

	
	
	@SuppressWarnings("deprecation")
	public void saveUser(UserPojo user) {
		SessionFactory sf = new  Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		 session.save(user);
		System.out.println("saved objects");
		
		txn.commit();
		session.close();
		
	}
}
