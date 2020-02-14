package com.pjt.edu.board.sug;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.mcreview.MCREVBoardVO;
import com.pjt.edu.board.review.REVBoardVO;

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
	
//	@RequestMapping(value="/insertFormSUG", method=RequestMethod.GET)
//	public ModelAndView updateform(SUGBoardVO vo) {
//		ModelAndView mv = new ModelAndView();
//		
//		vo=(SUGBoardVO)dao.getBoard(vo);
//		mv.addObject("update",vo);
//		return mv;
//	}
//	@RequestMapping(value="/insertFormSUG", method=RequestMethod.POST)
//	public String updateboard(SUGBoardVO vo) {
//		
//		
//		
//		return "redirect:detailSUG";
//		
//	}
	//get insert form
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.GET)
	public void insertBordForm() {

	}

	// 삽입2
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.POST)
	public String insertBoareResult(SUGBoardVO vo) {

		dao.insertBoard(vo);
		return "redirect:/listSUG";
	}
	
	@RequestMapping(value="/deleteSUG", method=RequestMethod.GET)
	public String deleteBoardResult(SUGBoardVO vo) {
		System.out.println(vo);
		SUGBoardVO loginVO = (SUGBoardVO)dao.getBoard(vo);
		
//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if(loginVO.getWriter().equals(vo.getWriter())) {
		dao.deleteBoard(vo);
			return "redirect:/listSUG";
		}else if(vo.getWriter().equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listSUG";
		}
		else {
			return "cannotDelete";
		}
	} 
	
}
