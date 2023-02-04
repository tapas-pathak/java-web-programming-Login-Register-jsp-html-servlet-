/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pradipta Pathak
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            Class.forName("com.mysql.jdbc.Driver");

            String ipAddress = "127.0.0.1";
            String portN = "3306";
            String databaseName = "mydb";
            String mUser = "root";
            String mPswd = "";

            String dbURL = "jdbc:mysql://" + ipAddress + ":" + portN + "/" + databaseName + "?&useSSL=false";

            //this.con = (Connection) DriverManager.getConnection(dbURL, mUser, mPswd);
            con = DriverManager.getConnection(dbURL, mUser, mPswd);
            //con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");

            String uname = request.getParameter("uname");
            String uaddress = request.getParameter("uaddress");
            String uemail = request.getParameter("uemail");
            String uphone = request.getParameter("uphone");
            String upass = request.getParameter("upass");
            String urepass = request.getParameter("urepass");

            pst = con.prepareStatement("INSERT INTO registration (uname, uaddress, uemail, uphone, upass, urepass) VALUES (?,?,?,?,?,?)");

            pst.setString(1, uname);
            pst.setString(2, uaddress);
            pst.setString(3, uemail);
            pst.setString(4, uphone);
            pst.setString(5, upass);
            pst.setString(6, urepass);

            pst.executeUpdate();

            pst1 = con.prepareStatement("select max(uid) from registration");
            rs = pst1.executeQuery();
            rs.next();

            int regno;
            regno = rs.getInt(1);

            out.println("Thank you for your Registration");
            out.println("Your Registration No is :" + " REG-000" + regno);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
