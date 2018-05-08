package com.me.part3.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.part3.pojo.Movie;

public class MovieDAO extends DAO{
	
	public void addMovie(Movie m) {
		try {
			begin();
			getSession().save(m);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}
	
	public List<Movie> browseMovie(String key, String by){
		try {
			Criteria c = getSession().createCriteria(Movie.class);
			c.add(Restrictions.eq(by, key));
			return c.list();
		} catch (HibernateException e) {
			return null;
		}
		
	}

}
