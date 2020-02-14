package com.pjt.edu.board.sug;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.user.UserDAO_mybatis;
import com.pjt.edu.user.UserVO;

@Controller
public class SUGcontroller {

	@Autowired
	SUGDAO dao;
	@Autowired
	UserDAO_mybatis udao;
	//삽입
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.GET)
	public void insertBordForm() {
		
	}
	
	// 삽입2
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.POST)
	public String insertBoareResult(SUGBoardVO vo) {
		
		dao.insertBoard(vo);
		return "redirect:/listSUG";
	}
	
	//조회
	@RequestMapping("/listSUG")
	public ModelAndView sugboardlist() {
		
		ModelAndView mv = new ModelAndView();
		SUGBoardVO vo = new SUGBoardVO();
		List<BoardVO> list = dao.getBoardList(vo);
		
		mv.addObject("list", list);
		return mv;
	}
	//상세보기
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
	// 글쓴이만 수정 가능
		@RequestMapping(value = "/updateSUG", method = RequestMethod.GET)
		public ModelAndView updateBoard(@ModelAttribute("update") SUGBoardVO vo, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo);
			SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
			String roll = ((UserVO)session.getAttribute("member")).getRole();
			System.out.println(roll);
			
			if (loginVO.getWriter().equals(vo.getWriter())) {
				vo = (SUGBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformSUG");
				return mv;
			} else if (roll.equals("admin")) {
				dao.deleteBoard(vo);
				return mv;
			} else {
				mv.setViewName("cannotDelete");
				return mv;
			}

		}

		// 수정한 글 업데이트.
		@RequestMapping(value = "/updateSUG", method = RequestMethod.POST)
		public String updateformBoard(@ModelAttribute("update") SUGBoardVO vo) {
			dao.updateBoard(vo);
			return "redirect:./listSUG";
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
