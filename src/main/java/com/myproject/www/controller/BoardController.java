package com.myproject.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.www.domain.BoardDTO;
import com.myproject.www.domain.BoardVO;
import com.myproject.www.domain.FileVO;
import com.myproject.www.domain.PagingVO;
import com.myproject.www.handler.FileHandler;
import com.myproject.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {
	// 초기화
	private final BoardService bsv;
	 // 파일 핸들러 
	private final FileHandler fh;
	
	/* @GetMapping 시 return 의 생략 
	 * 
	 * > jsp 에서 controller 로 오는 경로 (e.g., /board/register) 와
	 *   리턴 주소 (e.g., jsp 파일 경로; /WEB-INF/views/board/register.jsp) 가 같은 경우 
	 *   return 생략하여 작성 가능 (void 형태)
	 * 
	 * */
	@GetMapping("/register")
	public void register(){}
	
	
	@PostMapping("/insert")
	public String insert(BoardVO bvo, MultipartFile[] files) {
		// 확인
		log.info("board insert 의 bvo : {}", bvo);
		
		/* 파일 첨부 시 insert 
		 * 
		 * > 1_ MultipartFiel[] files 를 DB 에 저장할 값으로 생성해야 함 
		 *   # List<FileVO> 형태로 생성 
		 *   
		 * > 2_ 실제 파일을 폴더에 저장해야 함 
		 * 	# FileHandler 의 upFile() 사용
		 * 
		 * > 3_ FileDAO 와 fileMapper 생성 
		 * */ 
		 // 1번 과정
		List<FileVO> fvoList = null;
		
		 // 2번 과정
		  // 파일이 있는 경우
		if(files[0].getSize() > 0) {
			fvoList = fh.upFile(files);
			
			// 확인
			log.info("board insert 의 flist : {}", fvoList);
		}
		
		 // 3번 과정
		BoardDTO bdto = new BoardDTO(bvo, fvoList);
		  // 확인
		int isOk = bsv.getInsert(bdto);
		
		// detail page 로 이동하기 위한 getBno
		long newstBno = bsv.getBno(bvo);
		
		return "redirect:/board/detail?bno=" + newstBno;
	}
	
	
	@GetMapping({"/detail","/modify"})
	public void detail(@RequestParam("bno") long bno, Model m, HttpServletRequest req) {
		String url = req.getRequestURI();
		log.info("url : {}", url);
		
		Long prevContent = bsv.getPrevContent(bno);
		Long nextContent = bsv.getNextContent(bno);
		
		log.info("prev and next : {}", prevContent, " / ", nextContent);
		
		// BoardServiceImpl 에서 BoardDTO bdto = new BoardDTO(bvo,fvoList) 형태로 반환
		BoardDTO bdto = bsv.getDetail(bno);
		
		switch(url) {
			case "/board/detail" : 
				/* Parameter 가 2개 일 때, 아래와 같이 작성
				 * 
				 * > Controller → int isValidCnt = bsv.getCntUp(bno, 1);
				 * 
				 * > Service / ServiceImpl → int getCntUp(@Param("bno")long bno, @Param("read_count")long i);
				 * 
				 * > DAO → int getCntUp(@Param("bno")long bno, @Param("read_count")long i);
				 * 
				 * > Mapper → update board set read_count = read_count + #{i} where bno = #{bno}
				 * */ 
				int isValidCnt = bsv.getCntUp(bno);	
				break;
			
			case "/board/modify" : 
				int isValidDecreCnt = bsv.getCntDown(bno);
				break;
		}
//		BoardVO bvo = bsv.getDetailBno(bno);
		
		
		if(nextContent == null) { nextContent = bdto.getBvo().getBno();}
		if(prevContent == null) { prevContent = bdto.getBvo().getBno(); } 
		
		m.addAttribute("bdto", bdto);
		// 이전글, 다음글 
		m.addAttribute("prev", prevContent);
		m.addAttribute("next", nextContent);
	}
	
	
	@PostMapping("/update")
	public String update(BoardVO bvo, RedirectAttributes re, @RequestParam(value="files", required = false) MultipartFile[] files) {
		List<FileVO> flist = null;
		int cnt = 0;
		
		// 파일이 있다면 
		if(files[0].getSize() > 0) {
			cnt = files.length;
			
			// 파일 객체 생성
			flist = fh.upFile(files);
		}
		
		
		
//		int isValidDecreCnt = bsv.getCntDown(bvo.getBno());
		int isOk = bsv.getUpdate(new BoardDTO(bvo, flist));
		
		
		// 아래와 같이 작성하거나 
		// 파라미터에 RedircetAttributes re 를 작성하고 
		// re.addAttribute("bno",bvo.getBno()); 로 작성할 수도 있음  
		return "redirect:/board/detail?bno=" + bvo.getBno();
	}
}
