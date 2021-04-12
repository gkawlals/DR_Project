package poly.service;

import poly.dto.UserDTO;

public interface IUserService {

	int InsertUserInfo(UserDTO pDTO) throws Exception;
	
	int getUserLoginCheck(UserDTO pDTO) throws Exception;

}
