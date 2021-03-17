package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {

	int insertPost(NoticeDTO pDTO);

	List<NoticeDTO> getBoardList();

	int getDeletePost(NoticeDTO pDTO);

	int getUpdatePost(NoticeDTO pDTO);

	NoticeDTO getPostDetail(NoticeDTO pDTO);

}