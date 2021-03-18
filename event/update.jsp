<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Date class 사용위해 taglib 추가 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVO.title }</title>
</head>
<body>
<h2>글 수정</h2>

<form action="update" method="post">
  <!-- 전송 -> redirect시 번호를 알아야함 -->
  <input type="hidden" name="page" value="${page }">
  <div>
    <p>글 번호 : ${boardVO.bno }</p>
    <input type="hidden" name="bno" value="${boardVO.bno }" ><!-- hidden : 보여줄 필요 없을때 사용 -->
  </div>
  <div>
    <p>제목 <input type="text" name="title" value="${boardVO.title }" required></p>
  </div>
  <div>
    <p>작성자 : ${boardVO.userid }</p>
        <fmt:formatDate value="${boardVO.cdate }"
            pattern="yyyy-mm-dd HH:mm:ss"
            var="cdate"/>
          <!-- String cdate면 그냥 vo.cadte 사용 -->
    <p>작성일 : ${cdate }</p>
  </div>
  <div>
    <textarea rows="20" cols="120" name="content" required>${boardVO.content }</textarea>
  </div>
  <div>
    <input type="submit" value="수정">
  </div>
</form>
</body>
</html>