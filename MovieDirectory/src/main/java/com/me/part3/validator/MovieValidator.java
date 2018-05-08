package com.me.part3.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.part3.pojo.Movie;

@Component
public class MovieValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		
		return clazz.isAssignableFrom(Movie.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty-name", "Title cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "empty-actor", "Actor cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "empty-actress", "Actress cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "empty-genre", "Genre cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty-year", "Year cannot be blank");
        
	}

}
