console.log("boardDetailComment.js in");
console.log(bnoValue);
console.log(authNick);

const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');


document.getElementById('cmtAddBtn').addEventListener('click',() => {
    const cmtText = document.getElementById('cmtText'); // input
    const cmtWriter = document.getElementById('cmtWriter'); // span

    if(cmtText.value == ''){
        alert('댓글을 입력해주세요');
        cmtText.focus();
        return;
    }

    // 객체 생성
    let cmtData = {
        bno: bnoValue,
        writer : cmtWriter.innerText,
        content : cmtText.value
    }
    // 확인
    console.log(cmtData);
    
    // Server (Controller) 로 댓글 전송 
    postCommentToServer(cmtData).then(result =>{
        // 댓글이 성공적으로 등록된 경우
        if(result == '1'){
            alert("댓글 등록 성공");
            cmtText.value="";
            // 댓글 출력
            spreadCommentList(cmtData.bno);
        }
    })
})

document.addEventListener('click',(e) => {
    /* if(e.target.id === moreBtn){
        ...
        let page = parseInt(e.target.dataset.page);
        ...
    }
    
      > 커스텀 데이터 속성 (Custom Data Attribute)
			
	    # "data-변수명" 은 HTML5부터 사용할 수 있는 커스텀 데이터 속성으로 변수명의 이름은 사용자 임의로
		  설정이 가능 (e.g., data-value="...", data-user-id="...")
			  
	    # JS 에서 DOM 요소의 dataset 객체를 통해 접근할 수 있음 (e.g., elem.dataset.id)
			
	    # 커스텀 데이터 속성은 HTML 에 커스텀 정보를 달아두고 JS 에서 element.dataset.변수명으로 
	 	  꺼내서 사용하는 속성
    
    */ 
    if(e.target.id === 'moreBtn'){
        // page 의 값은 String 으로 반환 
        let page = parseInt(e.target.dataset.page);
        spreadCommentList(bnoValue, page);
    }
    

    // 수정 버튼 클릭 시, cno 와 content 를 서버로 전송하여 update  
    if(e.target.classList.contains('mod')){
        // 초기화
         // 수정 버튼 클릭 시 해당 요소와 가장 가까운 li 가져오기 (closest)
        let li = e.target.closest('li');
         // HTML 에 data-cno 형태로 달아둔 데이터 가져오기
        let cno = li.dataset.cno;

         /* nextSibling() 
           > nextSibling 은 DOM 노드 간의 형제 관계에서 다음에 오는 노드전체를 가리키는 속성
             으로 다음에 오는 Element 노드가 아니라 Text 노드 (공백이나 줄바꿈 포함) 를 먼저 반환

           > let cmtText = li.querySelector('.fw-bold').nextSibling; 의 과정 

            #1_ li 요소 안에서 클래스명이 'fw-bold' 인 첫 번째 후손 (el) 을 탐색하고
                <div class="fw-bold">작성자</div> 요소를 가져옴
            
                #2_ <div class="fw-bold">작성자</div> 요소 바로 다음에 오는 노드 (${cvo.content}) 는
                    텍스트이므로 첫 번째 nextSibling 은 텍스트 노드, 두 번째 nextSibling 은 
                    실제 댓글 내용(text content) 노드

            ―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――
           > nodeValue 는 텍스트 노드의 “순수 텍스트 값”을 가져오며 공백·줄바꿈이 먼저 붙어 있기 때문에
             nodeValue 에는 그 공백도 포함 
         */ 
        let cmtText = li.querySelector('.fw-bold').nextSibling;
        // 확인
        console.log(typeof cmtText);
        
        document.getElementById('cmtTextMod').value = cmtText.nodeValue;
        
        // no.cno <b>writer</b> id="exampleModalLabel"
        let cmtWriter = li.querySelector(".fw-bold").innerText;
        document.getElementById('exampleModalLabel').innerHTML = `no.${cno} <b>${cmtWriter}</b>`;

        // cmtModBtn => data-cno = "cno" dataset 달기 
        document.getElementById('cmtModBtn').setAttribute("data-cno", cno);
    }

    // Modal 의 변경 버튼이 클릭 됐을 때, 
    if(e.target.id === 'cmtModBtn'){
        // Modal 버튼이 클릭된 상태
        let cmtData = {
            cno : e.target.dataset.cno,
            content : document.getElementById('cmtTextMod').value
        };

        // 비동기 전송 함수 
        updateCommentToServer(cmtData).then(result => {
            if(result == '1'){ alert("댓글 수정 완료"); }
            else{console.log("댓글 수정 실패")}
        
            // 댓글 뿌리기 
            spreadCommentList(bnoValue);
        })

        // 모달창 닫기
         // btn-close 클래스 클릭  
        document.querySelector('.btn-close').click();
    }

    // 삭제 버튼 클릭 시 
    if(e.target.classList.contains('del')){
        let li = e.target.closest('li');
        let cno = li.dataset.cno;

        // 비동기로 cno 를 보낸 후 DB 에서 삭제 
        removeCommentToServer(cno).then(result => {
            if(result == '1'){ console.log("댓글 삭제 완료"); }
            else{ console.log("댓글 삭제 실패"); }
            spreadCommentList(bnoValue);
        })
    }

})

