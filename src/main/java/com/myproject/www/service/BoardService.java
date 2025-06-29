package com.myproject.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.www.domain.BoardDTO;
import com.myproject.www.domain.BoardVO;
import com.myproject.www.domain.PagingVO;


public interface BoardService {
	// 게시물 등록
	int getInsert(BoardDTO bdto);
	
	// 게시물 등록 시 detail 페이지로 이동하기 위한 가장 최근의 bno 가져오기
	long getBno(BoardVO bvo);
	
	// 이전글 이동을 위한 bno 가져오기
	Long getPrevContent(long bno);

	// 다음글 이동을 위한 bno 가져오기
	Long getNextContent(long bno);

	// detail.jsp 에 정보를 뿌리기 위한 select
	BoardDTO getDetail(long bno);
	
	// 조회수 1 증가
	int getCntUp(long bno);

	// 조회수 1 감소
	int getCntDown(long bno);
	
	// 게시글 가져오기
	ArrayList<BoardDTO> getList(PagingVO pgvo);
	
  // 게시글 수정
	int getUpdate(BoardDTO bdto);

}
