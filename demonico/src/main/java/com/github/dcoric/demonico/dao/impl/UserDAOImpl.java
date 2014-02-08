package com.github.dcoric.demonico.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.dcoric.demonico.dao.UserDAO;
import com.github.dcoric.demonico.model.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {
	
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired(required=true)
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
		
		List<User> result = new ArrayList<User>();
		String queryString = "from User u where 1=1 "
				+ (firstName!=null? "and u.firstName = :fistName " : "")
				+ (lastName!=null? "and u.lastName = :lastName":"")
				+ "order by u.firstName";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		if(firstName!=null)
			query.setParameter("firstName", firstName);
		if(lastName!=null)
			query.setParameter("lastName", lastName);
		try{
			result = query.list();
		} catch(NoResultException e) {
			log.warn("No results! (error msg: " + e + ")");
		}

		
		return result;
	}

}
