/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controllers;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class CartControllers extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

       
        HttpSession session = request.getSession(false);
        Set<String>myCart;

        if(null!=session.getAttribute("myCart")){
            myCart=(Set<String>)session.getAttribute("myCart");
        }
        else{
            myCart=new HashSet<String>();
        }

        if (action.equals("add")) {

        	
            
            String[] items2=request.getParameterValues("item");
        	for(String item2: items2){
                myCart.add(item2);
            }
                        
            
        }

        if (action.equals("remove")) {

        	String[] items2=request.getParameterValues("item");
        	for(String item2: items2){
                myCart.remove(item2);
            }
                        
            
        }
        
        if(action.equals("view")){
            return new ModelAndView("cart");
        }

        session.setAttribute("myCart", myCart);
    //     RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
      //   rd.forward(request, response);
      return new ModelAndView("cart","myCart",myCart);
    }
    
}
