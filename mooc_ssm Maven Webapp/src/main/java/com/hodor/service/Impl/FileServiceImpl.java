package com.hodor.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hodor.dao.IFileDao;
import com.hodor.dto.ClassFile;
import com.hodor.service.IFileService;

@Service("IFileService")
public class FileServiceImpl implements IFileService{

	@Resource
	IFileDao mapper;

	@Override
	public List<ClassFile> getFileByClassname(String classname) {
		// TODO Auto-generated method stub
		return mapper.selectByClassname(classname);
	}

	@Override
	public void insertintoFile(String classname, String filename) {
		// TODO Auto-generated method stub
		mapper.insertintoFile(classname, filename);
		
	}
	

	
}
