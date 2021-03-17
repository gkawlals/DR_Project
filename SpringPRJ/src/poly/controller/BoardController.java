package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.NoticeDTO;
import poly.service.IBoardService;
import poly.service.impl.BoardService;

@Controller("BoardController")
public class BoardController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	IBoardService BoarService;
	
	@RequestMapping(value = "/Notice/Notice_List.do")
	public String BoardList(ModelMap model) {

		List<NoticeDTO> rList = BoardService.getBoardList();

		if (rList == null) {
			rList = new ArrayList<>();
		}

		model.addAttribute("rList", rList);

		log.info("BoardList 불러오기");

		for (NoticeDTO e : rList) {

			log.info("BoardList 1번 : " + e.getNotice_no());

		}

		return "/board/BoardList";
	}
	
	@RequestMapping(value = "/Notice/NoticeDetail")
	public String boardDetail(HttpServletRequest request, ModelMap model) {

		log.info("boardDetail 불러오기");

		String post_no = request.getParameter("no");

		NoticeDTO pDTO = new NoticeDTO();
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
	
	@RequestMapping(value = "/board/DeletePost")
	public String DeletePost(HttpServletRequest request, ModelMap model) {

		log.info("DeletePost 불러오기");

		String post_no = request.getParameter("no");

		NoticeDTO pDTO = new NoticeDTO();
		pDTO.setNotice_no(post_no);

		// BoardDto rDTO = BoardService.getPostDetail(pDTO);

		int res = BoardService.getDeletePost(pDTO)
		String msg = "";
		String url = "/board/BoardList.do";

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
	
	@RequestMapping(value = "/board/doEdit")
	public String doEdit(HttpServletRequest request, ModelMap model) {

		String post_no = request.getParameter("post_no");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");

		// 게시자, 게시글 제목, 게시긇 내용을 담아 서비스에 전송할 DTO객체 생성 BoardDto pDTO = new BoardDto();

		NoticeDTO pDTO = new NoticeDTO();

		pDTO.setNotice_no(post_no);
		pDTO.setContent(post_content);

		int res = BoardService.getUpdatePost(pDTO);

		String msg = "";
		String url = "/board/BoardList.do";
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