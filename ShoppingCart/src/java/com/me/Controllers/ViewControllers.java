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
public class ViewControllers extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
        if(action.equals("books")){
            return new ModelAndView("books");
        }else if(action.equals("cds")){
            return new ModelAndView("cds");
        }else if(action.equals("laptops")){
            return new ModelAndView("laptops");
        }
        return null;
    }
    
}
