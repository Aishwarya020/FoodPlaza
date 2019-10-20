<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<script src="jquery.min.js"> </script>
<script src="jquery.validate.js"> </script>
<script type="text/javascript">
$(document).ready(function(){
   
	 $("form").validate ({
	rules: {
		oldPassword:{required:true,minlength:8},
		newPassword:{required:true,minlength:8},
		confirmPassword:{required:true,minlength:8,equalTo:"#confirmPassword"}
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
<input type="hidden" name="action" value="changePass">
<fieldset>
<legend>Change Password</legend>
<table>

<tr>
<td><label>Old Password</label></td>
<td><input type="password" name="oldPassword" id="password">
<br><span class="error" id="epassword">*</span>
</td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="password" name="newPassword" id="password">
<br><span class="error" id="epassword">*</span>
</td>
</tr>
<tr>
<td><label>Re-Type Password</label></td>
<td><input type="password" name="repassword" id="confirmPassword">
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