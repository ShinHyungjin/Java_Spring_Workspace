<%@page import="com.koreait.fashionshop.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	List <TopCategory> topList = (List)request.getAttribute("topList");

%>
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
$(function() {
    CKEDITOR.replace( 'detail' );
    
    //상위 카테고리 선택시 하위 카테고리 비동기로 얻어오기
    $($("select")[0]).change(function() {
    	getSubList(this);
	});
});

//비동기 방식으로 하위카테고리 요청
function getSubList(obj) {
	 $.ajax({
		 url: "/admin/product/sublist", 
		 type:"get",
		 data:{
			 topcategory_id:$(obj).val()
		 }, 
		 success:function(result) {
			 $($("select")[1]).empty();
			 $($("select")[1]).append("<option>하위 카테고리 선택</option>");
			//alert(result);
			//서버가 이미 Json으로 보내주어서 parsing이 필요없다
			for(var i=0; i<result.length; i++) {
				var subCategory = result[i];
				$($("select")[1]).append("<option value=\""+subCategory.subcategory_id+"\">"+subCategory.name+"</option>");
			}
		 }
		});
}

function regist() {
	$("form").attr({
		action:"/admin/product/regist",
		method:"post",
		enctype:"multipart/form-data"
	});
	$("form").submit();
}

</script>
</head>
<body>

<%@ include file="../inc/main_navi.jsp"%>

<div class="container">
  <form>
  <select>
  	<option>상위 카테고리 선택</option>
  	<%for(TopCategory topCategory : topList) {%>
	  	<option value="<%=topCategory.getTopcategory_id()%>"><%=topCategory.getName() %></option>
	  	<%} %>
  </select>
  
  <select name="subcategory_id">
  	<option>하위 카테고리 선택</option>
  </select>
  
    <input type="text" name="product_name" placeholder="상품명">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="brand" placeholder="브랜드">
    
    <p>대표이미지<input type ="file" name="repImg"></p>
    
    <p>추가이미지<input type ="file" name="addImg"></p>
    <p>추가이미지<input type ="file" name="addImg"></p>
    <p>추가이미지<input type ="file" name="addImg"></p>
    <p>추가이미지<input type ="file" name="addImg"></p>

	<p>
		XS <input type="checkbox" name="fit" value="XS">
		S <input type="checkbox" name="fit" value="S">
		M <input type="checkbox" name="fit" value="M">
		L <input type="checkbox" name="fit" value="L">
		XL <input type="checkbox" name="fit" value="XL">
		XXL <input type="checkbox" name="fit" value="XXL">
	</p>
    
    <p>
    	
    </p>
    
    <textarea id="detail" name="detail" placeholder="상세정보" style="height:200px"></textarea>
    
    
	<p>
    <input type="button" value="등록하기" onClick="regist()">
    <input type="button" value="목록보기" onClick="location.href='/admin'">
    </p>
  </form>
</div>

</body>
</html>