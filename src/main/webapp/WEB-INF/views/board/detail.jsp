<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

<link rel="stylesheet" href="../../../resources/dist/css/register.css" />

<jsp:include page="../layout/header.jsp"></jsp:include>

<c:set value = "${bdto.bvo }" var="bvo"></c:set>
<c:set value = "${bdto.fvoList }" var="fvoList"></c:set>

<div class="board-container">
	<!-- 제목 -->
	<div class="post-detail">
	 <div class="post-header">
		 <h1 class="post-title">${bvo.title }</h1>
		 
		 <div class="post-meta">
		   <span class="author">${bvo.writer }</span>
		   <span class="date">${bvo.regDate }</span>
		   <span class="views">${bvo.views }</span>
		 </div>
	</div>
	
	<!-- 내용 -->
  <div class="post-content">${bvo.content }</div>
 
  
	<!-- 버튼 -->
	<div
		id="btnConDiv" 
		class="form-actions"
	>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.uvo.nickName" var="authNick"/>		
		
			<c:if test="${bvo.writer eq authNick }">
				<a href="/board/modify?bno=${bvo.bno }">
					<button type="button" class="btn btn-primary">수정</button>		
				</a>
				
				<a href="/board/delete?bno=${bvo.bno }">
					<button type="button" class="btn btn-primary">삭제</button>		
				</a>			
			</c:if>
		</sec:authorize>
		
		<button type="button" class="btn btn-secondary" onclick="history.back()">
			뒤로 가기
		</button>
		   
		<a href="/board/detail?bno=${prev }">
			<button type="button" class="btn btn-outline-secondary">이전글</button>
		</a>
		
		<a href="/board/detail?bno=${next }">
			<button type="button" class="btn btn-outline-secondary">다음글</button>
		</a>	
	</div>
  
     
	<!-- 댓글창 -->
	<!-- 댓글 작성창 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.uvo.nickName" var="authNick"/>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
			
			<div class="input-group mb-3">
				<span class="input-group-text" id="cmtWriter">${authNick }</span>
				<input type="text" id="cmtText" class="form-control" placeholder="Add Comment..." aria-label="Username" aria-describedby="basic-addon1">
				<button type="button" id="cmtAddBtn" class="btn btn-secondary">댓글 작성</button>
			</div>
			<br>
		
		<script type="text/javascript">
			const authNick = `<c:out value="${authNick}" />`;
		</script>
	</sec:authorize>


	<!-- 댓글 프린트 -->
	<ul class="list-group list-group-flush" id="cmtListArea">
		<!-- 		<li class="list-group-item">
		<div class="mb-3">
			<div class="fw-bold">writer</div>
			content
		</div>
		<span class="badge text-bg-primary">regDate</span>
		</li> -->
	</ul>
	
	
	<%-- 댓글 더보기 버튼 
		 > 한 페이지에 5개 댓글을 표시 
			 
		 > 5개를 초과하는 경우 더보기 버튼을 활성화 5개 이하이면 더보기 버튼 비활성화
			 
		 > 더보기 버튼을 누르면 5개씩 댓글을 가져옴 
			 
		 > select * from comment where bno = #{bno} order by cno desc limit #{pageStart}, #{qty}
	--%>
	<div class="mb-3">
		<button 
			type="button" 
			id="moreBtn"
			class="btn btn-outline-info" 
			data-page="1"
			style="visibility : hidden;">
			더보기
		</button>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	      <!-- title - cno 와 작성자 -->
	      <h1 class="modal-title fs-5" id="exampleModalLabel"></h1>
	      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	    </div>
	    <div class="modal-body">
	      <input type="text" id ="cmtTextMod" class = "form-control">
	    </div>
	    <!-- 모달창 -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" id="cmtModBtn" class="btn btn-primary">변경</button>
	      </div>
	    </div>
	  </div>
	</div>


	<!-- 업로드된 파일 프린트 -->
	<div class="mb-3">
		<ul class="list-group list-group-flush">
			<!-- 파일 개수만큼 li 반복, 반복 타입이 1이면 그림을 표시 아니면 그냥 파일 모양으로 표시 -->
	<c:forEach items="${bdto.fvoList }" var="fvo">
		<li class="list-group-item">
			<c:choose>
				<c:when test="${fvo.fileType > 0 }">
					<div>
						<!-- 최대크기 지정 (500 * 500) 및 비율 유지 (width : auto; height : auto) -->
						<img 
							src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}"
							style="max-width : 500px; max-height : 500px; width : auto; height : auto"
							>
					</div>
				
				</c:when>
			
				<c:otherwise>
					<!-- 일반 파일은 다운로드 가능하게 끔 -->
					<a 
						download="${fvo.fileName }"
						href="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}"
					>
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-file-arrow-down-fill" viewBox="0 0 16 16">
						  <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2M8 5a.5.5 0 0 1 .5.5v3.793l1.146-1.147a.5.5 0 0 1 .708.708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 1 1 .708-.708L7.5 9.293V5.5A.5.5 0 0 1 8 5"/>
						</svg>
					</a>
				</c:otherwise>
			</c:choose>
			
			<!-- 파일 이름 -->
			<div class="mb-3">
				<div class="fw-bold">${fvo.fileName }</div>
			</div>
			
			<span class="badge text-bg-primary">${fvo.regDate } / ${fvo.fileSize } Bytes</span>
		</li> 
	</c:forEach>
		</ul>
	</div>
	
	</div>
</div>
	
	<script type="text/javascript">
		const bnoValue = `<c:out value="${bvo.bno}" />`;

		console.log(bnoValue);
	</script>
	<script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
	
	<!-- detail.jsp 열면 댓글 출력 -->
	<script type="text/javascript">
		spreadCommentList(bnoValue);
	</script>
<jsp:include page="../layout/footer.jsp"></jsp:include>