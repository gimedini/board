<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

.select_img img {margin: 20px 0; }

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
   height : 1000px;
}

h3 {
   text-align : center;
   margin-bottom : 50px;
}

table {
   width : 1000px;
   margin-top : 50px;
   border-top : 1px solid lightgrey;
   font-size : 12px;
}

td {
   border-bottom : 1px solid lightgrey;
   padding : 15px;
}

.button > input {
   width : 70px;
   height : 25px;
   border : none;
   background-color : lightgrey;
   color : white;
   margin-top : 30px;
   margin-left : 250px;
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
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${noticeVO.noticeTitle }</title>
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

<div class="bodywrap">
   <h3>회 원 공 지</h3>
   <div class="list_detail">
      <table>
      <tr>
         <td scope="row" style="width : 100px; border-right : 1px solid lightgrey">제목</td>
         <td>${noticeVO.noticeTitle }</td>
      </tr>
      <tr>
         <td scope="row" style="width : 100px; border-right : 1px solid lightgrey">작성자</td>
         <td>${noticeVO.noticeAdmin }</td>
      </tr>
      <tr>
         <td scope="row" style="width : 100px; border-right : 1px solid lightgrey">작성일</td>
         <td><fmt:formatDate value="${noticeVO.noticeDate }" pattern="yyyy-MM-dd HH:mm:ss"
      var="noticeDate" />${noticeDate }</td>
      </tr>
      <tr>
         <td scope="row" style="width : 100px; border-right : 1px solid lightgrey">조회수</td>
         <td>${noticeVO.noticeRead }</td>
      </tr>
      <tr>
         <td colspan="2">
            <div class="view">
            ${noticeVO.noticeContent }
            </div>
         </td>
      </tr>
      </table>
   </div>
   <a class="button" href="list?page=${searchCriteria.page}&numsPerPage=${searchCriteria.numsPerPage}&searchType=${searchCriteria.searchType}&keyword=${searchCriteria.keyword}">
   <input type="button" name="list" value="목록"></a>

<c:if test="${not empty loginId }">
   <a href="update?noticeNo=${noticeVO.noticeNo }&page=${searchCriteria.page}&numsPerPage=${searchCriteria.numsPerPage}&searchType=${searchCriteria.searchType}&keyword=${searchCriteria.keyword}">
   <input type="button" name="list" value="글 수정"></a>
<a href="delete?noticeNo=${noticeVO.noticeNo }">
<input type="button" name="list" value="글 삭제"></a>
 </c:if>

  <form name="readForm" role="form" method="post">
  <input type="hidden" id="noticeNo" name="noticeNo" value="${noticeVO.noticeNo}" />
  <input type="hidden" id="page" name="page" value="${searchCriteria.page}"> 
  <input type="hidden" id="numsPerPage" name="numsPerPage" value="${searchCriteria.numsPerPage}"> 
  <input type="hidden" id="searchType" name="searchType" value="${searchCriteria.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${searchCriteria.keyword}"> 
</form>


<script type="text/javascript">
jQuery(document).ready(function() {
	   $('.productmenu>li').mouseover(function(){        
	     $(this).find('.submenu').stop().slideDown(500);
	  }).mouseout(function(){
	     $(this).find('.submenu').stop().slideUp(500);
	  });
	});
</script>


   <div class="event">
      <ul class="event_img">
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/main_bt01.jpg"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/main_bt02.jpg"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/main_bt03.jpg"></a></li>
      </ul>
   </div>

   <div>
      <ul class="information">
         <li><div class="bold">CUSTOMER</div>
            <ul class="information_menu">
            <li>0502 707 8888</li>
            <li>평일 10:00 - 17:00</li>
            <li>점심 12:00 - 13:00</li>
            <li>휴무 (토, 일, 공휴일)</li>
            </ul>
         </li>
         <li><div class="bold">DELIVERY</div>
            <ul class="information_menu">
            <li><a href="#">배송조회 >></a></li>
            <li>반품주소</li>
            <li>경기도 이천시 대월면</li>
            <li>대월로 932번길 94 A동</li>
            <li>로젠택배 3PL 물류센터</li>
            <li>반드시 로젠택배 이용</li>
            </ul>
         </li>
         <li><div class="bold">STORE</div>
            <ul class="information_menu">
            <li><a href="#">플래그십</a></li>
            <li><a href="#">백화점</a></li>
            <li><a href="#">면세점</a></li>
            <li><a href="#">올리브영</a></li>
            <li><a href="#">아울렛</a></li>
            <li><a href="#">해외</a></li>
            </ul>
         </li>
         <li><div class="bold">HELP</div>
            <ul class="information_menu">
            <li><a href="http://localhost:8080/web/board/list">Q&A / FAQ</a></li>
            <li><a href="#">쇼핑가이드</a></li>
            <li><a href="#">개인정보처리방침</a></li>
            <li><a href="#">이용약관</a></li>
            <li><a href="#">제휴문의</a></li>
            </ul>
         </li>
         <li><div class="bold">NOTICE</div>
            <ul class="information_menu">
            <li><a href="#">회사소개</a><li>
            <li><a href="#">회사공고</a></li>
            <li><a href="#">해외배송</a></li>
            <li><a href="http://localhost:8080/web/notice/list">회원공지</a></li>
            <li><a href="http://localhost:8080/web/event/list">이벤트</a></li>
            </ul>
         </li>
      </ul>
   </div>

<footer>
   <div>
      <ul class="sns">
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico01__.png"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico02__.png"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico03__.png"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico04__.png"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico05__.png"></a></li>
         <li><a href="#"><img src="${pageContext.request.contextPath }/resources/images/footer_ico06__.png"></a></li>
      </ul>
   </div>
   <div class="guitar">
      <p> 대표이사.신지은 | 사업자등록번호. 130-86-24632 | 통신판매업신고. 2014-서울마포-0835 | 개인정보보호책임자. 조선영[사업자정보확인] </p>
      <p> 회사명.(주)난다 | 전화.0502-707-8888 | 팩스.02-335-5274 | 이메일.goott@girls.co.kr | 주소.서울특별시 마포구 잔다리로 32 서문빌딩 2-6F </p>
      <p> ⓒ 2017. NANDA All rights reserved. | 개인정보처리방침 | 영상정보처리기기운영 관리방침 | 이용약관 | Hosting by cafe24 </p>
      <p class="margin">고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 PG 사의 구매안전서비스를 이용하실 수 있스빈다. 토스페이먼츠 에스크로(서비스가입사실확인)</p>
   </div>
</footer>


</body>
</html>










