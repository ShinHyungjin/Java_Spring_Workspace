<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=button]:hover {
  background-color: #45a049;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script>

//상품 등록
function regist(){
	var formData = new FormData($("form")[0]);//<form>태그와는 틀리다..전송할때 파라미터들을 담을수있지만 이 자체가 폼태그는 아니다!!
	/*비동기 업로드*/
	$.ajax({
		url:"/admin/product/excel/regist",
		data:formData,
		contentType:false, /* false일 경우 multipart/form-data*/
		processData:false, /* false일 경우 query-string으로 전송하지 않음*/
		type:"post",
		success:function(responseData){
			var json = JSON.parse(responseData); //string --> json 으로 파싱..
			alert(json.msg);
		}
	});
}
</script>
</head>
<body>
<%@ include file="../inc/main_navi.jsp" %>

<div class="container">
   <form>
	<!-- 파일 최대 4개까지 지원 -->
	<p>엑셀파일 선택: <input type="file"  name="dump"></p>
    <input type="button" value="데이터 등록" onClick="regist()">
    <input type="button" value="상품목록" onClick="location.href='/client/notice/list'">
  </form>
</div>

</body>
</html>