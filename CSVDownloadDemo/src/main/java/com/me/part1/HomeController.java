package com.me.part1;



import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.part1.dao.CSVDao;
import com.me.part1.pojo.CSVData;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("csvDao")
	CSVDao csvDao;
	
	private int ROWS_TO_DISPLAY = 500; // Number of rows to display
	HttpSession rowSession;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/loadData", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView viewData(HttpServletRequest request) {
		HttpSession session = null;
		logger.info(String.valueOf(request.getParameter("action")));
		logger.info(String.valueOf(request.getParameter("csvfilename")));
		String filename = String.valueOf(request.getParameter("csvfilename"));
		filename = "SalesOrder";
		ArrayList<CSVData> fetchCsvArr;
		session = request.getSession();
		session.setAttribute("ROWS_TO_DISPLAY", ROWS_TO_DISPLAY);
		if(request.getParameter("page") == null) {
			fetchCsvArr = csvDao.getCsvData(filename, 1);
		} else {
			fetchCsvArr = csvDao.getCsvData(filename, Integer.parseInt(request.getParameter("page")));
		}
		
		int rowCount = csvDao.getCsvCount(filename);
		session.setAttribute("rowCount", String.valueOf(Math.abs(rowCount/ROWS_TO_DISPLAY)));
		return new ModelAndView("show-data", "success", fetchCsvArr);
	}
	
}
