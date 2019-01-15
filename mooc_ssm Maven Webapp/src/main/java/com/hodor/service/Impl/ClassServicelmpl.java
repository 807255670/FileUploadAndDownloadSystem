package com.hodor.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hodor.dao.IClassDao;
import com.hodor.dao.IUserDao;
import com.hodor.dto.Class;
import com.hodor.service.IClassService;

@Service("IClassService")
public class ClassServicelmpl implements IClassService{
	@Resource
	IClassDao Mapper;
	@Override
	public List<Class> getAllClass() {
		// TODO Auto-generated method stub
		return Mapper.selectAll();
	}
	@Override
	public void addClass(String classname) {
		Mapper.addClassByName(classname);
		
	}
	

}
