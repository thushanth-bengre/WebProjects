/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.BooksDAO;
import com.me.pojo.Books;
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
public class BooksController extends AbstractController {
    
    public BooksController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        BooksDAO booksdao = (BooksDAO) this.getApplicationContext().getBean("booksdao");
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        
        if(action.equals("add")){
            int num = Integer.parseInt(request.getParameter("number"))-1;
            session.setAttribute("number", num);
            return new ModelAndView("addbooks");
        }else if(action.equals("view")){
            List<Books> bookList = booksdao.getMovieList();
            return new ModelAndView("view","bookList",bookList);
        }else if(action.equals("added")){
            Books b = (Books) this.getApplicationContext().getBean("books");
            int j = Integer.parseInt(String.valueOf(session.getAttribute("number")));
            System.out.println("j = " +j);
            for(int i=0;i<=j;i++){                
                String isbn = request.getParameter("isbn" + i);
                String title = request.getParameter("title" + i);
                String author = request.getParameter("author" + i);
                String price = request.getParameter("price" + i);
                b.setAuthor(author);
                b.setIsbn(isbn);
                b.setName(title);
                System.out.println(
                        "com.me.controller.BooksController.handleRequestInternal():"
                        + " price = " + price
                        + " isbn = " + isbn
                        + " author = " + author
                        + " title = " + title);
                
                b.setPrice(Double.parseDouble(price));
                System.out.println("Books here" +b.getAuthor() + b.getIsbn() + b.getName());
                booksdao.insertBooks(b);
            }
            return new ModelAndView("success");
        }
        return null;
    }
    
    
}