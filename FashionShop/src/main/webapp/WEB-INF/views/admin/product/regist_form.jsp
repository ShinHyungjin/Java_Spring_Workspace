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

#dragArea {
	width:100%;
	height:300px;
	border:1px solid #ccc;
	overflow: scroll;
}
.dragBorder {
	background:#ffffff;
}
.close {
	color:red;
	cursor:pointer;
}
.box {
	float:left;
	width:100px;
	padding:5px;
}
.box > img{
	width:100%;
}
</style>
<script>
var uploadFiles=[];
var psizeArray = [];
var colorArray = [];

$(function() {
    CKEDITOR.replace( 'detail' );
    
    //상위 카테고리 선택시 하위 카테고리 비동기로 얻어오기
    $($("select")[0]).change(function() {
    	getSubList(this);
	});
    $("#dragArea").on("dragenter", function(e) {
		//$(this).append("dragenter<br>");
		$(this).addClass("dragBorder");
	});
    $("#dragArea").on("dragover", function(e) {
    	e.preventDefault();
		//$(this).append("dragover<br>");
		//$(this).removeClass("dragBorder");
	});
    $("#dragArea").on("drop", function(e) {
    	e.preventDefault();
		//$(this).append("drop<br>");
		
		var fileList = e.originalEvent.dataTransfer.files;
		console.log(fileList);
		
		for(var i=0; i<fileList.length; i++) {
			uploadFiles.push(fileList[i]);
			preview(uploadFiles[i], i);			
		}
		
	});
    $("#dragArea").on("dragleave", function(e) {
		$(this).append("dragleave<br>");
		$(this).removeClass("dragBorder");
	});
    
    
    $("#dragArea").on("click", ".close", function(e) {
		console.log(e);
		
		var f = uploadFiles[e.target.id];
		var index = uploadFiles.indexOf(f);
		
		$(e.target).parent().remove();
		uploadFiles.splice(index,1);
		
		console.log(uploadFiles);
		
	});
    
    $("input[type='checkBox']").on("click", function(e) {
    	var ch = e.target;
		alert($(ch).val());	
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

function setPsizeArray() {
	
}

function regist() {
	//$("textarea").val(CKEDITOR.instances.detail.getData());
	
	var formData = new FormData($("form")[0]);
	
	$.each(uploadFiles, function(i, file) {
		formData.append("addImg", file, file.name);
		console.log(file.name);
	});
	
	formData.append("detail", CKEDITOR.instances["detail"].getData());
	
	
	
	$.ajax({
		url:"/admin/product/regist",
		data:formData,
		contentType:false,
		processData:false,
		type:"post",
		success:function(result) {
			alert(result);
		}
	});
	
	
	/* 동기 방식 업로드
	$("form").attr({
		action:"/admin/product/regist",
		method:"post",
		enctype:"multipart/form-data"
	});
	$("form").submit();
	*/
	
}

function preview(file,index) {
	var reader = new FileReader();
	reader.onload=function(e) {
		//console.log(e.currentTarget.result);
		
		var tag = "<div class=\"box\">";
		
		tag += "<div class=\"close\" id=\""+index+"\"'>X</div>";
		tag +="<img src=\""+e.currentTarget.result+"\"/>"
		
		tag +="</div>";
		$("#dragArea").append(tag);
	};
	reader.readAsDataURL(file);
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

	<div id="dragArea">
		
	</div>
    

	<p>
		XS <input type="checkbox" name="psize[0].fit" value="XS">
		S <input type="checkbox" name="psize[1].fit" value="S">
		M <input type="checkbox" name="psize[2].fit" value="M">
		L <input type="checkbox" name="psize[3].fit" value="L">
		XL <input type="checkbox" name="psize[4].fit" value="XL">
		XXL <input type="checkbox" name="psize[5].fit" value="XXL">
	</p>
    
    <p>
    	<input type="color" name="color[0].picker" value="#000000">
    	<input type="color" name="color[1].picker" value="#aabbcc">
    	<input type="color" name="color[2].picker" value="#ffeedd">
    	<input type="color" name="color[3].picker" value="#ffcccc">
    	<input type="color" name="color[4].picker" value="#efefef">
    	<input type="color" name="color[5].picker" value="#ffffff">
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