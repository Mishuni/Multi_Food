package com.pjt.edu.board.mcreview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;


@Controller
public class MCREVcontroller {
	@Autowired
	MCREVBoardDAO dao;
	
	
//글쓰기 폼화면
	@RequestMapping(value="/insertformMCREV", method = RequestMethod.GET)
	public String inertBoardForm() {
		return "/insertformMCREV";
	}
//글쓰기 후 저장
	@RequestMapping(value="/insertformMCREV", method=RequestMethod.POST)
	public String insertBoard(MCREVBoardVO vo) {
		dao.insertBoard(vo);
	
		return "redirect:/listMCREV";
	}
	
	  
	
	
//글목록
	@RequestMapping("/listMCREV")
	public ModelAndView getAllBoard() {
		ModelAndView mv = new ModelAndView();
		MCREVBoardVO vo = new MCREVBoardVO();
		 List<BoardVO> list = dao.getBoardList(vo);
	      
	      mv.addObject("list", list);
	      mv.setViewName("listMCREV");
	      return mv;
	}
	
//글 하나 조회 detail
	@RequestMapping(value="/detailMCREV", method=RequestMethod.GET)
	public ModelAndView getBoardDetail(MCREVBoardVO vo) {
		vo = (MCREVBoardVO)dao.getBoard(vo);
		ModelAndView mv =  new ModelAndView();
		mv.addObject("detail",vo);
		mv.setViewName("detailMCREV");
		return mv;
		
	}
}
