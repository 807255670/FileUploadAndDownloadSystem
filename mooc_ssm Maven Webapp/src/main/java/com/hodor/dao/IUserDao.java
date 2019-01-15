package com.hodor.dao;

import java.util.List;  
import java.util.Map;  
  
import com.hodor.dto.User;  
  
public interface IUserDao {  
      
   public User selectById(int id);
   public User selectByName(String username);
      
}  