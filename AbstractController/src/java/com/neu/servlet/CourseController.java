/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.servlet;

import com.me.model.Course;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class CourseController extends AbstractController {
    
    public CourseController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         List<Course> courseList;

    //Global object belongs to every users.
    //Be careful, do not put anything here that you don't want to share.
    //Later this will come from the database.

    //@Override
    //public void init() { //init method is called only once when you first enter the servlet.
        //This method will only be call for once
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
        
    

    

    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {*/
        //We are using one servlet for multiple things.
        //action is the url parameter to differentiate between different requests
        String action = request.getParameter("action");
        System.out.println("I am here"+action);
        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false); //set to false because a new session shouldn't be created at this page

         HashSet<Course> myCourses =  ( HashSet<Course>) session.getAttribute("myCourses");
        if(myCourses==null){
            session.setAttribute("myCourses", new HashSet<Course>());
        }
        if (action.equals("add")) {

            String[] crns = request.getParameterValues("crn");
            
            for(String crn: crns){
                for(Course c: courseList) {
                   if(c.getCrn().equals(crn)){      //same way for remove.
                       myCourses.add(c);
                       break;
                   }
                }
            }
            session.setAttribute("myCourses", myCourses);
               return new ModelAndView("mycourses","courselist",courseList);

        } else if (action.equals("search")) {
            
            String searchType = request.getParameter("searchType");
            String key = request.getParameter("query");
            ArrayList<Course> searchResults =  new ArrayList<Course>();
            if(searchType.equals("crn")){
                for(Course c: courseList) {
                    if(c.getCrn().equals(key))
                    {
                        searchResults.add(c);
                    }
                }
            }else if(searchType.equals("title")){
               
                for(Course c : courseList) {
                    if(c.getName().contains(key)  || c.getInstructor().contains(key)){
                        searchResults.add(c);
                    }
                }
            }    
             return new ModelAndView("courseview","searchResults",searchResults);
            
//            request.setAttribute("searchResults", searchResults);
//            RequestDispatcher rd = request.getRequestDispatcher("/courseview.jsp");  //gives the requestdispatcher object. We specify where we want to go using the forward slash followed by the jsp page or the servlet's url pattern
//            rd.forward(request, response);
        } else if(action.equals("remove")) {
           //To be completed by students as part of Lab HW
           String[] crns1 = request.getParameterValues("crn");
            
            for(String crn: crns1){
                for(Course c: myCourses) {
                   if(c.getCrn().equals(crn)){      
                       myCourses.remove(c);
                       break;
                   }
                }
            }
                         return new ModelAndView("mycourses","courselist",courseList);

        }else if(action.equals("shotcut")){
            return new ModelAndView("mycourses");
        }

    
    
    return null;
}
}
