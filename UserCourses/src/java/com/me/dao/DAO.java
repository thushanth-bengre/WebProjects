/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Bengre
 */
public abstract class DAO {
    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
}
