package com.pjt.edu.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.edu.classes.ClassDAO;
import com.pjt.edu.classes.ClassVO;

@Controller
public class UserController {

	@Autowired
	UserDAO mdao;

	@Autowired
	ClassDAO cdao;

	@RequestMapping(value = "/main")
	public String getMain() {

		return "main";
	}

	@RequestMapping(value = "/mypage")
	public String UserMain(HttpSession session) {
		UserVO vo = (UserVO)session.getAttribute("member");
		
		UserVO user = mdao.getUser(vo);

		if (user != null) {
			
			ClassVO cvo = new ClassVO();
			cvo.setClassNo(user.getClassNo());
			ClassVO lecture = cdao.getClass(cvo);
			
			session.setAttribute("member", user);
			session.setAttribute("lecture", lecture);
			return "mypage";
		} else
			return "main";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam("id") String id, String pw, String button) {
		/*
		 * if(vo.getId()==null || vo.getId().equals("")) { throw new
		 * IllegalArgumentException("占쎈툡占쎌뵠占쎈탵占쎈뮉 獄쏆꼶諭띰옙�뻻 占쎌뿯占쎌젾占쎈퉸占쎈튊 占쎈�占쎈빍占쎈뼄."); }
		 */
		HttpSession session = request.getSession();
		if(button.equals("Sign up")) {
			List<ClassVO> list = cdao.getAllClass();
			session.setAttribute("clist", list);
			return "signup";
		}
		UserVO user = null;
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		user = mdao.login(vo);
		ModelAndView mav = new ModelAndView();
		//System.out.println(user.getPoint());

		if (user != null) {
			mav.addObject("user", user);
//			if (user.getRole().equals("admin")) {
//				mav.setViewName("mypage");
//				return mav;
//			}
			ClassVO cvo = new ClassVO();
			cvo.setClassNo(user.getClassNo());
			ClassVO lecture = cdao.getClass(cvo);
			
			session.setAttribute("member", user);
			session.setAttribute("lecture", lecture);
			return "mypage";
		} else
			return "main";

	}
	
	//�쉶�썝媛��엯
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(UserVO vo) {

		
		ModelAndView mv = new ModelAndView();
		//System.out.println(vo.getId());
		UserVO mem = null;
		mem=mdao.getUser(vo);
		if(mem==null) {
			if(vo.getClassNo()==0) {
				
				return "signupfail2";
			}
			else {
				mdao.insertUser(vo);
			}
			return "signupsuccess";
		}
		else {
			return "signupfail";
		}

	}
	
	//logout
	   @RequestMapping(value = "/logout")
	   public String logout(HttpSession session) {
	      session.invalidate();
	      return "main";
	      
	   }
	
	
	/* 占쎈뼒�노낌媛� 占쎌뱽占쎌뒭疫뀐옙 */

	@RequestMapping(value = "/useticket")
	public String useticket() {

		return "/useticket";
	}

	
	/* 占쎈뼒�놂옙 �뤃�됤꼻 筌∽옙 占쎌뱽占쎌뒭疫뀐옙 */
	@RequestMapping(value = "/buyticket")
	public String buyticket() {
		
		return "buyticket";
	}

	@RequestMapping(value = "/todaymenu")
	public String todaymenu() {
		return "/todaymenu";
	}
	
	
	/* 占쎈뼒�노낌沅쀯옙�뒠 */
	@RequestMapping(value = "/useticketClick")
	public String useticketClick(UserVO vo, HttpSession session) {
		
		String sessionId = ((UserVO)session.getAttribute("member")).getId();
		
		mdao.useticket(sessionId);

		return "/result";
	}
	
	   
	   
	   //占쎈뼒�노낀�럡筌랃옙//
		@RequestMapping(value = "/buyticketClick", method = RequestMethod.GET)
		public String buyticketClick(@RequestParam("ticket")String ticket,  HttpSession session) {
			
			UserVO user = (UserVO)session.getAttribute("member");
			int point = user.getPoint();
			
			if(point < Integer.parseInt(ticket) * 60) {
				
			}
			
			String sessionId = user.getId();
			

			Map map = new HashMap();
			map.put("ticket", Integer.parseInt(ticket));
			map.put("sessionID", sessionId);
			System.out.println(ticket);
			System.out.println(sessionId);
			
			mdao.addticket(map);


			return "/result";
		}
	   
	   
	   //占쎈７占쎌뵥占쎈뱜 �빊�뫗�읈筌∽옙//
	   @RequestMapping(value = "/addpoint")
		public String addPoint(UserVO vo) {
		   return "/addpoint";
		}
		
	  
	   //占쎈７占쎌뵥占쎈뱜 �빊�뫗�읈//
	   
		@RequestMapping(value = "/addpointClick",  method = RequestMethod.GET)
		public String addPointClick(@RequestParam("money")String money,  HttpSession session) {
			
			String sessionId = ((UserVO)session.getAttribute("member")).getId();
			
			Map map = new HashMap();
			map.put("point", Integer.parseInt(money));
			map.put("sessionID", sessionId);
			System.out.println(money);
			System.out.println(sessionId);
			System.out.println(map);
			mdao.addpoint(map);

			return "/result";
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
