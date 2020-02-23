package com.pjt.edu.board.review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.mcreview.MCREVBoardVO;
import com.pjt.edu.user.UserVO;

@Controller
public class REVcontroller {
	@Autowired
	REVDAO dao;
	
	List<Integer> allrow = new ArrayList<Integer>();

	// paging 처리 매서드
	public List<Integer> pagemap() {
		String row = dao.rowcount();
		List<Integer> allrow = new ArrayList<Integer>();
		int length;
		if ((Integer.valueOf(row) % 5) == 0) {
			length = Integer.valueOf(row) / 5;
		} else {
			length = (Integer.valueOf(row) / 5) + 1;
		}

		for (int i = 0; i < length; i++) {
			allrow.add(i, i + 1);
		}
		return allrow;
	}

	//글쓰기 폼 띄우기.
	@RequestMapping(value = "/insertformREV", method = RequestMethod.GET)
	public String insertBordForm() {
		return "insertformREV";
	}

	//글쓰기 완료후 DB 저장후 목록으로 이동.
	@RequestMapping(value = "/insertformREV", method = RequestMethod.POST)
	public String insertBoareResult(REVBoardVO vo) {
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		dao.insertBoard(vo);
		return "redirect:/listREV";

	}

	//MCREV Board list 출력.
	@RequestMapping("/listREV")
	public ModelAndView getBoardlist(String num) {
		if (num == null) {
			num = "1";
		}
		ModelAndView mv = new ModelAndView();

		String row = dao.rowcount();

		allrow=this.pagemap();

		List<BoardVO> list = dao.getBoardList5(num);

		mv.addObject("list", list);
		mv.addObject("page", allrow);
		mv.setViewName("listREV");

		return mv;

	}

	/*
	 * @RequestMapping("/mybatis/emplist") public ModelAndView getAllEmp(){
	 * 
	 * List<EmpVO> list = dao.getAllEmp(); ModelAndView mv = new ModelAndView();
	 * mv.addObject("list", list); return mv; }
	 */

	//세부글 출력.
	@RequestMapping(value = "/detailREV", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(REVBoardVO vo) {
		ModelAndView mv = new ModelAndView();
		vo = (REVBoardVO) dao.getBoard(vo);
		mv.addObject("detail", vo);
		mv.setViewName("detailREV");
		return mv;
	}

	//글 수정. 작성자와 admin만 수정가능. 수정할 글을 updateformMCREV로 가져옴.
	@RequestMapping(value = "/updateREV", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ REVBoardVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vo);
		REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);
		String roll = ((UserVO) session.getAttribute("member")).getRole();

		if (loginVO.getWriter().equals(vo.getWriter())) {
			vo = (REVBoardVO) dao.getBoard(vo);
			System.out.println(vo);
			mv.addObject("update", vo);
			mv.setViewName("updateformREV");
			return mv;
		} else if (roll.equals("admin")) {
			vo = (REVBoardVO) dao.getBoard(vo);
			System.out.println(vo);
			mv.addObject("update", vo);
			mv.setViewName("updateformREV");
			return mv;
		} else {
			mv.setViewName("cannotDelete");
			return mv;
		}

	}

	// 글 삭제기능. 작성자와 admin만 삭제 가능.
	@RequestMapping(value = "/updateREV", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */REVBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listREV";
	}

	// 글 삭제기능. 작성자와 admin만 삭제 가능.
	@RequestMapping(value = "/deleteREV", method = RequestMethod.GET)
	public String deleteBoardResult(REVBoardVO vo, HttpSession session) {
		System.out.println(vo);
		String roll = ((UserVO) session.getAttribute("member")).getRole();
		REVBoardVO loginVO = (REVBoardVO) dao.getBoard(vo);

//			UserVO uvo= new UserVO();
//			uvo.setId(vo.getWriter());
//			
//			uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:/listREV";
		} else {
			return "cannotDelete";
		}
	}
	//검색기능. title or writer 로 검색.
		@RequestMapping(value="/listREV",method=RequestMethod.POST)
		public ModelAndView researchBoardList(REVBoardVO vo, String search,String choice) {
			ModelAndView mv = new ModelAndView();
			search = "%"+search+"%";
			if(choice.equals("writer")) {
				String writer = search;
				List<BoardVO> list = dao.writerList(writer);
				System.out.println(list);
				mv.addObject("list", list) ;
			}else if(choice.equals("title")) {
				String title=search;
				mv.addObject("list", dao.titleList(title)) ;
			}
			
			allrow=this.pagemap();
			mv.addObject("page",allrow);
			
			return mv;
		}

}
