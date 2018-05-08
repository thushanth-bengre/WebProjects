package com.me.part4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.part4.dao.BooksDAO;
import com.me.part4.pojo.BookCollection;
import com.me.part4.pojo.Books;

@Controller
public class BooksController {
	
	@Autowired
	private BooksDAO booksDao;
	
		
	@RequestMapping(value = "/add.htm" , method = RequestMethod.POST)
	public String addBooks(@RequestParam("number") int num ,Model model) {
		model.addAttribute("num", num-1);
		return "addbooks";
	}
	
	@RequestMapping(value = "/added.htm" , method = RequestMethod.POST)
	public String addedBooks(@ModelAttribute("bookcollection") BookCollection books, Model model) {
		List<Books> bookslist = books.getBookslist();
		if(bookslist != null && bookslist.size() > 0) {
			for(Books book : bookslist ) {
				booksDao.addMovie(book);
			}
		}
		return "success";
	}
	
	@RequestMapping(value = "/browse.htm" , method = RequestMethod.GET)
	public String browseBooks(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Books> booklist = booksDao.browseMovie();
		model.addAttribute("bookList", booklist);
		return "view";
	}
}
