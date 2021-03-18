<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#modifyReply{
width: 600px;
height: 130px;
background-color: gray;
padding: 10px;
z-index: 10;
visibility: hidden;
}

.modal{display: none;}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

<title>${boardVO.title }</title>
</head>
<body>
<ul class="main_menu">

   <li class="logo"><a href="${pageContext.request.contextPath }/member/mainPage">GOOTTGIRLS</a></li>
</ul>

  <h2>글 보기</h2>
  <div>
    <p>글 번호 : ${boardVO.bno }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${boardVO.title }"
        readonly="readonly">
    </p>
  </div>
  <div>
    <p>작성자 : ${boardVO.userid }</p>
    <fmt:formatDate value="${boardVO.cdate }" pattern="yyyy-MM-dd HH:mm:ss"
      var="cdate" />
    <p>작성일 : ${cdate }</p>
  </div>
  <div>
    <textarea rows="20" cols="120" readonly="readonly">${boardVO.content }</textarea>
  </div>
  <div>
    <a href="list?page=${searchCriteria.page}&numsPerPage=${searchCriteria.numsPerPage}&searchType=${searchCriteria.searchType}&keyword=${searchCriteria.keyword}">
    <input type="button" value="글 목록"></a>
    <c:if test="${not empty loginId }">
    <a href="update?bno=${boardVO.bno }&page=${searchCriteria.page}&numsPerPage=${searchCriteria.numsPerPage}&searchType=${searchCriteria.searchType}&keyword=${searchCriteria.keyword}">
    <input type="button" value="글 수정"></a> 
    <a href="delete?bno=${boardVO.bno }"><input type="button" value="글 삭제"></a>
     </c:if>
  </div>
  
  <form name="readForm" role="form" method="post">
  <input type="hidden" id="bno" name="bno" value="${boardVO.bno}" />
  <input type="hidden" id="page" name="page" value="${searchCriteria.page}"> 
  <input type="hidden" id="numsPerPage" name="numsPerPage" value="${searchCriteria.numsPerPage}"> 
  <input type="hidden" id="searchType" name="searchType" value="${searchCriteria.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${searchCriteria.keyword}"> 
</form>
  
  
  <c:if test="${not empty loginId }">
    <div style="text-align: center;">
    <div>
      <input type="hidden" id="replyBno" value="1"> 
      <input type="text" id="newreplyId" placeholder="아이디 입력"> 
      <input type="text" id="newreplyContent" placeholder="댓글 입력">
      <button type="button" id="btn_add">작성</button>
    </div>
  </div>
  </c:if>

<div class="card-footer"> <ul id="replies"> </ul> </div>
<div class="modal fade" id="modifyModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <hr>
       
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" onClick="close_pop();">&times;</button>
   
        <h4 class="modal-title">댓글 수정창</h4>
        
      </div>

      <div class="modal-body">
        <div class="form-group">
          <label for="replyNo">댓글 번호</label>
          <input class="form-control" id="replyNo" name="replyNo" readonly="readonly">
        </div>
        <div class="form-group">
          <label for="replyContent">댓글 내용</label>
          <input class="form-control" id="replyContent" name="replyContent" placeholder="댓글 내용을 입력해주세요">
        </div>
        <div class="form-group">
          <label for="replyId">댓글 작성자</label>
          <input class="form-control" id="replyId" name="replyId" readonly="readonly">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="close_pop();">닫기</button>
        <button type="button" class="btn btn-xs btn-success modalModBtn">수정</button>
        <button type="button" class="btn btn-danger modalDelBtn">삭제</button>

      </div>
    </div>
  </div>
