<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.foodplaza.pojo.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br>
<%
String status=(String)request.getAttribute("Success");
if(status!=null)
{
	out.print(status);
}
%>
<%List<Customer> clist=(List<Customer>)session.getAttribute("clist"); %>
<table border="1" align="center">
<tr> 
<th>Customer Id </th><br>
<th>Customer Name</th><br>
<th>Customer EmailId</th><br>
<th>Customer Password</th><br>
<th>Customer Address</th><br>
<th>Customer Contact No</th><br>
<th>Action</th>
</tr>

<%for(Customer c:clist)
{ %>
<tr>
<td><%=c.getCustid() %></td>
<td><%=c.getCustname() %></td>
<td><%=c.getCustemailid() %></td>
<td><%=c.getPassword() %></td>
<td><%=c.getAddress() %></td>
<td><%=c.getContactno() %></td>
<td><a href="CommonCustomerServlet?operation=delete&custid=<%=c.getCustid() %>">Delete |</a>
<a href="CommonCustomerServlet?operation=edit&custid=<%=c.getCustid() %>">Edit</a>
</tr>
<%} %>

</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>