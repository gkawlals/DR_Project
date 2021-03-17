package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface IBoardService {

	int insertPost(NoticeDTO pDTO);
	
	List<NoticeDTO> getBoardList();
	
	int getDeletePost(NoticeDTO pDTO);

	int getUpdatePost(NoticeDTO pDTO);

	NoticeDTO getPostDetail(NoticeDTO pDTO);
	
}