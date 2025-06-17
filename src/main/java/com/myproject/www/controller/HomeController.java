package com.myproject.www.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.www.domain.BoardDTO;
import com.myproject.www.domain.PagingVO;
import com.myproject.www.service.BoardService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@RequiredArgsConstructor
@Controller
public class HomeController {
	// 초기화
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 /* boardService
	  * 
	  * > @Autowired 사용 시 절대 static 필드에 붙이지 말고
	  *   스프링이 관리하는 인스턴스 필드(또는 생성자, 세터 메서드)에 붙여야 함
	  *   
	  * > 1번 형태 - 필드 주입 : private BoardService boardService;
	  *   
	  *   2번 형태 - 세터 주입  
	  *   	@Autowired
	  *   	public void setBoardService(BoardService boardService) {
	  *   		this.boardService = boardService;
	  *   	}
	  *   
	  *   3번 형태 - 생성자 주입 (가장 권장)
	  *    // @Autowired 생략 가능 (Spring 4.3+ 단일 생성자일 때)
    		 @Autowired
    		 public HomeController(BoardService boardService) {
        	 this.boardService = boardService;
				 }
	  * */ 
	private final BoardService bsv;
	
//	@Autowired
//	public HomeController(BoardService bsv) { this.bsv = bsv; }
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model m) {
		PagingVO pgvo = new PagingVO(1,4);
		
		// 4개씩 가져옴 
		List<BoardDTO> list = bsv.getList(pgvo);
		logger.info("/list 의 list : {},", list);
		
		m.addAttribute("pgvo", pgvo);
		m.addAttribute("list", list);
		
		return "home";
	}
	
}
