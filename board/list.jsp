<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


#paging {
padding: 40px 0;
text-align: center;
}


#paging li a{
display: block;
width: 33px;
font-weight: bold;
color: #000;
line-height: 35px;
}

#paging li{
  display: inline-block;
  margin : 0 -4px 0 -5px;
  vertical-align: top;
}

a {
list-style: none;
}

a{
text-decoration: none;
color: #000;
}

* {
margin : 0 auto;
padding : 0 auto;
box-sizing: border-box;
}
ul {
  list-style-type: none;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<meta charset="UTF-8">
<title>Q&A</title>
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
   <h3>Q & A</h3>
   <ul class="qna_type">
      <li><a href="qna.html">ALL &nbsp;|&nbsp;&nbsp; </a></li>
      <li><a href="#"> 상품문의 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 주문/결제 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 배송문의 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 해외배송 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 취소/변경 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 교환/반품 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 매장관련 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 입고지연 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> 기타문의 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> VIP전용 &nbsp;|&nbsp;&nbsp;</a></li>
      <li><a href="#"> FAQ</a></li>
   </ul>
   
   <div class="notice">
      <p class="title">안내 및 유의사항</p> <br/>
      <p>* 주문 이후 배송 전 /후 상품 추가 및 타 상품 교환은 불가합니다.</p> 
      <p>* 상품 추가, 변경(교환)을 원하신다면 취소 /반품 후 신규주문 부탁드립니다.</p> 
      <p>* 부분 취소 불가 결제 건(휴대폰 /기프트카드결제) 이용 결제수단은 전체취소 후 신규 주문 부탁드립니다.</p> 
      <p>* 결제 취소 시에는 결제하신 수단으로만 취소 가능하며, 개인결제 이용 결제방식은 불가능합니다.</p>
      <p>* 최초 카드결제 이후 할부 개월수 변경, 결제카드 변경, 결제수단 변경은 불가합니다.</p>
      <p>* 취소된 금액을 타 주문건에 금액대체는 불가합니다.</p> <br/>
      <p>* 기본배송기간 : 5일~10일</p> <br/>
      <p>※ 최근 코로나19 확산으로 인해, 택배 물량 급증으로 출고 이후 수량까지 +3일정도 추가 소요되고 있습니다.<br/>
         택배 배송지연으로 불편드려 죄송합니다. 고객님의 깊은 양해 부탁드립니다.</p>
   </div>


 

  <table>
    <thead>
      <tr>
        <th style="width: 60px;">No</th>
        <td>Category</td> 
        <th style="width: 700px;">Subject</th>
        <th style="width: 60px;">Writer</th>
        <th style="width: 100px;">Date</th>
      </tr>
    </thead>
    <tbody> 
      <c:forEach var="vo" items="${boardList }">
        <tr>
          <td>${vo.bno }</td>
          <td>${vo.cateCode }</td>
          <td>
          <a href="detail?bno=${vo.bno }
          &page=${searchCriteria.page}
          &numsPerPage=${searchCriteria.numsPerPage}
          &searchType=${searchCriteria.searchType}
          &keyword=${searchCriteria.keyword}">
          ${vo.title }       
           <span>[${vo.replyCount }]</span>
          </a>
          </td>
          <td>${vo.userid }</td>
          <fmt:formatDate value="${vo.cdate }"
            pattern="yyyy-MM-dd HH:mm:ss"
            var="cdate"/>
          <td>${cdate }</td>
           <td>${bgno }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  

  
  
  <hr>
<div id="paging">


    <c:if test="${pageMaker.hasPrev }">
      <li><a href="list${pageMaker.makeSearch(pageMaker.startPageNo - 1)}">
       <img alt="이전" src="${pageContext.request.contextPath }/resources/images/btn_page_prev.gif"></a></li>
    </c:if>
  
  
    <c:forEach begin="${pageMaker.startPageNo }" 
      end="${pageMaker.endPageNo }" var="num">
<li><a href="list${pageMaker.makeSearch(num) }">${num }</a></li>
    </c:forEach>
  
  

    <c:if test="${pageMaker.hasNext }">
      <li><a href="list${pageMaker.makeSearch(pageMaker.endPageNo + 1)}">
      <img alt="다음" src="${pageContext.request.contextPath }/resources/images/btn_page_next.gif"></a></li>
    </c:if>


  </div>
  
      <form id="pagingForm" style="display: none;">
      <input type="text" name="page">
    </form>
  
  <input id="insertAlert" type="hidden" value="${insert_result}">
  
  <script type="text/javascript">
    $(document).ready(function(){
      $('.pager li a').click(function(){
        // pager 클래스의 하위 li 요소의 a 요소를 찾아감
        event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
        var targetPage = $(this).attr('href'); // a 태그 href 속성의 값을 저장
        console.log(targetPage);
        
        var frm = $('#pagingForm'); // form의 정보를 frm에 저장
        frm.find('[name="page"]').val(targetPage);
        // name="page"인 요소를 찾아서 value값을 저장
        frm.attr('action', 'list'); // form에 action 속성-값 추가
        frm.attr('method', 'get'); // form에 method 속성 추가
        frm.submit(); // form 데이터 전송
      }); // end click()
      
      confirmInsertResult();
      function confirmInsertResult() {
        var result = $('#insertAlert').val();
        if (result === 'success') {
          alert('새 글 작성 성공');
        } else if(result === 'fail'){
          alert('새 글 작성 실패')
        }
      }
    }); // end document
  </script>
  
    <div class="search" >
<ul>
  <li>

    <select name="searchType" >
      <option value="n"<c:out value="${searchCriteria.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${searchCriteria.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${searchCriteria.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${searchCriteria.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
    </select>
   </li>
   <li>
    <input type="text" name="keyword" id="keywordInput" style="width:150px" value="${searchCriteria.keyword}"/>
   </li>
   <li>
    <!-- <button id="searchBtn" type="button">검색</button> -->
    <input type="button" id="searchBtn" value="검색" style="width:70px; background-color:white">
   
    <script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
</li>
  
         <li>
            <a href="register"><input type="button" name="write_button" value="글쓰기" style="margin-left:550px; width:70px; background-color:#D99F9D; color:white; border:1px solid #D99F9D">
         </li>
</ul>
  </div>
  
   

     
          


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
























