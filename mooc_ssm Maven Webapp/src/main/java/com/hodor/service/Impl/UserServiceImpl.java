package com.hodor.service.Impl;
import java.util.List;  

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  
  
import com.hodor.dao.IUserDao;  
import com.hodor.dto.User;  
import com.hodor.service.IUserService;  
  
@Service("IUserService")  
public class UserServiceImpl implements IUserService {  
	@Resource
	IUserDao Mapper;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		User user = Mapper.selectByName(username);
		if(user != null){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}
	
  
}  
