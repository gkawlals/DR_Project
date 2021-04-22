package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {
	
	// 회원가입 하기
	int InsertUserInfo(UserDTO pDTO) throws Exception;
	
	// 회원가입 전 중복체크하기(DB조회하기)
	UserDTO getUserExists(UserDTO pDTO) throws Exception;
	
	//로그인을위해 아이디와 비밀번호 일치하는지 확인하기
	UserDTO getUserLoginCheck(UserDTO pDTO) throws Exception;

}
