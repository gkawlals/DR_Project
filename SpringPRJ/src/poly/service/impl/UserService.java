package poly.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.MailDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.IUserMapper;
import poly.service.IMailService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Service("UserService")
public class UserService implements IUserService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserMapper")
	private IUserMapper userMapper;

	@Resource(name="MailService")
	private IMailService MailService;
	
	@Override
	public UserDTO getLoginInfo(UserDTO uDTO) {
		
		return userMapper.getLoginInfo(uDTO);
	}

	@Override
	public int SignUp(UserDTO uDTO) throws InvalidKeyException, 
	UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, 
	InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
				int res = 0;
				
				// 들어오는 결과값이 없을때 새로운것을 메모리로 올린다. 
				if(uDTO == null) {
					uDTO = new UserDTO();
				}
				
				//회원가입 중복 방지를 위한 DB조회
				UserDTO rDTO = userMapper.getUserExists(uDTO);
				
				//mapper에서 값이 정상적으로 못 넘어오는 경우 대비하기위해 사용
				if(rDTO == null) {
					rDTO = new UserDTO();
				}
				
				// 중복된 회원가입이 있는겨우 결과값을 2로 변경하고 더이상 진행되지 않게 한다
				if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
					log.info("중복 아이디 입니다.");
					res = 2;
				}else { 
					int success = userMapper.SignUp(uDTO);
					
					if(success > 0) {
						res = 1;
						
						MailDTO mDto = new MailDTO();
						
						mDto.setToMail(EncryptUtil.decAES128CBC(CmmUtil.nvl(uDTO.getEmail())));
						
						mDto.setTitle("회원가입을축하드립니다.");
						
						mDto.setContent(CmmUtil.nvl(uDTO.getName())+"님의 회원가입을 축하드립니다.");
						
						MailService.sendMailResult(mDto);
						
					}else {
						res = 0;
					}
				}
				return res;
	}


	
}