/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    Connection con;
    Statement stm;
    ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //work on doPost method
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //accept username and password from index.html file
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        //database
        try {
            //open connection
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
            //mydb is database
            //username is root
            //password is ""

            //get data from user table using query
            stm = con.createStatement();
            rs = stm.executeQuery("select * from registration where uname='" + uname + "' and upass='" + upass + "'");

            if (rs.next()) {
                //if username and password true than go to Home.html file
                //response.sendRedirect("Home.html");

                /**
                 * Session start**
                 */
                HttpSession session = request.getSession();
                String u = request.getParameter("uname");
                session.setAttribute("user", u);
                //response.sendRedirect("home.jsp");

                /**
                 * ***
                 */
                RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
                dis.forward(request, response);

            } else {
                //wrong username and password
                out.println("<center><p style=color:red>Wrong username and password...</p></center>");

                RequestDispatcher dis = request.getRequestDispatcher("index.html");
                dis.include(request, response);

            }
            //close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
