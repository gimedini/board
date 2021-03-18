<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${noticeVO.noticeTitle }</title>
</head>
<body>
  <h2>글 수정</h2>
  <form action="update" method="post">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>글 번호 : ${noticeVO.noticeNo }</p>
      <input type="hidden" name="noticeNo" value="${noticeVO.noticeNo }">
    </div>
    <div>
      <p>
        제목 : <input type="text" name="noticeTitle" value="${noticeVO.noticeTitle }" required>
      </p>
    </div>
    <div>
      <p>작성자 : ${noticeVO.noticeAdmin }</p>
      <p>작성일 : ${noticeVO.noticeDate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="noticeContent" required>${noticeVO.noticeContent }</textarea>
    </div>
    <div>
      <input type="submit" value="제출">
    </div>
  </form>
<script type="text/javascript">
$(".cancel_btn").on("click", function(){
	event.preventDefault();
	location.href = "/notice/detail?noticeNo=${update.noticeNo}"
		   + "&page=${searchCriteria.page}"
		   + "&numsPerPage=${searchCriteria.numsPerPage}"
		   + "&searchType=${searchCriteria.searchType}"
		   + "&keyword=${searchCriteria.keyword}";
})
</script>
</body>
</html>







