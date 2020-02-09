package com.pjt.edu.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.classes.ClassDAO;
import com.pjt.edu.classes.ClassVO;


@Controller
public class UserController {
	@Autowired 
	//1.<beans:bean id="dao" class="xxx.BoardDAO" 
	//2. @Repository("dao") class BoardDAO
	UserDAO dao;
	
	@Autowired
	ClassDAO cdao;

	@RequestMapping(value="/" )
	public String getMain() {
		ModelAndView mav = new ModelAndView();
		return "main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("id")String id, 
			String pw) {
		/*
		 * if(vo.getId()==null || vo.getId().equals("")) { throw new
		 * IllegalArgumentException("아이디는 반드시 입력해야 합니다."); }
		 */
		UserVO user = null;
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		user = dao.getUser(vo);
		ModelAndView mav = new ModelAndView();
		
		if(user!=null) {
			mav.addObject("user",user);
			if(user.getRole().equals("admin")) {
				mav.setViewName("adminpage");
				return mav;
			}
			ClassVO cvo = new ClassVO();
			cvo.setClassNo(user.getClassNo());
			ClassVO lecture = cdao.getClass(cvo);
			mav.addObject("lecture",lecture);
			mav.setViewName("mypage");
		}
		else 
			mav.setViewName("redirect:/");
		return mav;
	}
	
//	@RequestMapping(value="/mypage")
//	public ModelAndView getMypage(@ModelAttribute("user")UserVO vo) {
//		ModelAndView mav = new ModelAndView();
//		UserVO user = vo;
//		mav.addObject("user",user);
//		mav.setViewName("mypage");
//		return mav;
//	}
}
