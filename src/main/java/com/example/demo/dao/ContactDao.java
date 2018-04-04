package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Contact;

public class ContactDao {
	@Autowired
	private EntityManager entityManager;

	public List<Contact> getAllContacts() {
		String sql = "select * from contact;";
		Query query = entityManager.createQuery(sql, Contact.class);
		return query.getResultList();
	}
	
	public void addContact(Contact c) {
		String sql = "insert into Contact set (name=:name, email=:email)";
		Query query = entityManager.createQuery(sql);
		query.setParameter("name", c.getName());
		query.setParameter("email", c.getEmail());
		query.executeUpdate();
	}
	public Contact getContact(String username) {
		String sql = "select * from contact where name = :username;";

		Query query = entityManager.createQuery(sql, Contact.class);
		query.setParameter("username", username);
		return (Contact) query.getSingleResult();
	}

	public void deleteContact(String username) {
		String sql = "delete from contact where name = :username;";
		Query query = entityManager.createQuery(sql, Contact.class);
		query.setParameter("username", username);
		query.executeUpdate();
	}
	
	public void updateContact(Contact contact) {
		String sql = "update contact(name, email) values(:name, :email);";
		Query query = entityManager.createQuery(sql, Contact.class);
		query.setParameter("username", contact.getName());
		query.setParameter("email", contact.getEmail());
		query.executeUpdate();
	}
}
