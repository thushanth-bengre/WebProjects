/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.LoginDAO;
import com.me.dao.MessageDAO;
import com.me.pojo.Login;
import com.me.pojo.Message;
import com.me.validator.LoginValidator;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Bengre
 */
public class LoginController extends SimpleFormController {
    
    public LoginController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Login.class);
        setCommandName("login");
        setSuccessView("loginSuccess");
        setFormView("loginForm");
        setValidator(new LoginValidator());
    }
    
    
   
   // protected void doSubmitAction(Object command) throws Exception {
        
  //  }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = null;
        Login login = (Login) command;
        LoginDAO ldao = (LoginDAO) this.getApplicationContext().getBean("ldao");
        
        if(ldao.checkLogin(login)){ 
            MessageDAO mdao = (MessageDAO) this.getApplicationContext().getBean("mdao");
            ArrayList<Message> messageList= mdao.getMessages(login.getUsername());
           return new ModelAndView("loginSuccess","messageList",messageList);
        }else{
            return new ModelAndView("loginFailure");
        }
        
    }
     
}
