package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="MainPage")
	public String Index() {
		log.info(this.getClass());
		
		return "/MainPage";
	}
	
	@RequestMapping(value="loginPage")
	public String loginPage() {
		log.info(this.getClass());
		
		return "/loginPage";
	}
	
	@RequestMapping(value="Filetest")
			
}

