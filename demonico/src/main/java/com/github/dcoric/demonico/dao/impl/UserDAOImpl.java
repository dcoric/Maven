package com.github.dcoric.demonico.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.github.dcoric.demonico.dao.UserDAO;
import com.github.dcoric.demonico.model.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {
	
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired(required=true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(){
	}
	
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findUserById(Integer id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
		
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public List<User> findUserByName(String firstName, String lastName) {
		
		List<User> result = null;
		String queryString = "from User u where 1=1 "
				+ (firstName!=null? "and u.firstName = :fistName " : "")
				+ (lastName!=null? "and u.lastName = :lastName":"")
				+ "order by u.firstName";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		if(firstName!=null)
			query.setParameter("firstName", firstName);
		if(lastName!=null)
			query.setParameter("lastName", lastName);
		try{
			result = query.list();
			session.flush();
			session.close();
		} catch(NoResultException e) {
			log.warn("No results! (error msg: " + e + ")");
		}

		return result;
	}

	public User findUserByUsername(String username) {
		if(username == null || username.equals(""))
			return null;
		User result = null;
		String queryString = "from User u where u.username = :username";
		Query query = null;
		try{
		Session session = sessionFactory.openSession();
		query = session.createQuery(queryString);
		query.setParameter("username", username);
		} catch (Exception e) {
			log.error(e);
		}
		try{
			if(query!=null)
				result = (User)query.uniqueResult();
		} catch(NonUniqueResultException e) {
			log.warn(":> Username ["+username+"] nije jedinstveno! " + e);
		} catch(NoResultException e) {
			log.info(";> Username ["+username+"] ne postoji u bazi. " + e);
		} 
		return result;
	}

}
