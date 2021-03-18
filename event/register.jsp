<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.inputArea{margin: 10px 0;}
.select_img img{margin: 20px 0;}
</style>

<!-- jQuery로 이용하기 위한 태그 추가 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
<h2>글 작성 페이지</h2>
<form role="form" autocomplete="off" enctype="multipart/form-data" method="post">
  <div>
    <p>제목 : <input type="text" name="title" placeholder="제목 입력" required="required"></p>
  </div>
   <div>
    <p>작성자 : <input type="text" name="userid" placeholder="작성자 입력" required="required"></p>
  </div>
  <div>
    <textarea rows="20" cols="120" name="content" placeholder="내용 입력" required="required"></textarea>
  </div>
  

  
   <div class="inputArea">
 <label for="gdsImg">이미지</label>
 <input type="file" id="gdsImg" name="file" />
 <div class="select_img"><img src="" /></div>
 
 <script type="text/javascript">
 $("#gdsImg").change(function(){
	   if(this.files && this.files[0]) {
	    var reader = new FileReader;
	    reader.onload = function(data) {
	     $(".select_img img").attr("src", data.target.result).width(500);        
	    }
	    reader.readAsDataURL(this.files[0]);
	   }
	  });
 </script>
 
 <%=request.getRealPath("/") %> 
 
</div> 
  <div>
    <input type="submit" value="등록">
    <!-- 등록 누르면 -->
  </div>
  
</form>
</body>
</html>