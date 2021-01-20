<%@page import="com.hardware.test.model.domain.Hardware"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	List<Hardware> hardwareList = (List)request.getAttribute("hardwareList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<h2>HardWare List</h2>

<table>
  <tr>
    <th>No</th>
    <th>Name</th>
    <th>Brand</th>
    <th>Price</th>
  </tr>
  <%for(Hardware hardware : hardwareList){ %>
  	<tr>
    	<td><%=hardware.getHardware_id()%></td>
    	<td><%=hardware.getName()%></td>
    	<td><%=hardware.getBrand()%></td>
    	<td><%=hardware.getPrice()%></td>
  	</tr>
	<%} %>
</table>
</body>
</html>