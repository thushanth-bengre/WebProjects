/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.dao.CsvDAO;
import com.me.dao.DatabaseDAO;
import com.me.pojo.SalesOrder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Bengre
 */
public class CsvController extends AbstractController {
    
    public CsvController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        CsvDAO csvdao = (CsvDAO) this.getApplicationContext().getBean("csvdao");
        DatabaseDAO dbdao = (DatabaseDAO) this.getApplicationContext().getBean("databasedao");
       
        if(action.equals("loadcsv")){            
            session.setAttribute("view", "csvData");
            session.setAttribute("csv", request.getParameter("csv"));
            return new ModelAndView("index");
        }else if(action.equals("load")){
            List<SalesOrder> salesOrderList = (List<SalesOrder>) session.getAttribute("salesOrderList");
            int j = dbdao.save(salesOrderList);
            session.setAttribute("rows", j);
            session.setAttribute("view", "uploaded");
            return new ModelAndView("index");
        }
        return null;
    }
    
}
