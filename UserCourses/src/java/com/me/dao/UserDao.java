/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bengre
 */
public class UserDao extends DAO{
    
    
    Session session;//The main runtime interface between a Java application and Hibernate

    public UserDao() {
        
    }
    
    public User saveUser (User user) {
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        //Hibernate doesnot auto commit transactions. So we need to explicitly commit. 
        //Otherwise the object will not be saved (Will be rolled back)
        session.save(user);
        tx.commit();
        session.close();
        return user;
    } 
    
    public User getUser (int id) {
        session = super.sf.openSession();
        //Transaction is not needed because it is not a DML operation.
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }
    
    public User updateUser (User user) {
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
        return user;
    }
    
    public User deleteUser (User user) {
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
        return user;
    }
}
