<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.foodplaza.pojo.Food" %>
    
    <%@ page import="java.util.List" %>
     
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">
function clearForm()
{
   var elements=document.getElementsByClassName("error");
   for(var i=0; i<elements.length; i++)
   {
	   var element=elements[i];
	   element.innerHTML="*";
   }
}
function isValidFood()
{
	clearForm();
	var foodId=document.getElementById("foodId").value;
   var foodName=document.getElementById("foodName").value;
   var foodCategory=document.getElementById("foodCategory").value;
   var foodType=document.getElementById("foodType").value;
   var foodDescription=document.getElementById("foodDescription").value;
   var foodPrice=document.getElementById("foodPrice").value;
   
   if(foodId==null || foodId=="")
   {
   document.getElementById("efoodId").innerHTML="Please Enter Food Id";
   return false;
   }
   
   if(foodName==null || foodName=="")
	   {
	   document.getElementById("efoodName").innerHTML="Please Enter Food Name";
	   return false;
	   }
   
   if(foodCategory==null || foodCategory=="")
	   {
	   document.getElementById("efoodCategory").innerHTML="Please Enter Food Category";
	   return false;
	   }
   if(foodType=="select")
   {
   document.getElementById("efoodType").innerHTML="Please Select Food Type";
   return false;
   }
   
   if(foodDescription==null || foodDescription=="")
   {
   document.getElementById("efoodDescription").innerHTML="Please Enter Food Description";
   return false;
   }
   
   if(foodPrice==null || foodPrice=="")
   {
   document.getElementById("efoodPrice").innerHTML="Please Enter Food Price";
   return false;
   }
   else if(isNaN(foodPrice))
	   {
	   alert(isNaN(foodPrice));
	   document.getElementById("efoodPrice").innerHTML="Food Price Should Be Numeric Only";
	   return false;
	   }
   
   
}

</script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="formdiv">
<%Food f=(Food)session.getAttribute("foodObj"); %>
<form action="FoodServlet" method="post" onsubmit="return isValidFood()">
<input type="hidden" name="Operations" value="Update Food">
<fieldset>
<legend> Food Details</legend>
<table>

<tr>
<td><label>Food ID</label></td>
<td><input type="text" name="foodId" id="foodId" value="<%=f.getFoodId() %>" readonly="readonly">
<br><span class="error" id="efoodId">*</span>
</td>
</tr>

<tr>
<td><label>Food Name</label></td>
<td><input type="text" name="foodName" id="foodName" value="<%=f.getFoodName()%>">
<br><span class="error" id="efoodName">*</span>
</td>
</tr>
<tr>
<td><label>Food Category</label></td>
<td>
<br><span class="error" id="efoodCategory">*</span>
<select name="foodCategory" id="foodCategory" value="<%=f.getFoodCategory()%>" > 
<option value="select"> Select</option>
<option value="veg">Indian</option>
<option Value="non-veg">Mexican</option>
<option value="veg">Thai</option>
<option Value="non-veg">Italian</option>
<option value="veg">Chinese</option>
<option Value="non-veg">Korean</option>
</select>
</td>
</tr>
<tr>
<td><label>Food Type</label></td>
<td><span class="error" id="efoodType"></span><br>
<select name="foodType" id="foodType"  value="<%=f.getFoodType()%>"> 
<option value="select"> Select</option>
<option value="veg">Veg</option>
<option Value="non-veg">Non-Veg</option>
</select>
</td>
</tr>
<tr>
<td><label>Food Description</label></td>
<td><input type="text" name="foodDescription" id="foodDescription" value="<%=f.getFoodDescription() %>">
<br><span class="error" id="efoodDescription">*</span>
</td>
</tr>
<tr>
<td><label>Food Price</label></td>
<td><input type="text" name="foodPrice" id="foodPrice" value="<%=f.getFoodPrice()%>">
<br><span class="error" id="efoodPrice">*</span>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Update Food"/>
<input type="reset"/>
</td>
</tr>
</table>
</fieldset>
</form>
</div>
<jsp:include page="header.jsp"></jsp:include>
</body>
</html>