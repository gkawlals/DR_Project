package poly.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.NoticeDTO;
import poly.service.IBoardService;
import poly.service.IUserService;
import poly.util.DateUtil;
import poly.util.FileUtil;


@Controller
public class MainController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	final private String FILE_UPLOAD_SAVE_PATH = "/imgs";
	
	@Resource(name="BoardService")
	private IBoardService BoardService;
	
	@Resource(name="UserService")
	private IUserService userService;
	
	@RequestMapping(value="MainPage")
	public String Index() {
		log.info(this.getClass());
		
		return "/MainPage";
	}
	
	@RequestMapping(value="Filetest")
	public String Filetest() {
		
		return "/Filetest";
	}
	
	@RequestMapping(value="FileUpload")
	public String FileUpload(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, @RequestParam(value="fileUpload") MultipartFile mf) 
	throws Exception {
		log.info(this.getClass().getName() + " FileUpload Start !");
		
		// 업로드하는 실제 파일명 
		// 다운로드 기능 구현시, 임의로 파일명을 원래대로 만들어주기 위한 목적 
		String OriginFileName = mf.getOriginalFilename();
		
		// 파일확장자 가져오기 
		String ext = OriginFileName.substring(OriginFileName.lastIndexOf(".") + 1, OriginFileName.length()).toString();
		
		if(ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {
			
			// 웹서버에 저장되는 파일이름 
			// 업로드하는 파일 이름에 한글, 특수문자들이 저장될 수 있기 때문에 강제로 영어와 숫자로 구성된 파일명으로 변경해서 저장 
			// 리눅스나 유닉스등 운영체제는 다국어 지원에 취약하기 때문이다.
			String saveFileName = DateUtil.getDateTime("24hhmmss") + "." + ext;
			
			// 웹서버에 업로드한 파일 저장하는 물리적 경로 
			String  saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);
			
			String fullFileInfo = saveFilePath + "/" +saveFileName;
			
			// 정상적으로 파일을 업로드했는지 확인하기
			log.info("ext : "+ext );
			log.info("saveFileName : "+ saveFileName );
			log.info("saveFilePath : "+ saveFilePath );
			log.info("fullFileInfo : "+ fullFileInfo );
			
			// 업로드 되는 파일을 서버에 저장 
			mf.transferTo(new File(fullFileInfo));
			
			NoticeDTO pDTO = new NoticeDTO();
			
			pDTO.setContent(saveFileName); // file 경로 
			pDTO.setNotice(saveFilePath); // file 이름 
			
			NoticeDTO rDTO = BoardService.getImage(pDTO, null);
			
			if(rDTO == null) {
				rDTO = new NoticeDTO();
			}
			
			rDTO = null;
			pDTO = null;
			
		}
		log.info(this.getClass().getName() + " FileUpload End !");
		return "FileTest";
	}
			
}

