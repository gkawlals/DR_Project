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
	IBoardMapper BoardMapper;

	@Override
	public int insertPost(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.insertPost(pDTO);
	}

	@Override
	public List<NoticeDTO> getBoardList() {
		// TODO Auto-generated method stub
		return BoardMapper.getBoardList();
	}

	@Override
	public int getDeletePost(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getDeletePost(pDTO);
	}

	@Override
	public int getUpdatePost(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getUpdatePost(pDTO);
	}
	

	@Override
	public NoticeDTO getPostDetail(NoticeDTO pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getPostDetail(pDTO);
	}
	

}