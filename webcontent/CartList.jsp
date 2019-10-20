<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.foodplaza.pojo.Cart" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart List</title>
</head>
<body>
<%List<Cart> cList=(List<Cart>)session.getAttribute("cList"); %>
<jsp:include page="header.jsp"></jsp:include>
<br><br>
<form action="CartServlet" method="post">
<table border="1" align="center">
<caption>Cart List</caption>
<tr>
<th>CartId</th>
<th>FoodId</th>
<th>Food Name</th>
<th>Food Price</th>
<th>Quantity</th>
<th>Action</th>
</tr>
<%

for(Cart c:cList)
{%>
<tr>
<td><%=c.getCartId() %></td>
<td><%=c.getFoodId() %></td>
<td><%=c.getFoodName() %></td>

<td><input type="text" name="price" value="<%=c.getFoodPrice() %>" readonly></td>
<td><input type="number" min="1" name="quantity" value="<%=c.getFoodqty() %>" ></td>



<td><a href="CartServlet?operation=delete&cartId=<%=c.getCartId() %>">Delete</a></td>
</tr>

<%}%>
</table>
<br><br>
<center>
<input  type="submit"  value="Place Order" >
</center>



</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>