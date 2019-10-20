<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Add Customer</title>
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
		customerName:{required:true , number:false} ,
		customerEmailid:{required:true},
		password:{required:true,minlength:8},
		customerAddress:{required:true},
		customerContactNo:{required:true,minlength:10,maxlength:10,number:true}}	 
		 
		 }) ;
	
});





</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="formdiv">
<form action="CommonCustomerServlet" method="post" onsubmit="return isValidCustomer()">
<input type="hidden" name="Operations" value="Add Customer">
<fieldset>
<legend> Customer Details</legend>
<table>


<tr>
<td><label>Customer Name</label></td>
<td><input type="text" name="customerName" id="customerName">

</td>
</tr>
<tr>
<td><label>Customer Email Id</label></td>
<td><input type="email" name="customerEmailid" id="customerEmailid">
</td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="password" name="password" id="password">
</td>
</tr>
<tr>
<td><label>Customer Address</label></td>
<td><textarea rows="5" cols="20" name="customerAddress" id="ecustomerAddress">
</textarea> <br/> 

</td>
</tr>
<tr>
<td><label>Customer ContactNo</label></td>
<td><input type="text" name="customerContactNo" id="customerContactNo">
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Add Customer"/>
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