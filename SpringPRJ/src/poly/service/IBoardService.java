package poly.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import poly.dto.NoticeDTO;

public interface IBoardService {

	
	List<NoticeDTO> getBoardList();

	NoticeDTO getPostDetail(NoticeDTO pDTO);

	int getDeletePost(NoticeDTO pDTO);

	int getUpdatePost(NoticeDTO pDTO);

	NoticeDTO getImage(NoticeDTO pDTO, HttpSession session) throws Exception;



}
