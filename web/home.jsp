<%-- 
    Document   : home
    Created on : Feb 4, 2023, 12:36:52 AM
    Author     : Pradipta Pathak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        Welcome <%=session.getAttribute("user")%>
        </br></br>
        <h2>Home.jsp Page! (Login Successfully)!</h2>
           </br></br>
        <a href="student.jsp">Student Registration System Crud using-JSP</a>
        </br></br>
        <a href="./LogoutServlet">Logout</a>
                
    </center>
    </body>
</html>
