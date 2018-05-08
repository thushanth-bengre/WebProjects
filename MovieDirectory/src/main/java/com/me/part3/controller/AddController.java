package com.me.part3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.part3.dao.MovieDAO;
import com.me.part3.pojo.Movie;
import com.me.part3.validator.MovieValidator;

@Controller
public class AddController {
	
	@Autowired
	private MovieValidator movieValidator;
	
	@Autowired
	private MovieDAO movieDao;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(movieValidator);
	}
	
	
	@RequestMapping(value = "/savemovie" , method = RequestMethod.POST)
	public String browseMovie(@Validated @ModelAttribute("movie") Movie movie, BindingResult result,Model model){
		if(result.hasErrors()) {
			return "addmovie";
		}
		
		movieDao.addMovie(movie);		
		return "movieadded";
	}
}
