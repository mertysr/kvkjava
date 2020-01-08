package net.mertysr.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import net.mertysr.hibernate.model.User;
import net.mertysr.hibernate.util.HibernateUtil;

public class UserDao {
	@Autowired
    private SessionFactory sessionFactory;
	public void saveUser(User user) {
		Transaction transaction =null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}
	}
	public void updateUser(User user) {
		Transaction transaction =null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		}
			
		
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllStudents() {
		Transaction transaction =null;
		List<User> students=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			students=session.createQuery("from User").list();
			transaction.commit();
		}catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
		return students;
	}
	
	public User deleteUser(int id) {
		Transaction transaction =null;
		User user=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			user = session.get(User.class, id);
			
			session.delete(user);
			
			transaction.commit();
		}
		return user;
	}
	
	
}
