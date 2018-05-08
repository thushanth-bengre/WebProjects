package com.me.part4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.part4.dao.DAO;
import com.me.part4.pojo.Books;

public class BooksDAO extends DAO{
	
	public void addMovie(Books b) {
		try {
			begin();
			getSession().save(b);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Books> browseMovie(){
		try {
			Criteria c = getSession().createCriteria(Books.class);			
			return (List<Books>) c.list();
		} catch (HibernateException e) {
			return null;
		}
	}
}