</div>


  <script type="text/javascript">
 
  // modal X/닫기 버튼
  function close_pop(flag) {
      $('#modifyModal').hide();
 };
  
      // 댓글 입력
      $(document).ready(function() {
                var replyBno = "${boardVO.bno } "; //${boardVO.bno } 
                  // $('#replyBno').val(); // 게시판 번호 값
                getAllReplies(); // 메소드 호출
                // 댓글 입력 기능
                $('#btn_add').click(
                  function() {
                  var replyContent = $('#newreplyContent').val(); // 댓글 내용
                  var replyId = $('#newreplyId').val(); // 댓글 아이디
                  var obj = {
                    'replyBno' : replyBno,
                    'replyContent' : replyContent,
                    'replyId' : replyId};
                  console.log(obj);

                // $.ajax로 송신
                $.ajax({
                  type : 'post',
                  url : 'detail',
                  headers : {
                  'Content-Type' : 'application/json',
                  'X-HTTP-Method-Override' : 'POST'},
                  data : JSON.stringify(obj),
                  success : function(result, status) {
                  console.log(result);
                  console.log(status);
                  if (result == 1) {
                	  alert('댓글 입력 성공');
                      getAllReplies();
                  $('#replyContent').val('');
                  $('#replyId').val(''); }
                } // end success
              }); // end ajax()
            }); // end btn_add()

                // 게시판의 댓글 전체 가져오기
                function getAllReplies() {
                  var url = 'detail/all/' + replyBno;
                  $.getJSON(url, 
                		  function(jsonData) {
                  console.log(jsonData);
                  var list = ''; // JSON 데이터를 표현할 변수
                $(jsonData).each(function() { // jsonData를 사용하는 each 반복문
                var replyDate = new Date(this.replyDate);
                var date = moment(replyDate).format("YYYY-MM-DD");
                var writer = $('#replyId').val();
                // this : jsonData
                console.log(this.replyId);
                var disabled = '';
                if (writer == this.replyId) {
                  disabled = ''; }
               list += "<li data-replyNo='" + this.replyNo + "' class='reply_item rowData'>" 
                   + "<p class='replyContent'>" + this.replyContent + "</p>" 
                   + "<p class='replyId'>" + this.replyId + "</p>" 
                   + date
                   + "<br>" + "<c:if test="${not empty loginId }">"
                   + "<button type='button' class='btn btn-xs btn-success' data-toggle='modal' data-target='#modifyModal'>댓글 수정</button>" 
                   + "</c:if>"
                   + "</li>" 
                   + "<hr>";  
                  }); // end each()
                    $('#replies').html(list);
                  } // end callback()
              ); // end getJSON()
            } // end getAllReplies()

            
            
$("#replies").on("click", ".reply_item button", function () { 
   $("#modifyModal").show(); // 모달창 띄우기

  var reply = $(this).parent(); 
  var replyNo = reply.attr("data-replyNo"); 
  var replyContent = reply.find(".replyContent").text(); 
  var replyId = reply.find(".replyId").text();  

$("#replyNo").val(replyNo); 
$("#replyContent").val(replyContent); 
$("#replyId").val(replyId); 

   var div = $('#modifyModal');
    div.css("position", "absolute");
    div.css("top", Math.max(0, (($(window).height() - div.outerHeight()) / 2) + $(window).scrollTop()) + "px");
    div.css("left", Math.max(0, (($(window).width() - div.outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    $('#modifyModal').fadeIn(500);

    var modelModBtn = $('#modalModBtn');
    var modelRemoveBtn = $('#modalRemoveBtn');
  
  });


                
// 수정 버튼을 클릭하면 선택된 댓글 수정 // 여기 코드 제꺼 보시고 다시 공부하세요. 코드 잘못됨

$(".modalModBtn").on('click', function() {
console.log(this);


 //댓글 선택자 
var reply = $(this).parent().parent(); 
// 댓글번호 
var replyNo = reply.find("#replyNo").val(); 
// 수정할 댓글내용 
var replyContent = reply.find("#replyContent").val();  

var replyId = reply.find("#replyId").val();


console.log("선택된 댓글 번호 : "+ replyNo + ", 댓글 내용 : " + replyContent);


  // ajax 요청
  $.ajax({
  type : 'put',
  url : 'detail/' + replyNo,
  headers : {
        'Content-Type' : 'application/json',
        'X-HTTP-Method-Override' : 'PUT' },
  data : JSON.stringify({
       'replyNo' : replyNo,
      'replyContent' : replyContent }),
  dataTpye : "text",    
  success : function(result) {
    console.log(this);
    console.log("result : " + result);
      if (result == 'success') {
        alert('댓글 수정성공');
        $("#modifyModal").hide();// Modal 닫기
        getAllReplies(); 
        } 
    } // end success
  }); // end ajax()
  }); // end btn_update() 


  // 삭제 버튼을 클릭하면 선택된 댓글 삭제 // 여기도 마찬가지. 그냥 버튼 객체를 갖고오게 되면 선택된거뿐만 아니라 모든 정보를 가지고 오기 때문에 공부 좀 더 하시고 사용하세요! bye
$(".modalDelBtn").on('click', function() { 
console.log(this);

    // 선택된 댓글 replyNo
    // var replyNo = $(this).prevAll('#replyBno').val();
     var replyNo = $(this).parent().parent().find("#replyNo").val();

  console.log("선택된 댓글 번호 : " + replyNo);

    // ajax 요청
    $.ajax({
    type : 'delete',
    url : 'detail/' + replyNo,
    headers : {
        'Content-Type' : 'application/json',
        'X-HTTP-Method-Override' : 'DELETE' },
    data : JSON.stringify({'replyBno' : replyBno}),
  //  dataType : "text",
    success : function(result) {
      console.log("result : " + result);

        if (result == 'success') {
          alert('댓글 삭제성공');
          $("#modifyModal").hide(); // Modal 닫기
          getAllReplies(); // 댓글 목록 갱신 
          }
    } // end success
        }); // end ajax()
            }); // end btn_update()
    }); // end ready()
    </script>
</body>
</html>










