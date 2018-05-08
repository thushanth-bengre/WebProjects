/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class LoginControllers extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        if(action.equals("login")) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.equals("admin") && password.equals("admin")) {
              
                session.setAttribute("username", username);
                return new ModelAndView("cart");               
            } else {                
                return new ModelAndView("index");
                
            }
        } else if (action.equals("logout")) {

            session.invalidate();
            return new ModelAndView("index");
        }
        return null;
    }
    
}
