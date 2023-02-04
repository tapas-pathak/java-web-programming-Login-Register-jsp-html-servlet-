

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>

<% 

    if(request.getParameter("submit")!=null)
    {
        String id=request.getParameter("id");
        String name=request.getParameter("sname");
        String course=request.getParameter("course");
        String fee=request.getParameter("fee");

        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");

        pst = con.prepareStatement("UPDATE student SET sname=?,course=?,fee=? WHERE id = ?");
        pst.setString(1, name);
        pst.setString(2, course);
        pst.setString(3, fee);
        pst.setString(4, id);

        pst.executeUpdate();

%>

<script>
    
    alert("Record Updated successfully");
    
</script>
<%
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <%--
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        --%>
        <link href="bootstrap-4.1.3-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Student Update</h1>
        
        <div class="row">
            <div class="col-sm-4">
                <form method="POST" action="#">
                    
                    <%
                        Connection con;
                        PreparedStatement pst;
                        ResultSet rs;

                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
                        
                        String id = request.getParameter("id");
                        pst = con.prepareStatement("SELECT * FROM student WHERE  id = ?");
                        pst.setString(1, id);
                        rs = pst.executeQuery();
                        
                        while(rs.next())
                        {

                    
                    
                    %>
                    
                    <div alight =" left">
                        <label class="form-label">Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" value="<%=rs.getString("sname")%>" name="sname" id="sname" required>
                    </div>
                    
                    <div alight =" left">
                        <label class="form-label">Course</label>
                        <input type="text" class="form-control" placeholder="Course" value="<%=rs.getString("course")%>" name="course" id="course" required>
                    </div>
                    
                    <div alight =" left">
                        <label class="form-label">Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" value="<%=rs.getString("fee")%>" name="fee" id="fee" required>
                    </div>
                    
                    <%
                    }
                    %>
                    </br>
                    <div alight =" right">
                        <input type="submit" id="submit" value="submit" name="submit" class="btn-info">
                        <input type="reset" id="reset" value="reset" name="reset" class="btn-warning">                       
                    </div>
                    
                    <div alight="right">
                        <p><a href="index.html">Click Back</a></p>
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
