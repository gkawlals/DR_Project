package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface IBoardService {

	List<NoticeDTO> getBoardList();

	NoticeDTO getPostDetail(NoticeDTO pDTO);

	int getDeletePost(NoticeDTO pDTO);

	int getUpdatePost(NoticeDTO pDTO);




}
