package com.myproject.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.www.domain.BoardDTO;
import com.myproject.www.domain.BoardVO;
import com.myproject.www.domain.FileVO;
import com.myproject.www.domain.PagingVO;
import com.myproject.www.repository.BoardDAO;
import com.myproject.www.repository.FileDAO;
import com.myproject.www.repository.UserDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	// 초기화
	private final BoardDAO bdao;
	private final FileDAO fdao;
	private final UserDAO udao;
	
	// 게시물 등록
	public int getInsert(BoardDTO bdto) {
		int isOk = bdao.getInsert(bdto.getBvo());
		
		if(bdto.getFvoList() == null) { return isOk; }
		
		if(isOk > 0) {
			// 가장 최근에 저장한 Board 의 Bno 불러오기
			Long bno = bdao.getBno();
			
			for(FileVO f : bdto.getFvoList()) {
				f.setBno(bno);
				isOk *= fdao.insertFile(f);
			}
		}
		
		return isOk; 
	}

	// 게시물 등록 후 detail 페이지로 이동하기 위한 newstBno() 
	@Override
	public long getBno(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.getBno();
	}
	
	// 이전글 이동을 위한 bno 가져오기
	@Override
	public Long getPrevContent(long bno) {
		return bdao.getPrevContent(bno);
	}


	// 다음글 이동을 위한 bno 가져오기
	@Override
	public Long getNextContent(long bno) {
		// TODO Auto-generated method stub
		return bdao.getNextContent(bno);
	}

	// detail.jsp 에 정보를 뿌리기 위한 select
	@Override
	public BoardDTO getDetail(long bno) {
		// BoardDTO bdto = new BoardDTO(bvo, fvoList); 
		BoardVO bvo = bdao.getDetail(bno);
		List<FileVO> fvoList = fdao.getList(bno);
		BoardDTO bdto = new BoardDTO(bvo, fvoList);
		
		return bdto;
	}

	// 조회수 1 증가	
	@Override
	public int getCntUp(long bno) {
		return bdao.getCntUp(bno);
	}

	// 조회수 1 감소	
	@Override
	public int getCntDown(long bno) {
		return bdao.getCntDown(bno);
	}
	
	
	// 게시글 가져오기
	@Override
	public ArrayList<BoardDTO> getList(PagingVO pgvo) {
		List<BoardVO> list = bdao.getList(pgvo); 
		ArrayList<BoardDTO> bdtoList = new ArrayList<>();
		// 확인
		log.info("getList(PagingVO pgvo) 의 list : {}", list);
		
		for(BoardVO bvo : list) {
			log.info("getList(PagingVO pgvo) 의 bvo : {}", bvo);
			
			String writer = bvo.getWriter();
			// 해당 게시글의 닉네임 가져와서 BoardDTO 생성
			BoardDTO wr = new BoardDTO(bvo, bdao.getFileName(writer));
			bdtoList.add(wr);
		}
		
		return bdtoList;
	}

	// 게시글 수정
	@Override
	public int getUpdate(BoardDTO bdto) {
		if(bdto.getFvoList() != null) {
			for(FileVO fvo : bdto.getFvoList()) {
				fvo.setBno(bdto.getBvo().getBno());
				fdao.insertFile(fvo);
			}
		}
				
		return bdao.getUpdate(bdto.getBvo());
	}
}
