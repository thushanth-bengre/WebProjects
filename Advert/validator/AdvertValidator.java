package com.me.lab8Student.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.me.lab8Student.pojo.Advert;



public class AdvertValidator implements Validator {
	
	public boolean supports(Class aClass) {
		return aClass.equals(Advert.class);
	}

	public void validate(Object obj, Errors errors) {
		Advert newAdvert = (Advert) obj;

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
		// "error.invalid.category", "Category Required");
	}
}
