/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.UserDao;
import com.me.pojo.User;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class UserController extends AbstractController {
    
    public UserController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        UserDao userDAO = this.getApplicationContext().getBean("userDAO", UserDao.class);
         
        User user;
        
        String url = request.getRequestURI();
        if (url.contains("user-")) {
            String id  = url.substring((url.lastIndexOf("-") + 1), url.lastIndexOf("."));
            // user-123.htm 
            user = userDAO.getUser(Integer.parseInt(id));
            //Below code will give exception if user is not present. JSP Expression language handles Null Pointer Exception
            //System.out.println(user.getfName());
            return new ModelAndView("userview", "user", user);
        } else {
            user = new User();
            user.setfName("Vinay");
            user.setlName("Gor");

            HashSet<String> courses = new HashSet<String>();

            courses.add("Course 1");
            courses.add("Course 2");
            courses.add("Course 3");

            user.setCourses(courses);
            //persist the object into the database
            
            userDAO.saveUser(user);
            return new ModelAndView("userview", "user", user);
        }
    }
    
}
