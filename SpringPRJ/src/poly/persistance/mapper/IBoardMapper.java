package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {

	List<NoticeDTO> getBoardList();

	NoticeDTO getPostDetail();

	int getDeletePost();

	int getUpdatePost();


}
