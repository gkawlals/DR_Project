package poly.controller;

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
	
	@RequestMapping(value = "user/SignUp.do")
	public String newUser (HttpServletRequest request, ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + "SignUp start!!");
		
		String msg = "";
		String url = "/user/UserLogin.do";
		UserDTO uDTO = null;
		
		try {
			
			String user_id  = request.getParameter("user_id");
			String user_pwd  = request.getParameter("user_pwd");
			String user_name  = request.getParameter("user_name");
			String user_email  = request.getParameter("user_email");
			
			log.info(user_id);
			log.info(user_pwd);
			log.info(user_name);
			log.info(user_email);
			
			uDTO = new UserDTO();
			
			uDTO.setUser_id(user_id);
			uDTO.setUser_pwd(user_pwd);
			uDTO.setUser_name(user_name);
			uDTO.setUser_email(user_email);
			
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
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));

		UserDTO uDTO = new UserDTO();
		
		uDTO.setUser_id(user_id);
		uDTO.setUser_pwd(user_pwd);
		
		uDTO = userService.getLoginInfo(uDTO);
		
		log.info("uDTO null?" + (uDTO == null));
		
		String msg = "";
		String url = "";
		
		if(uDTO == null) {
			
			msg = "로그인 실패";
			
		} else {
			
			log.info("uDTO ID : " + uDTO.getUser_id());
			log.info("uDTO PWD : " + uDTO.getUser_pwd());
			log.info("uDTO NAME : " + uDTO.getUser_name());
			
			msg = "로그인 성공";
			
			session.setAttribute("id", uDTO.getUser_id());
			session.setAttribute("name", uDTO.getUser_name());
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
