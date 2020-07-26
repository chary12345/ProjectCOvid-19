package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.Idao.Idao;
import com.helloPojo.UserPojo;

@Repository
public class RegisterDao implements Idao {//com.dao.RegisterDao
	static SessionFactory sf=null;
static {
	sf = new  Configuration().configure().buildSessionFactory();
}
	
	
	@SuppressWarnings("deprecation")
	public void saveUser(UserPojo user) {
	
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		 session.save(user);
		System.out.println("saved objects");
		
		txn.commit();
		session.close();
		
	}
	public List<UserPojo> searchUser(String email) {
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		Query q = session.createQuery("from UserPojo where email=:id");
		q.setParameter("id", email);
		List<UserPojo> list1 = q.list();
		for (UserPojo userPojo : list1) {
			System.out.println(userPojo.getEmail());
		}
		session.close();
		return list1;
		
		
	}
	
}
