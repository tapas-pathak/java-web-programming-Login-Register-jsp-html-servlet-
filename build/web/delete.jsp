<%@page import="java.sql.*" %>

<% 

        String id = request.getParameter("id");
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");

        pst = con.prepareStatement("DELETE FROM student WHERE id = ?");
        
        pst.setString(1, id);

        pst.executeUpdate();

%>

<script>
    
    alert("Record Deleted");
    
</script>

