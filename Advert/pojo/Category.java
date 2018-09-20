package com.me.lab8Student.pojo;

import java.util.HashSet;
import java.util.Set;
public class Category {
	
	
    private long categoryId;
    private String title;
	private Set<Advert> adverts = new HashSet<Advert>();

    public Category(String title) {
        this.title = title;
    }

    public Category() {
    }

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Advert> getAdverts() {
		return adverts;
	}

	public void setAdverts(Set<Advert> adverts) {
		this.adverts = adverts;
	}

	@Override 
	public String toString(){
		return title;
	}

}
