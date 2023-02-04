/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pradipta Pathak
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //get ssession
        HttpSession session=request.getSession();
        //check if session is null or not if null than redirect to login
        if(session.getAttribute("user")!=null){
            //if session not null than go to home page
            response.sendRedirect("home.jsp");        
        }
        else{
            //is session attribute is null than redirectto login page
            response.sendRedirect("index.html");
        
        }
        
    }

    

}
