package com.me.part4.pojo;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
	
	private List<Books> bookslist = new ArrayList<Books>();
	
	

	public BookCollection() {
	}

	public List<Books> getBookslist() {
		return bookslist;
	}

	public void setBookslist(List<Books> bookslist) {
		this.bookslist = bookslist;
	}
	
	
}
