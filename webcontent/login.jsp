<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="jquery.min.js"> </script>
<script src="jquery.validate.js"> </script>
<script type="text/javascript">

$(document).ready(function(){
	   
	 $("form").validate ({
	rules: {
		type:{required:true} ,
		customerEmailid:{required:true},
		
		password:{required:true,minlength:8}
		}	 
		 
		 }) ;
	
});


</script>
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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="formdiv">
<form action="LoginServlet" method="post">
<input type="hidden" name="action" value="login">
<fieldset>
<legend>Login Page</legend>
<table>
<tr>
<td><label>User Type</label> </td>
<td> <input type="radio" name="type" value="Admin">Admin <br/></td>
<td> <input type="radio" name="type" value="Customer">Customer<br/></td>
</tr>

<tr>
<td><label>Email Id</label></td>
<td><input type="email" name="customerEmailid" id="customerEmailid">
<br><span class="error" id="ecustomerEmailid">*</span>
</td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="password" name="password" id="password">
<br><span class="error" id="epassword">*</span>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Login"/>
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