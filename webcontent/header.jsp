<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>

<div id="templatemo_container">
<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="index.jsp"><b>Home</b></a></li>
            <li><a href="FoodServlet"><b>Food Menu</b></a></li>
    
            
            <% if(user!=null && admin==null)
            {%>
            <li><a href="CommonCustomerServlet?operation=edit"><b>Update Profile</b></a></li>
            
            <li><a href="CartServlet"><b>Show Cart</b></a></li>
            
            <li><a href="LoginServlet"><b>Log Out</b></a></li>
            
            
            <% 
            }
            %>
            
            
            <% if(user==null && admin!=null)
            {%>
             <li><a href="addfood.jsp"><b>Add Food</b></a></li>
            
             <li><a href="#"><b>Show Order</b></a></li>
            <li><a href="changepassword.jsp"><b>Change Password</b></a></li>
            
            <li><a href="LoginServlet"><b>Log Out</b></a></li>
            
            
            <% 
            }
            %>
            
            
            <% if(user==null && admin==null)
            {%>
            
            
             
            <li><a href="login.jsp"><b>Login</b></a></li>
            
            <li><a href="addcustomer.jsp"><b>Register</b></a></li>
            
            
            <% 
            }
            %>
            
        </ul>
    </div> <!-- end of menu -->
    </div>

        
       

</body>
</html>