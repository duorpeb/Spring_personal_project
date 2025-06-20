// Domain 과 같은 클래스 
package com.myproject.www.handler;

import java.util.List;

import com.myproject.www.domain.CommentVO;
import com.myproject.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {
	// 초기화 
	private int startPage; // 시작페이지
	private int endPage; // 끝 페이지 
	private int qty; // Pagination 의 개수 
	private boolean prev; // 이전 여부
	private boolean next; // 다음 여부
	 // View 에서 받아올 변수 
	private int totalCnt; // 전체 개수 
	private PagingVO pgvo; 
	 // 실제 마지막 페이지  
	private int rEndPage;
	 // 댓글 페이징을 위한 List<CommentVO>
	private List<CommentVO> cmtList;
	 // 
	
	// 생성자
	 // 생성자에서 모든 값을 계산 
	public PagingHandler(int ttc, PagingVO pgvo) {
		this.qty = 10;
		this.pgvo = pgvo;
		this.totalCnt = ttc;
		
		// 1~10 -> 11~20 -> 21~30 ... -> startPage ~ endPage 
		 // endPage 에 rEndPage 
	   // endPage = (startPage / qty(10)) * 10 
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (double)this.qty) * this.qty;
		this.startPage = this.endPage - (this.qty-1);
		
		// 실제 마지막 페이지 
		 // 전체 글수 / 한페이지에 표시되는 게시글 수 (올림) 
		 // 게시글 10개씩 1페이지로 분할한다고 할 때, 11개의 게시글이 있다면 2개의 페이지가 나와야 함 
		this.rEndPage = (int)Math.ceil(totalCnt/(double)pgvo.getQty());
		
		// 이전, 다음 여부 
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.rEndPage;
		
		if(endPage > rEndPage) {
			this.endPage = rEndPage;
		}
	}
	
	
	// 댓글 페이징을 위한 생성자 
	public PagingHandler(int ttc, PagingVO pgvo, List<CommentVO> cmtList) {
		this(ttc, pgvo);
		this.cmtList = cmtList;
	} 
	
//	public PagingHandler(int ttc, PagingVO pgvo, List<UserVO> uvoList) {
//		
//	}
}
