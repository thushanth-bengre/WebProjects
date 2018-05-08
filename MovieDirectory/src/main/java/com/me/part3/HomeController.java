package com.me.part3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.part3.pojo.Movie;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "index";	
		
	}
	
	@RequestMapping(value = "/addmovie.htm", method = RequestMethod.GET)
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "addmovie";
	}
	
	@RequestMapping(value = "/browse.htm", method = RequestMethod.GET)
	public String browse(Model model) {		
		return "browsepage";
	}
	
}
