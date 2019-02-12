<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/GetOperList.js" type="text/javascript"></script>
<script src="js/RegisterCheck.js" type="text/javascript"></script>
<link href="css/addregister.css" rel="stylesheet" type="text/css"/>
<title>Add a Register</title>
</head>
<body onload="getOperList();">
		<div id="hometitlestyle">
			<span id="titlestyle">Add Register</span>
		</div>
		<div id="registerformstyle">
			<form onsubmit="return check()" action="AddRegisterController" method="post" id="formstyle">
				<input type="text" name="name" id="namestyle" placeholder="Name"/>
				<select name="opersystem" id="opersystemstyle"></select>
				<input type="text" name="modelname" id="modelnamestyle" placeholder="Model Name"/>
				<input type="text" name="modelcost" id="modelcoststyle" placeholder="Cost of the Model"/>
				<input type="submit" name="registersubmit" id="registersubmitstyle" value="Add Registeration"/>
			</form>
			<a href="index.jsp" id="backbuttonstyle">Back</a>
		</div>
</body>
</html>