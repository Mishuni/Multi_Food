package com.pjt.edu.board.mcreview;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.review.REVBoardVO;
import com.pjt.edu.board.sug.SUGBoardVO;
import com.pjt.edu.user.UserVO;

@Controller
public class MCREVcontroller {
	@Autowired
	MCREVBoardDAO dao;

//글쓰기 폼화면
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.GET)
	public String inertBoardForm() {
		return "/insertformMCREV";
	}

//글쓰기 후 저장
	@RequestMapping(value = "/insertformMCREV", method = RequestMethod.POST)
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
	@RequestMapping(value = "/detailMCREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(MCREVBoardVO vo) {
		vo = (MCREVBoardVO) dao.getBoard(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", vo);
		mv.setViewName("detailMCREV");
		return mv;

	}
	//수정할 글 title,contents를 updateform 으로 가져오기. 글쓴이, admin만 수정가능.
	@RequestMapping(value = "/updateMCREV", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ MCREVBoardVO vo, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			System.out.println(vo);
			MCREVBoardVO loginVO = (MCREVBoardVO) dao.getBoard(vo);
			String roll = ((UserVO)session.getAttribute("member")).getRole();
			
			
			if (loginVO.getWriter().equals(vo.getWriter())) {
				vo = (MCREVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformMCREV");
				return mv;
			} else if (roll.equals("admin")) {
				vo = (MCREVBoardVO) dao.getBoard(vo);
				System.out.println(vo);
				mv.addObject("update", vo);
				mv.setViewName("updateformMCREV");
				return mv;
			} else {
				mv.setViewName("cannotDelete");
				return mv;
			}

		}

	// 수정한 글 업데이트.
	@RequestMapping(value = "/updateMCREV", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ MCREVBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listMCREV";
	}
	
	
	
	// 게시물 삭제
	@RequestMapping(value = "/deleteMCREV", method = RequestMethod.GET)
	public String deleteBoardResult(MCREVBoardVO vo,HttpSession session) {
		System.out.println(vo);
		MCREVBoardVO loginVO = (MCREVBoardVO) dao.getBoard(vo);
		String roll = ((UserVO)session.getAttribute("member")).getRole();

//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listMCREV";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listMCREV";
		} else {
			return "cannotDelete";
		}
	}
}
