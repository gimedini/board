<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@charset "utf-8";

* {
   margin : 0 auto;
   padding : 0;
   list-style : none;
   font-family : "맑은 고딕";
   color : #333333;
}

body {
   width : 1500px;
   background-color : #ffffff;
}

a {
   text-decoration : none;
   display : block;
}

header {
   height : 100px;
   width : 1500px;
}

.top {
   height : 100px;
   width : 1500px;
}

.productmenu {
   float : left;
   margin-top : 30px;
   margin-left : 130px;
}

.productmenu>li {
   float : left;
}

.productmenu>li>a {
   height : 40px;
   width : 150px;
   line-height : 30px;
   font-size : 10px;
   text-align : center;
   background-color : white;
   color : black;
}

.productmenu>li>a:hover {
   text-decoration : underline;
}

.submenu {
   width : 150px;
   position : absolute;
   display : none;
   z-index : 1;
}

.submenu>li>a {
   height : 35px;
   line-height : 35px;
   font-size : 10px;
   text-align : center;
   background-color : #fbceb1;
   color : black;
}

.submenu>li>a:hover {
   text-decoration : underline;
}

.bodywrap {
   width : 1500px;
   height : 1300px;
}

h3 {
   text-align : center;
   margin-bottom : 50px;
}

.qna_type {
   float : left;
   height : 20px;
   margin-left : 400px;
}

.qna_type>li {
   float : left;
   font-size : 12px;
}

.notice {
   width : 1000px;
   margin-top : 100px;
   background-color : #EEEEEE;
   text-align : center;
   font-size : 13px;
   padding : 15px;
}

.notice > p {
   padding : 3px;
}

.title {
   width : 150px;
   height : 20px;
   background-color : #D99F9D;
   font-size : 15px;
   font-weight : bold;
   color : white;
   border-radius : 10%;
}

table {
   margin-top : 30px;
   width : 1000px;
   font-size : 12px;
   text-align : center;
   border-bottom : 1px solid #EEEEEE;
}

td {
   border-top : 1px solid #EEEEEE;
   padding : 5px;
}

.search {
   margin-top : 20px;
   margin-left : 250px;
   
}
.search > ul {
   float : left;
}

.search > ul > li {
   float : left;
   padding : 3px;
}

.search > ul > li > select {
   border:1px solid lightgrey;
   font-size : 13px;
   width : 70px;
   height : 25px;
}

.search > ul > li > input {
   border:1px solid lightgrey;
   font-size : 13px;
   height : 25px;
}

.event_img {
   float : left;
   margin-top : 200px;
   margin-left : 200px;
}

.event_img > li {
   float : left;
   margin-left : 15px;
}

.event_img > li > a > img {
   width : 350px;
   height : 200px;
}

.information {
   float : left;
   margin-top : 130px;
   margin-left : 300px;
}

.information > li {
   float : left;
   margin-left : 70px;
   font-size : 12px;
}

.bold {
   font-size : 13px;
   font-weight : bold;
   margin-bottom : 13px;
}

.information_menu > li {
   margin-top : 5px;
}

footer {
   height : 300px;
   width : 1500px;
}

.sns {
   float : left;
   margin-top : 50px;
   margin-left : 600px;
}

.sns > li {
   float : left;
   margin-left : 30px;
}

.guitar {
   font-size : 12px;
   float : left;
   text-align : center;
   margin-top : 30px;
   margin-left : 300px;
}

.guitar > p {
   margin-top : 5px;
}

.guitar > .margin {
   margin-top : 20px;
   margin-bottom : 70px;
}

.paging_number {
   margin-top : 100px;
   margin-left : 700px;
   position : relative;
}

.paging_number > a {
   float : left;
   width : 30px;
   height : 30px;
}

.paging_number > a > img {
   width : 30px;
   height : 30px;
   background-color : white;
   border : 1px solid lightgrey;
}

.paging_number > ul > li {
   float : left;
   width : 30px;
   height : 30px;
   border : 1px solid lightgrey;
   text-align : center;
font-weight : bold;
}

* {
box-sizing: border-box;
}

.btn-mini{
border : none;
margin: 5px auto;
padding: 5px 0;
text-align: center;
}

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

<ul class="main_menu">

   <li class="logo"><a href="${pageContext.request.contextPath }/member/mainPage">GOOTTGIRLS</a></li>
</ul>

<header>
   <div class="top">
      <ul class="productmenu">
      <li><a href="#">BEST</a></li>
      <li><a href="#">OUTER</a>
         <ul class="submenu">
            <li><a href="#">코트</a></li>
            <li><a href="#">자켓/점퍼</a></li>
            <li><a href="#">무스탕</a></li>
            <li><a href="#">가디건</a></li>
         </ul>
      </li>
      <li><a href="#">KNIT</a>
         <ul class="submenu">
            <li><a href="#">가디건</a></li>
            <li><a href="#">니트</a></li>
            <li><a href="#">베스트</a></li>
         </ul>
      </li>
      <li><a href="#">TOP</a>
         <ul class="submenu">
            <li><a href="#">티셔츠</a></li>
            <li><a href="#">맨투맨/후드</a></li>
            <li><a href="#">셔츠/블라우스</a></li>
         </ul>
      </li>
      <li><a href="#">PANTS</a>
         <ul class="submenu">
            <li><a href="#">면팬츠</a></li>
            <li><a href="#">데님</a></li>
            <li><a href="#">슬랙스</a></li>
         </ul>
      </li>
      <li><a href="#">SKIRTS</a>
         <ul class="submenu">
            <li><a href="#">미니</a></li>
            <li><a href="#">미디/롱</a></li>
         </ul>
      </li>
      <li><a href="#">DRESS</a></li>
      <li><a href="#">ACC</a></li>
      </ul>
   </div>
</header>

  <form role="form" autocomplete="off"  method="post">
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
<%--  <script type="text/javascript">
 function sendData() {
  document.frameForm.target = "frameTest";
  document.frameForm.action = "http://localhost:8080/board/event/list_iframe?bno=${boardVO.bno }";
  document.frameForm.submit();
 }
</script>--%>

 <iframe width="100%" height="2700px" 
 src="${pageContext.request.contextPath }/event/list_iframe" 
 frameborder="0" framespacing="0" marginheight="0" marginwidth="0" 
 scrolling="no" vspace="0"></iframe> 






</body>
</html>