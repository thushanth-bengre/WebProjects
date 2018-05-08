/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class loginController extends AbstractController {
    
    public loginController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        
        if(action.equals("login")) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //Normally, we will need to connect to the DB to validate username/password
            //DB Connection will be discussed later
            //For now, we assume, username: admin, password: secret
            if (username.equals("admin") && password.equals("admin")) {
                //username/password correct, go to search page
                //add username to the session
                session.setAttribute("username", username);
                //response.sendRedirect("searchCourse.jsp");  //if there are username,pwd parameteres to be sent to jsp, it won't be sent. A new request will be created.
            }
            return new ModelAndView("searchCourse");
        } else if (action.equals("logout")) {
            //invalidate() removes all the objects from the session
            session.invalidate();
            return new ModelAndView("index");
           // response.sendRedirect("index.jsp");
           
        }else if(action.equals("shotcut")){
            return new ModelAndView("searchCourse");
        }
           //1st jsp file,  2nd is list name,
           return null;
    }
    
    
}
