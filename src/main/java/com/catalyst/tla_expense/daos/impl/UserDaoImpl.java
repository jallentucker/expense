package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;

/**
 * The Dao Implementation for a user. All interactions with the database exist here.
 * @author cmiller
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Returns a list of users from the database.
	 * @author cmiller
	 */
	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	/**
	 * Persists a user to the database.
	 * @author cmiller
	 */
	@Override
	public void createUser(User user) {
		em.merge(user);
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
