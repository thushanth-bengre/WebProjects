/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.validator;

import com.me.pojo.Movies;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bengre
 */
public class MovieValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Movies.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty-name", "Title cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "empty-actor", "Actor cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "empty-actress", "Actress cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "empty-genre", "Genre cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty-year", "Year cannot be blank");        
    }
    
}
