/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controllers;

import com.me.dao.AddMovieDAO;
import com.me.pojo.Movies;
import com.me.validator.MovieValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Bengre
 */
public class AddController extends SimpleFormController {
    
    
    public AddController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Movies.class);
        setCommandName("Movies");
        setSuccessView("successView");
        setFormView("addmovies");
        setValidator(new MovieValidator());
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {        
        Movies m = (Movies) command;
        AddMovieDAO adddao = (AddMovieDAO) this.getApplicationContext().getBean("addmoviedao");
        adddao.insertMovie(m);
        return new ModelAndView("movieadded");
        
    }
     
}
