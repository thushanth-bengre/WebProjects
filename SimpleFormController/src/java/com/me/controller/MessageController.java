/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class MessageController extends AbstractController {
    
    public MessageController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        if(request.getRequestURI().endsWith("display.htm")){
            return new ModelAndView("messageView","msgType","Display");
        }else if(request.getRequestURI().endsWith("send.htm")){
            return new ModelAndView("messageView","msgType","Send");
        }else if(request.getRequestURI().endsWith("search.htm")){
            return new ModelAndView("messageView","msgType","Search");
        }else if(request.getRequestURI().endsWith("delete.htm")){
            return new ModelAndView("messageView","msgType","Delete");
        }
        return null;
    }
    
}
