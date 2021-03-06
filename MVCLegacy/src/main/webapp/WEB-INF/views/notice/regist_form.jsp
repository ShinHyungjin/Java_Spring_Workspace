<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

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
function regist() {
	var form = document.querySelector("form");
	form.action="/client/notice/regist";
	form.method="post";
	form.submit();
}

</script>
</head>
<body>

<div class="container">
  <form>
    <input type="text" name="title" placeholder="Your title">
    <input type="text" name="writer" placeholder="Your name">
    <textarea name="content" placeholder="Write something.." style="height:200px"></textarea>

    <input type="button" value="등록하기" onClick="regist()">
    <input type="button" value="목록보기" onClick="location.href='/notice/list'">
    
  </form>
</div>

</body>
</html>