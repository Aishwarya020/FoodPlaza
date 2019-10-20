<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
<%@ page import="com.foodplaza.pojo.Food" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
</head>
<body>
<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>

<%List<Food> flist=(List<Food>)session.getAttribute("flist"); %>
<jsp:include page="header.jsp"></jsp:include>
<br><br>
<table border="1" align="center">

<%
String status=(String)request.getAttribute("Success");
if(status!=null)
{
	out.print(status);
}
%>


<caption>Food List</caption>
<tr> 
<th>Food Id </th>
<th>Food Name</th>
<th>Food Type</th>
<th>Food Category</th>
<th>Food Description</th>
<th>Food Price</th>
<th>Action</th>
</tr>

<%for(Food f:flist)
{ %>
<tr>
<td><%=f.getFoodId() %></td>
<td><%=f.getFoodName() %></td>
<td><%=f.getFoodType() %></td>
<td><%=f.getFoodCategory() %></td>
<td><%=f.getFoodDescription() %></td>
<td><%=f.getFoodPrice() %></td>
<td>
<% if(user!=null && admin==null)
            {%>
         <a href="CartServlet?operation=addToCart&foodId=<%=f.getFoodId() %>">Add To Cart</a>
           <%  } %>
            
<% if(user==null && admin!=null)
            {%>
            <a href="CartServlet?operation=delete&foodId=<%=f.getFoodId() %>">Delete |</a>
			<a href="CartServlet?operation=edit&foodId=<%=f.getFoodId() %>">Edit</a>
			  <%   }  %>
   </td>   
   <% 
            }
            %>      
</tr>
            
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>