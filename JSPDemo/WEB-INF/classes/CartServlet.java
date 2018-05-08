import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
    public void init() {

    	String a="abc";
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String action = request.getParameter("action");

       
        HttpSession session = request.getSession(false);
        Set<String>myCart;

        if(null!=session.getAttribute("myCart")){
            myCart=(Set<String>)session.getAttribute("myCart");
        }
        else{
            myCart=new HashSet<String>();
        }

        if (action.equals("add")) {

        	
            
            String[] items2=request.getParameterValues("item");
        	for(String item2: items2){
                myCart.add(item2);
            }
                        
            
        }

        if (action.equals("remove")) {

        	String[] items2=request.getParameterValues("item");
        	for(String item2: items2){
                myCart.remove(item2);
            }
                        
            
        }

         session.setAttribute("myCart", myCart);
         RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
         rd.forward(request, response);
        

        




    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }


}	