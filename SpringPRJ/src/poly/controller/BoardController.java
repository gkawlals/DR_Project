package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.NoticeDTO;
import poly.service.IBoardService;
import poly.service.impl.BoardService;

@Controller
public class BoardController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	IBoardService BoardService;
	
	
	@RequestMapping(value = "/Notice/Notice_List.do", method=RequestMethod.GET)
	public String BoardList(ModelMap model) {

		List<NoticeDTO> rList = BoardService.getBoardList();
		// DTO의 모든것들을 불러옴 
		if (rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList", rList);
		

		log.info("BoardList 불러오기");

		for (NoticeDTO e : rList) {

			log.info("BoardList 1번 : " + e.getNotice_no());

		}
			
		rList = null;

		return "/board/BoardList";
	}
	
	
	@RequestMapping(value = "/Notice/NoticeDetail",method=RequestMethod.GET)
	public String boardDetail(HttpServletRequest request, ModelMap model) {

		log.info("boardDetail 불러오기");

		String post_no = request.getParameter("no");

		NoticeDTO pDTO = new NoticeDTO();
		// number 기준으로 불러오기 
		pDTO.setNotice_no(post_no);

		NoticeDTO rDTO = BoardService.getPostDetail(pDTO);

		if (rDTO == null) {
			model.addAttribute("msg", "존재하지 않습니다.");
			model.addAttribute("url", "/board/BoardList.do");
			return "redirect";
		}

		model.addAttribute("rDTO", rDTO);
		log.info("title : " + rDTO.getNotice_no());
		log.info("content : " + rDTO.getContent());
		return "/Notice/NoticeDetail";
	}
	
	@RequestMapping(value = "/Notice/DeleteNotice",method=RequestMethod.GET)
	public String DeletePost(HttpServletRequest request, ModelMap model) {

		log.info("DeletePost 불러오기");
		
		String notice_no = request.getParameter("notice_no");

		NoticeDTO pDTO = new NoticeDTO();
		pDTO.setNotice_no(notice_no);

		// BoardDto rDTO = BoardService.getPostDetail(pDTO);

		int res = BoardService.getDeletePost(pDTO);
		String msg = "";
		String url = "/Notice/Notice_List.do";

		if (res < 1) {
			// 실패
			msg = "삭제 실패~";
		} else {
			// 성공
			msg = "삭제 완료";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";

	}
	
	@RequestMapping(value = "/Notice/UpdateNotice",method=RequestMethod.GET)
	public String doEdit(HttpServletRequest request, ModelMap model) {

		String notice_no = request.getParameter("notice_no");
		String img_url = request.getParameter("notice");
		String post_content = request.getParameter("post_content");

		// 게시자, 게시글 제목, 게시긇 내용을 담아 서비스에 전송할 DTO객체 생성 NoticeDTO pDTO = new NoticeDTO();

		NoticeDTO pDTO = new NoticeDTO();

		pDTO.setNotice_no(notice_no);
		pDTO.setNotice(img_url);
		pDTO.setContent(post_content);

		int res = BoardService.getUpdatePost(pDTO);

		String msg = "";
		String url = "/Notice/Notice_List.do";
		if (res < 1) {
			// 실패
			msg = "수정 실패 ~";
		} else {
			// 성공
			msg = "수정 완료";
		}

		log.info("있니?" + pDTO.getContent());

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";
	}
	


}
