package com.pjt.edu.board.sug;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.board.BoardVO;
import com.pjt.edu.board.mcreview.MCREVBoardVO;
import com.pjt.edu.user.UserDAO_mybatis;
import com.pjt.edu.user.UserVO;

@Controller
public class SUGcontroller {

	@Autowired
	SUGDAO dao;
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
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.GET)
	public String insertBordForm() {
		return "insertformSUG";
	}

	//글쓰기 완료후 DB 저장후 목록으로 이동.
	@RequestMapping(value = "/insertformSUG", method = RequestMethod.POST)
	public String insertBoareResult(SUGBoardVO vo) {

		dao.insertBoard(vo);
		return "redirect:/listSUG";
	}

	//SUG Board list 출력.
	@RequestMapping("/listSUG")
	public ModelAndView sugboardlist(String num) {

//		ModelAndView mv = new ModelAndView();
//		SUGBoardVO vo = new SUGBoardVO();
//		List<BoardVO> list = dao.getBoardList(vo);
//		
//		mv.addObject("list", list);
//		return mv;
		if (num == null) {
			num = "1";
		}
		ModelAndView mv = new ModelAndView();
		String row = dao.rowcount();

		allrow=this.pagemap();


		List<BoardVO> list = dao.getBoardList5(num);

		mv.addObject("list", list);
		mv.addObject("page", allrow);
		mv.setViewName("listSUG");

		return mv;
	}

	//세부글 출력.
	@RequestMapping(value = "/detailSUG", method = RequestMethod.GET)
	public ModelAndView sugboardone(SUGBoardVO vo) {

		System.out.println(vo);

		ModelAndView mv = new ModelAndView();
//		dao.upViewCount(vo);	
		vo = (SUGBoardVO) dao.getBoard(vo);
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
	//글 수정. 작성자와 admin만 수정가능. 수정할 글을 updateformMCREV로 가져옴.
	@RequestMapping(value = "/updateSUG", method = RequestMethod.GET)
	public ModelAndView updateBoard(/* @ModelAttribute("update") */ SUGBoardVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vo);
		SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
		String roll = ((UserVO) session.getAttribute("member")).getRole();

		if (loginVO.getWriter().equals(vo.getWriter())) {
			vo = (SUGBoardVO) dao.getBoard(vo);
			System.out.println(vo);
			mv.addObject("update", vo);
			mv.setViewName("updateformSUG");
			return mv;
		} else if (roll.equals("admin")) {
			vo = (SUGBoardVO) dao.getBoard(vo);
			System.out.println(vo);
			mv.addObject("update", vo);
			mv.setViewName("updateformSUG");
			return mv;
		} else {
			mv.setViewName("cannotDelete");
			return mv;
		}

	}

	// 글 삭제기능. 작성자와 admin만 삭제 가능.
	@RequestMapping(value = "/updateSUG", method = RequestMethod.POST)
	public String updateformBoard(/* @ModelAttribute("update") */ SUGBoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:./listSUG";
	}
	// 글 삭제기능. 작성자와 admin만 삭제 가능.
	@RequestMapping(value = "/deleteSUG", method = RequestMethod.GET)
	public String deleteBoardResult(SUGBoardVO vo, HttpSession session) {
		System.out.println(vo);
		SUGBoardVO loginVO = (SUGBoardVO) dao.getBoard(vo);
		String roll = ((UserVO) session.getAttribute("member")).getRole();

//		UserVO uvo= new UserVO();
//		uvo.setId(vo.getWriter());
//		
//		uvo=udao.getUser(uvo);
		if (loginVO.getWriter().equals(vo.getWriter())) {
			dao.deleteBoard(vo);
			return "redirect:/listSUG";
		} else if (roll.equals("admin")) {
			dao.deleteBoard(vo);
			return "redirect:listSUG";
		} else {
			return "cannotDelete";
		}
	}
	//검색기능. title or writer 로 검색.
		@RequestMapping(value="/listSUG",method=RequestMethod.POST)
		public ModelAndView researchBoardList(SUGBoardVO vo, String search,String choice) {
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
