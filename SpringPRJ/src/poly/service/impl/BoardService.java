package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService {
	
	@Resource(name="BoardMapper")
	private IBoardMapper BoardMapper;

	public List<NoticeDTO> getBoardList() {
		// TODO Auto-generated method stub
		return BoardMapper.getBoardList();
	}

	public NoticeDTO getPostDetail(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getPostDetail();
	}

	public int getDeletePost(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getDeletePost();
	}

	public int getUpdatePost(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getUpdatePost();
	}


}
