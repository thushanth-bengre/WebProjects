package com.me.part3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.part3.dao.MovieDAO;
import com.me.part3.pojo.Movie;

@Controller
public class BrowseController {
	
	@Autowired
	private MovieDAO movieDao;

	
	@RequestMapping(value = "/browse" , method = RequestMethod.GET)
	public String browseMovie(HttpServletRequest request, HttpServletResponse response, Model model){
		
		String key = request.getParameter("keyword");
		String searchby = request.getParameter("search");
		System.out.println("Filtered text is " + key);
		
		List<Movie> movieList = movieDao.browseMovie(key, searchby);
		
		if(!(movieList.equals(null))) {
		model.addAttribute("movieList", movieList);		
		return "result";
		}else {
			return "noresult";
		}
	}
}
