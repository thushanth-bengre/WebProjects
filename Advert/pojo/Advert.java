package com.me.lab8Student.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;


@Entity
public class Advert {
	

    private long id;
	
	
    private String title;
	
	
    private String message;
	
	
	private User user;
	
	
	private Set<Category> categories = new HashSet<Category>();
	

	int postedBy;

    public Advert(String title, String message, User user, Category catergory) {
        this.title = title;
        this.message = message;
        this.user = user;      
        //this.categories.add(catergory);
    }

    public Advert() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public int getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}

    

}
