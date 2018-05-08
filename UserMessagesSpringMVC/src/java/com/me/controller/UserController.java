/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.bean.User;
import com.me.dao.UserDAO;
import com.me.pojo.Message;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        ArrayList<Message> userList = new UserDAO().getMessages();
       ModelAndView mav = new ModelAndView("userView","userlist", userList);              
       return mav;
    }
    
}
