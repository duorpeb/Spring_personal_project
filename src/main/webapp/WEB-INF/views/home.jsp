<%-- sample.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3></h3>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>

 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>

<jsp:include page="./layout/header.jsp"></jsp:include>
<link rel="stylesheet" href="/resources/dist/css/home.css">
  <!-- News & Weather API -->
  <div id="apiSection">
    <div class="news">
      <!-- 여기에 뉴스 API 결과물 반복 -->
      <p>뉴스1</p>
      <p>뉴스2</p>
    </div>
    <div class="weather">
      <!-- 여기에 날씨 API 위젯 삽입 -->
      <p>맑음 26.1℃</p>
    </div>
  </div>

  <!-- Category Navigation -->
  <nav id="categoryNav">
    <ul>
      <li><a href="/board/list?category=news">뉴스</a></li>
      <li><a href="/board/list?categegory=sports">스포츠</a></li>
      <li><a href="/board/list?categegory=currentEvent">시사</a></li>
      <li><a href="/board/list?categegory=it">IT</a></li>
      <li><a href="/board/list?categegory=entertainment">연예</a></li>
      <li><a href="/board/list?categegory=fashion">패션</a></li>
      <li><a href="/board/list?categegory=economy">경제</a></li>
      <li><a id="boardReg" href="/board/register">게시물 작성</a></li>
    </ul>
  </nav>

  <!-- 게시글 출력 영역, SNS 스크롤 방식 게시글 -->
  <div id="boardContainer">
    <!-- Container Div -->
    <div id="boardDiv">
    	<c:forEach items="${list }" var="bdto">
    		<c:set value = "${bdto.bvo.bno }" var="bno" />
    		<!-- 하나의 게시글  -->
    		<div class="post">
    			<!-- 포스트 헤더 -->
    			<div class="post-header">
    				<!-- 프로필 이미지  -->
    				<div class="avatar">
    					<img 
    						src="/spring_myproject_up/profileImg/${bdto.bdFileName }"
    						style="width : 60px; height : 60px;">
    				</div>
    			
	    			<!-- User 정보 -->
	    			<div class="user-info">
		    			<div class="username">${bdto.bvo.writer }</div>    			
	    			</div>
    			
	    			<!-- 작성일 -->
	    			<div class="meta">${bdto.bvo.regDate }</div>
    			</div>
    			
    			<!-- 제목 -->
    			<div class="title"><a href="/board/detail?bno=${bno }">${bdto.bvo.title }</a></div>
    			
    			<!-- 내용 -->
    			<div class="content ellipsis--line2">${bdto.bvo.content }</div>
    			
    			<!-- 좋아요 및 게시글 개수 -->
    			<div class="actions">
    				<div class="like">좋아요 ${bdto.bvo.recommend }</div>
    				<div class="comment">댓글 ${bdto.bvo.cmtCnt }</div>
    			</div>
    		</div>
    		
    	</c:forEach>
    </div>

    <!-- 추천 많은 순 / 댓글 많은 순 -->
    <div id="recommAndCmtDiv">
      <div id="recommandBoard">
        <h3><a href="/board/orderRec">추천 많은 순</a></h3>
        <ol>
          <li>게시글 제목 1</li>
          <li>게시글 제목 2</li>
          <li>게시글 제목 3</li>
          <li>게시글 제목 4</li>
          <li>게시글 제목 5</li>
        </ol>
      </div>
      
      <div id="cmtBoard">
        <h3><a href="/board/orderCmt">댓글 많은 순</a></h3>
        <ol>
          <li>게시글 제목 A</li>
          <li>게시글 제목 B</li>
          <li>게시글 제목 C</li>
          <li>게시글 제목 D</li>
          <li>게시글 제목 E</li>
        </ol>
      </div>
      
      <div id="rctBoard">
       	<h3><a href="/board/orderViews">조회수 많은 순</a></h3>      	
      	
        <ol>
          <li>게시글 제목 A</li>
          <li>게시글 제목 B</li>
          <li>게시글 제목 C</li>
          <li>게시글 제목 D</li>
          <li>게시글 제목 E</li>
        </ol>
      </div>
      
      <div id="newBoard">	
        <h3><a href="/board/orderNew">최신 작성 순</a></h3>    	
      	
        <ol>
          <li>게시글 제목 A</li>
          <li>게시글 제목 B</li>
          <li>게시글 제목 C</li>
          <li>게시글 제목 D</li>
          <li>게시글 제목 E</li>
        </ol>
      </div>
    </div>
		    
  </div>
<script>
	const delMsg = `<c:out value="${delMsg}" />`;
	console.log(delMsg);
	
	if(delMsg == "ok"){ alert('회원 탈퇴가 성공적으로 완료되었습니다.'); }	
</script>

<script type="text/javascript" src="/resources/js/home.js"></script>

<jsp:include page="./layout/footer.jsp"></jsp:include>


