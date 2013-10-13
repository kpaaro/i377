<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Part 3</title>
<style type="text/css">
<%@ include file="/css/style.css" %>
</style>

</head>

<body>



<%@ include file="menu.jsp"%>
<br><br><br>

<form action="Add" method="post">
	<table id="formTable" class="formTable">
		<tr>
			<td>Nimi: </td>
			<td><input id="nameBox" name="name" /></td>
		</tr>
		<tr>
			<td>Kood: </td>
			<td><input id="codeBox" name="code" /></td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<br />
				<input id="addButton" type=submit value="Lisa"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>