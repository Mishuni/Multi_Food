package com.pjt.edu.board.sug;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;

@Controller
public class SUGcontroller {

	@Autowired
	SUGDAO dao;
	
	@RequestMapping("/listSUG")
	public ModelAndView sugboardlist() {
		
		ModelAndView mv = new ModelAndView();
		SUGBoardVO vo = new SUGBoardVO();
		List<BoardVO> list = dao.getBoardList(vo);
		
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/detailSUG", method=RequestMethod.GET )
	public ModelAndView sugboardone(SUGBoardVO vo) {
		
		ModelAndView mv = new ModelAndView();
//		dao.upViewCount(vo);	
		vo = (SUGBoardVO)dao.getBoard(vo);
		mv.addObject("detail", vo);
		return mv;
	}
	
	@RequestMapping(value="/insertFormSUG", method=RequestMethod.GET)
	public ModelAndView updateform(SUGBoardVO vo) {
		ModelAndView mv = new ModelAndView();
		
		vo=(SUGBoardVO)dao.getBoard(vo);
		mv.addObject("update",vo);
		return mv;
	}
	@RequestMapping(value="/insertFormSUG", method=RequestMethod.POST)
	public String updateboard(SUGBoardVO vo) {
		
		
		
		return "redirect:detailSUG";
		
	}
}
