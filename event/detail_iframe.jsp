<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* .oriImg {width: 500px; height: auto;} */
.thumbImg {}

.boardView{margin: 0 auto; border-bottom: 1px solid #ccc;}
table{width: 100%; border: 0; border-spacing: 0; border-collapse: collapse;}
.xans-board-read .boardView table{margin: 0 auto; table-layout: fixed; color: #000; line-height: 180%;}
caption{display: none;}
tbody{display: table-row-group; vertical-align: middle; border-color: inherit;}
tr{display: table-row; vertical-align: inherit; border-color: inherit;}
th, td{border: 0; vertical-align: top;}
div{vertical-align: baseline;}

.imagemap{position: relative; width: device-width;}

.right{float: right;}
@media(max-width: 960px) {.right{position: relactive !important}}


#paging {
  padding: 80px 0;
  text-align: center;
}

#paging li {
  display: inline-block;
  margin: 0 0 0- 1px;
  font-size: 12px;
  color: #000;
  vertical-align: top;
  display: inline;
  border: 1px solid #ccc;
  line-height: 36px;
  height: 36px;
}




.thumbnail-wrapper { width: 100%; text-align: center; overflow: hidden; }
.thumbnail{display: inline-block; width: 150px; height: 125px; margin: 2px; overflow: hidden; }
.image{display: inline-block; width: 100%; height: 100px; overflow: hidden; object-fit: cover; }
.text{text-align: left; font-size: 8px; margin: 0; padding: 0; }  




.product-wrap{width:100%;max-width:1400px;margin:0 auto;overflow:hidden;} 
.gallery{margin:50px -20px;box-sizing:border-box;} 
.gallery:after{content:"";display:block;clear:both;visibility: hidden;} 
.gallery ul{text-align: center;}
.gallery li{display: inline-block; width:20%;box-sizing:border-box;padding:0 20px;margin:0 0 50px 0;} 
.gallery li img{width:100%;height:auto;} 

@media (max-width:1200px){ .product-wrap .gallery li{width:25%;} } 

</style>
<meta charset="UTF-8">
<!-- jQuery로 이용하기 위한 태그 추가 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>${boardVO.title }</title>
<!-- 게시글내용 미리 보여주기  -->
</head>
<body>

  <form role="form" autocomplete="off" enctype="multipart/form-data" method="post">
<%--   <div>
    <p>글 번호 : ${boardVO.bno }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${boardVO.title }"
        readonly="readonly">
  </div>
  <div>
    <p>작성자 : ${boardVO.userid }</p>
    <fmt:formatDate value="${boardVO.cdate }"
      pattern="yyyy-mm-dd HH:mm:ss" var="cdate" />
    <!-- String cdate면 그냥 vo.cadte 사용 -->
    <p>작성일 : ${cdate }</p>
  </div>
  <div>
    <textarea rows="20" cols="120" readonly="readonly">${boardVO.content }</textarea>
  </div> --%>

 <div class="xans-board-read">
  <div class="boardView">
    <table border="1" summary>
      <caption>게시판 상세</caption>
        <tbody>
          <tr>
          <td>

     <div class="imagemap" style="width:100%; max-width: 900px; margin:auto;">
    <img src="display?fileName=${boardVO.gdsImg}" class="oriImg" />
     </div>

          </td>
          </tr>
        </tbody>
    </table>
  </div>
 </div>
<c:if test="${not empty loginId }">
  <div class="inputArea">
    <p>썸네일</p>
    <img src="display?fileName=${boardVO.gdsThumbImg}" class="thumbImg" />
  </div>
</c:if>
  <div style="margin-top: 15px;">
    <span class="right">
    <a href="list?page=${page }"><input type="button" value="글 목록"></a>
    </span>
    <!-- 페이지내에서 수정/삭제 > controller
    update는 페이지가 필요하고, delete는 필요없다.
    
    update를 누르면 바로 수정되는게 아니라, 수정페이지로 넘어간다. > controller에서 board-update넣고 GET/POST나눠 넣음
     -->
  </div>
  
  <span style="float: left;">
       <c:if test="${not empty loginId }">
    <a href="update?bno=${boardVO.bno }&page=${page}"><input
      type="button" value="글 수정"></a> <a
      href="delete?bno=${boardVO.bno }"><input type="button"
      value="글 삭제"></a>
  </c:if>
  </span>
  
  </form>
  <!-- detail로 들어가면 list_iframe.html을 불러오는 형식으로 -->
 <script type="text/javascript">
 function sendData() {
  document.frameForm.target = "frameTest";
  document.frameForm.action = "http://localhost:8080/board/event/list_iframe";
  document.frameForm.submit();
 }
</script>

 <iframe name="frameTest" width="100%" height="2700px" 
 src="http://localhost:8080/web/event/list_iframe" frameborder="0" framespacing="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"></iframe>

 

</body>
</html>