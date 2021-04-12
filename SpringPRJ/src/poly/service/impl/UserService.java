
package poly.service.impl;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.IUserMapper;
import poly.service.IUserService;
import poly.util.CmmUtil;

@Service("UserService")
public class UserService implements IUserService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserMapper")
	private IUserMapper userMapper;
	
	 @Override
	 public int InsertUserInfo(UserDTO pDTO)throws Exception {
		 
		 log.info(this.getClass().getName() + " .InsertUserInfo Start!");
		 
		 // 회원가입 성공 : 1, 중복으로 인한 취소 : 2, 기타에러 발생 : 0
		 int res = 0; 
		 
		 if(pDTO == null ) {
			 pDTO = new UserDTO();
		 }
		 
		 UserDTO rDTO = userMapper.getUserExists(pDTO);
		 
		 
		 if(rDTO == null ) {
			 rDTO = new UserDTO();
		 }
		 
		if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
			res = 2;
		}else { 
			int success = userMapper.InsertUserInfo(pDTO);
			
			if(success > 0) {
				res = 1;
			}else {
				res = 0;
			}
		}

		 log.info(this.getClass().getName() + " .InsertUserInfo End !");
		return res ; 
		
		
	 }
	 
	 public int getUserLoginCheck(UserDTO pDTO) throws Exception{
		 
		 
		 // 로그인 성공 1, 실패 0
		 int res = 0;
		 
		 UserDTO rDTO = userMapper.getUserLoginCheck(pDTO);
		 
		 if(rDTO == null) {
			 rDTO = new UserDTO();
		 }
		 
		 if(CmmUtil.nvl(rDTO.getUser_id()).length() > 0) {
			 res = 1;
		 }
		 
		 return res;
	 }

}
