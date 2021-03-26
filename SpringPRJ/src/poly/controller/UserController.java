package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.util.CmmUtil;

@Controller
public class UserController {
	

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	@RequestMapping(value="user/UserLogin.do")
	public String userLogin(HttpServletRequest request, ModelMap model) {
		
		log.info(this.getClass() + "user/userLogin start!!");
		
		log.info(this.getClass() + "user/userLogin end!!");
		
		return "/user/UserLogin.do";
	}
	

	@RequestMapping(value = "user/SignUp.do")
	public String newUser (HttpServletRequest request, ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + "SignUp start!!");
		
		String msg = "";
		String url = "/user/UserLogin.do";
		UserDTO uDTO = null;
		
		try {
			
			String user_id  = request.getParameter("IdText");
			String password  = request.getParameter("PassText");
			String user_name  = request.getParameter("NameText");
			String email  = request.getParameter("EmailText");
			String gender  = request.getParameter("gender");
			
			log.info(user_id);
			log.info(password);
			log.info(user_name);
			log.info(email);
			log.info(gender);
			
			uDTO = new UserDTO();
			
			uDTO.setId(user_id);
			uDTO.setPwd(password);
			uDTO.setName(user_name);
			uDTO.setEmail(email);
			uDTO.setGender(gender);
			
			int res = userService.SignUp(uDTO);
			log.info(res);
			
			if ( res < 1) {
				// 회원가입 실패 
				msg = "가입 실패";
			} else {
				//성공 
				msg = "가입 성공";
			}
			
		}catch ( Exception e) {
			msg = " 회원가입에 실패하였습니다. ";
			log.info(msg);
			e.printStackTrace();
		}finally {
			model.addAttribute("msg",msg);
			model.addAttribute("url",url);
			log.info(this.getClass().getName() + "SignUp end !!");
			
			uDTO = null;
		}
		
		
		return "/main.do";
	}
	@RequestMapping(value="user/userLoginProc.do")
	
	public String userLoginProc(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		log.info(this.getClass() + "user/userLoginProc start!!");
		
		String id = CmmUtil.nvl(request.getParameter("IdText"));
		String pwd = CmmUtil.nvl(request.getParameter("PassText"));

		UserDTO uDTO = new UserDTO();
		
		uDTO.setId(id);
		uDTO.setPwd(pwd);
		
		uDTO = userService.getLoginInfo(uDTO);
		
		log.info("uDTO null?" + (uDTO == null));
		String msg = "";
		String url = "";
		
		if(uDTO == null) {
			msg = "로그인 실패";
		} else {
			log.info("uDTO ID : " + uDTO.getId());
			log.info("uDTO PWD : " + uDTO.getPwd());
			log.info("uDTO NAME : " + uDTO.getName());
			msg = "로그인 성공";
			session.setAttribute("id", uDTO.getId());
			session.setAttribute("name", uDTO.getName());
		}
		
		url = "/";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass() + "user/userLoginProc end!!");
		
		return "/user/redirect";
	}
	
	@RequestMapping(value="user/logOut.do")
	public String logOut(HttpSession session, Model model) throws Exception{
		log.info(this.getClass() + "user/logOut start!!");

		String msg = "";
		String url = "";
		msg = "로그아웃 성공";
		url = "/";
		
		session.invalidate(); // 세션 정보 초기화
		
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass() + "user/loginOut end!!");
		
		return "/user/redirect";
	}		
	
	@RequestMapping(value="/user/FindPass.do")
	public String FindPassId(HttpSession session, Model model) throws Exception{
		
		log.info(this.getClass().getName() +  " FindPass_Page Open Start !");
		
		
		
		log.info(this.getClass().getName() +  " FindPass_Page Open End !");
		
		return "loginPage.do";
	}
}
