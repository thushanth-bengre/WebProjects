/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controllers;

import com.me.dao.SearchMovieDAO;
import com.me.pojo.Movies;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class BrowseController extends AbstractController {
    
    public BrowseController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        SearchMovieDAO searchdao=(SearchMovieDAO) this.getApplicationContext().getBean("searchdao");
        String action = request.getParameter("action");
        if(action.equals("browse")){
            return new ModelAndView("browsepage");
        }else if (action.equals("fetch")){
            String keyword = request.getParameter("keyword");
            String searchBy = request.getParameter("search");
            List<Movies> movieList = searchdao.getMovieList(keyword, searchBy);
            request.setAttribute("movieList", movieList);
            return new ModelAndView("result", "movieList", movieList);            
        }
        return null;
    }
    
}