// 수정 버튼 클릭 시 댓글 수정하는 메서드 
async function updateCommentToServer(cmtData){
    try {
        const url = `/comment/update`;

        const config={
            method : 'put',
            headers : {
                'Content-Type' : 'application/json; charset=utf-8',
                [csrfHeader] : csrfToken
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

// 삭제 버튼 클릭 시 댓글 삭제하는 메서드
async function removeCommentToServer(cno) {
    try {
        const url = `/comment/${cno}`;
        const config = {
            method : 'delete',
            headers : { 
                [csrfHeader] : csrfToken
            },
        }
        const resp = await fetch(url, config);
        const result = await resp.text();

        return result;
    } catch (error) {
        console.log(error);
    }
}

/** 댓글창 
 * 
 * <ul class="list-group list-group-flush" id="cmtListArea">
		<li class="list-group-item">
			<div class="mb-3">
				<div class="fw-bold">writer</div>
				content
			</div>
			<span class="badge text-bg-primary">regDate</span>
		</li>
	</ul>
 *  
 */
function spreadCommentList(bno, page=1){
    getCommentListFromServer(bno, page).then(result => {
        console.log(result);
        // result 출력 
        const ul = document.getElementById('cmtListArea');
        
        // 기존의 댓글유무
        if(result.cmtList.length > 0){
            if(page == 1) { ul.innerHTML = ''; }

            for(let cvo of result.cmtList){
                let li = `<li 
                            class="list-group-item"
                            data-cno="${cvo.cno}">`;
                li += `<div class="mb-3">`
                li += `<div class="fw-bold">${cvo.writer}</div>`
                li += `${cvo.content}`
                li += `</div>`
                li += `<span class="badge text-bg-primary">${cvo.regDate}</span>`
                // 수정버튼 
                if(cvo.writer == authNick){
                    li += `<button 
                            type="button" 
                            class="btn btn-outline-primary mod"
                            style="width:45px; height:35px;"
                            data-bs-toggle="modal"
                            data-bs-target="#myModal"
                            >✏</button>`;
                    // 삭제버튼
                    li += `<button 
                            type="button" 
                            class="btn btn-outline-primary del"
                            style="width:45px; height:35px;"
                            >❌</button>`;
                }
                li += `</li>`;
    
                ul.innerHTML += li;
            }

            // 더보기 버튼 활성화/비활성화 
            let moreBtn = document.getElementById('moreBtn');
             // moreBtn 의 data-page 가 PagingHandler 의 rEndPage 보다 작으면 더보기 버튼 활성화
             // 같거나 크면 비활성화
            if(result.pgvo.pageNo < result.rendPage){
                // style.visivility = "hidden" (숨김)
                // style.visivility = "visible" (표시)
                moreBtn.style.visibility = "visible";
                // data-page++
                moreBtn.dataset.page = page + 1;
            } else {
                moreBtn.style.visibility = "hidden";
            }

        } else{
            ul.innerHTML = `<li class="list-group-item">Comment List Empty</li>`;
        }
    })

}

// post
async function postCommentToServer(cmtData) {
    try {
        const url ="/comment/post";
        const config={
            method : "post",
            headers: {
                'Content-Type' : 'application/json; charset=utf-8',
                [csrfHeader] : csrfToken
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text(); // isOk
        return result;
    } catch (error) {
        console.log(error);
    }
}


// 
async function getCommentListFromServer(bno, page) {
    try {
        // path 로 변수 달고가기 
        const resp = await fetch("/comment/" + bno + "/" + page);
        // List<CommentVO> 를 리턴 받음 
        const result = await resp.json();

        return result;
    } catch (error) {
        console.log(error);
    }
}