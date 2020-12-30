<%@ page contentType="text/html; charset=utf-8"%>
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
});

function regist() {
	var form = document.querySelector("form");
	form.action="/client/notice/regist";
	form.method="post";
	form.submit();
}

</script>
</head>
<body>

<%@ include file="../inc/main_navi.jsp"%>

<div class="container">
  <form>
  <select>
  	<option>상위 카테고리 선택</option>
  </select>
  
  <select>
  	<option>하위 카테고리 선택</option>
  </select>
  
    <input type="text" name="product_name" placeholder="상품명">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="brand" placeholder="브랜드">
    
    <p>대표이미지<input type ="file" ></p>
    
    <p>추가이미지<input type ="file" ></p>
    <p>추가이미지<input type ="file" ></p>
    <p>추가이미지<input type ="file" ></p>
    <p>추가이미지<input type ="file" ></p>

	<p>
		XS <input type="checkbox">
		S <input type="checkbox">
		M <input type="checkbox">
		L <input type="checkbox">
		XL <input type="checkbox">
		XXL <input type="checkbox">
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