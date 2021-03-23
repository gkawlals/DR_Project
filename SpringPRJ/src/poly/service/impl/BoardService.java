package poly.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;
import poly.util.CmmUtil;

@Service("BoardService")
public class BoardService implements IBoardService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
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
	
	@Override
	public NoticeDTO getImage(NoticeDTO pDTO) throws Exception{
		
		log.info(this.getClass().getName()+" .getImage Start!!");
		
		File imageFile = new File(CmmUtil.nvl(pDTO.getNotice() + "//" + 
		CmmUtil.nvl(pDTO.getContent())));
		
		log.info(this.getClass().getName()+" .getImage End!!");
		
		return pDTO;
	}

}
