package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void createUser(User user) {
		em.merge(user);
	}

}
