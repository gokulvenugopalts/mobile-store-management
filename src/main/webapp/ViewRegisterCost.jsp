<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/CreateInput.js" type="text/javascript"></script>
<title>Search By Cost</title>
<link href="css/ViewRegisterCost.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="registercontentstyle"><span id="registerstyle">Search Register</span></div>
	
	<div class="contentstyle">
	<form action="ViewRegisterController" onsubmit="return checkCost()" method="post" id="contentformstyle">
		
		<input type="text" name="searchcost" id="searchcoststyle" placeholder="Enter Cost to be searched"/>
		<input type="submit" name="search" id="searchstyle" value="Search by Cost"
				onclick="createField()"/>
	</form>
	
    <a href="viewregister.jsp" id="backbuttonstyle">Back</a>
    <a href="index.jsp" id="backhomestyle">Back to Home</a></div>
</body>
</html>