<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodplaza.pojo.Customer" %>
    
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<style type="text/css">
.formdiv
{
width:300px;
margin:10px auto;
}

.error
{
color:red;
font-size:14px;
}

</style>

<script src="jquery.min.js"> </script>
<script src="jquery.validate.js"> </script>
<script type="text/javascript">
$(document).ready(function(){
   
	 $("form").validate ({
	rules:{
		customerId:{required:true},
		customerName:{required:true},
		customerEmailid:{required:true},
		password:{required:true,minlength:8},
		customerAddress:{required:true},
		customerContactNo:{required:true,minlength:10,maxlength:10}}	 
		 
		 }) ;
	
});



</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="formdiv" >
<%Customer c=(Customer)session.getAttribute("CustObj"); %>
<form action="CommonCustomerServlet" method="post">
<input type="hidden" name="Operations" value="Update Customer">
<fieldset>
<legend> Customer Details</legend>
<table>
<tr>
<td><label>Customer Id</label></td>
<td><input type="text" name="customerId" id="customerId"  readonly value="<%=c.getCustid()%>">

</td>
</tr>

<tr>
<td><label>Customer Name</label></td>
<td><input type="text" name="customerName" id="customerName" value="<%=c.getCustname()%>">

</td>
</tr>
<tr>
<td><label>Customer Email Id</label></td>
<td><input type="email" name="customerEmailid" id="customerEmailid" value="<%=c.getCustemailid()%>">

</td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="password" name="password" id="password" value="<%=c.getPassword()%>">
</td>
</tr>
<tr>
<td><label>Customer Address</label></td>
<td><textarea rows="5" cols="20" name="customerAddress"  id="address" value="<%=c.getAddress()%>">
</textarea>
</td>
</tr>
<tr>
<td><label>Customer ContactNo</label></td>
<td><input type="text" name="customerContactNo" id="customerContactNo" value="<%=c.getContactno()%>">

</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Update Customer"/>
<input type="reset"/>
</td>
</tr>
</table>
</fieldset>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>