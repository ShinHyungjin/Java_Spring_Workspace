<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
	alert("<%=request.getAttribute("msg")%>");
	history.back();
</script>
