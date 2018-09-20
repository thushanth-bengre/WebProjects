package com.me.lab8Student.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.lab8Student.exception.AdvertException;
import com.me.lab8Student.pojo.Advert;


public class AdvertDAO extends DAO {
	public Advert create(Advert advert)  throws AdvertException {
        try {
            begin();            
            getSession().save(advert);     
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdvertException("Exception while creating advert: " + e.getMessage());
        }
    }

    public void delete(Advert advert)
            throws AdvertException {
        try {
            begin();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdvertException("Could not delete advert", e);
        }
    }
    
    public List<Advert> list() throws AdvertException{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Advert");
            List<Advert> adverts = q.list();
            commit();
            return adverts;
        } catch (HibernateException e) {
            rollback();
            throw new AdvertException("Could not delete advert", e);
        }
    	
    }
}
