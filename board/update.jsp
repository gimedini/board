<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVO.title }</title>
</head>
<body>
  <h2>글 수정</h2>
  <form action="update" method="post">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>글 번호 : ${boardVO.bno }</p>
      <input type="hidden" name="bno" value="${boardVO.bno }">
    </div>
    <div>
      <p>
        제목 : <input type="text" name="title" value="${boardVO.title }" required>
      </p>
    </div>
    <div>
      <p>작성자 : ${boardVO.userid }</p>
      <p>작성일 : ${boardVO.cdate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="content" required>${boardVO.content }</textarea>
    </div>
    <div>
      <input type="submit" value="제출">
    </div>
  </form>

</body>
</html>







