<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
  <h2>게시판 작성</h2>
  <form role="form" method="post" autocomplete="off">
    <label>게시판 선택</label>
    <select class="category1" name="cateCode">
      <option value="">전체</option>
    </select>


    <div>
      <p>
        제목 : <input type="text" name="title" placeholder="제목 입력"
          required="required">
      </p>
    </div>

<!--     <script type="text/javascript">
    function selectBoard(){
        var selected = $("#categorys > option:selected").text();
        // $("#his_year_1")의 선택한 값을 불러온다.

         $("#categorys").val(selected);
        // 위에서 부른 값을 hidden값에 넣어서 DB 저장시 사용..
     }
    </script> -->

    <div>
      <p>
        작성자 : <input type="text" name="userid" placeholder="작성자 입력"
          required="required">
      </p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="content" placeholder="내용 입력"
        required="required"></textarea>
    </div>
    <div>
      <input type="submit" value="등록">
    </div>
  </form>
  
  <script type="text/javascript">
//컨트롤러에서 데이터 받기
  var jsonData = JSON.parse('${category}');
  console.log(jsonData);
  var cate1Arr = new Array();
  var cate1Obj = new Object();
  // 1차 분류 셀렉트 박스에 삽입할 데이터 준비
  for(var i = 0; i < jsonData.length; i++) {
  	
  	if(jsonData[i].level == "2") {
  		cate1Obj = new Object();  //초기화
  		cate1Obj.cateCode = jsonData[i].cateCode;
  		cate1Obj.cateName = jsonData[i].cateName;
  		cate1Arr.push(cate1Obj);
  	}
  }
  // 1차 분류 셀렉트 박스에 데이터 삽입
  var cate1Select = $("select.category1")
  for(var i = 0; i < cate1Arr.length; i++) {
  	cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
  						+ cate1Arr[i].cateName + "</option>");	
  }


</script>
 
</body>
</html>

