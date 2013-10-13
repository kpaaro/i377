
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<form action="Search" method="post">
		<input id="searchStringBox" value="" name="searchString" /> <input
			id="filterButton" type="submit" value="Filtreeri" /> <br /> <br />
	</form>
	<table id="listTable" class="listTable">
		<thead>
			<tr>
				<th scope="col">Nimi</th>
				<th scope="col">Kood</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${searchResults}">
				<tr>
					<td>
						<div id="row_${item.code}">${item.name}</div>
					</td>
					<td>
						${item.code}
					</td>
					<td>		
						<a id="delete_${item.code}" href="Search?do=delete&id=${item.id}">Kustuta</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>