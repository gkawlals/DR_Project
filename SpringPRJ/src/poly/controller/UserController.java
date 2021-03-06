package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.util.CmmUtil;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	private IUserService userService;
	
	@RequestMapping(value="user/loginPage")
	public String loginPage() {
		log.info(this.getClass().getName() + " .user/loginPage start");
		return "user/loginPage";
	}
	
	@RequestMapping(value="user/SignUp")
	public String userIn() {
		log.info(this.getClass().getName() + " .user/userIn start !");
		return"user/SignUp";
	}
	
	@RequestMapping(value="user/LoginForm")
	public String loginForm() {
		log.info(this.getClass().getName() + " .user/loginForm start!");
		
		return "user/LoginForm";
	}
	
	@RequestMapping(value="user/FindPass")
	public String FindPass() {
		
		log.info(this.getClass().getName() + " .user/FindPass start !");
		return "user/FindPass";
	}
	
	@RequestMapping(value="user/MyPage")
	public String MyPage() {
		
		log.info(this.getClass().getName() + " .user/MyPage start !");
		return "user/MyPage";
	}
	
	@RequestMapping(value="user/getUserLoginCheck")
	public String getUserLoginCheck (HttpSession session, HttpServletRequest request, HttpServletResponse 
			response, ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + " .getUserLoginCheck start !");
		
		int res = 0; 
		
		UserDTO pDTO = null;
		
		try {
			
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
			
			
			log.info("user_id : " + user_id);
			log.info("user_pwd : " + user_pwd);
			
			pDTO = new UserDTO(); 
			
			pDTO.setUser_id(user_id);
			
			pDTO.setUser_pwd(user_pwd);
			
			res = userService.getUserLoginCheck(pDTO);
			
			if(res == 1) {
				session.setAttribute("SS_USER_ID", user_id);
			}
			
		}catch(Exception e) {
			res = 2;
			log.info(e.toString());
			e.printStackTrace();
		}finally {
			log.info(this.getClass().getName() + " .getUserLoginCheck end !");

			model.addAttribute("res",String.valueOf(res));
			
			pDTO = null;
			
		}
		
		return "user/LoginResult";
	}
	
	@RequestMapping(value="user/InsertUserInfo")
	public String InsertUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		log.info(this.getClass().getName() + " .InsertUserInfo Start ! ");
		
		String msg = "";
		
		UserDTO pDTO = null;
		
		try {
			
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
			String user_name = CmmUtil.nvl(request.getParameter("user_name"));
			String user_email = CmmUtil.nvl(request.getParameter("user_email"));
			
			log.info("user_id : " + user_id);
			log.info("user_pwd : " + user_pwd);
			log.info("user_name : " + user_name);
			log.info("user_email : " + user_email);
			
			pDTO = new UserDTO();
			
			pDTO.setUser_id(user_id);
			pDTO.setUser_pwd(user_pwd);
			pDTO.setUser_name(user_name);
			pDTO.setUser_email(user_email);
			
			int res = userService.InsertUserInfo(pDTO);
			
			if(res==1) {
				msg = "???????????????????????????. ";
			}else if(res == 2) {
				msg = "?????? ????????? ???????????????.";
			}else {
				msg = "????????? ?????? ??????????????? ??????????????????.";
			}
			
		}catch(Exception e) {
			//????????? ???????????? ??????????????? ???????????? ????????? 
			msg = "??????????????????." + e.toString();
		}finally {
			log.info(this.getClass().getName() + ".InsertUserInfo End !");
			
			//???????????? ?????? ?????? ????????? ???????????? 
			model.addAttribute("msg",msg);
			
			//???????????? ?????? ?????? ????????? ???????????? 
			model.addAttribute("pDTO",pDTO);
		}
		
		return "user/InsertUserInfo";
	}

}
