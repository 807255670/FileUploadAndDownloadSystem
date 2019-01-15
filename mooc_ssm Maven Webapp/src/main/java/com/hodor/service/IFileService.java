package com.hodor.service;

import java.util.List;

import com.hodor.dto.ClassFile;

public interface IFileService {
	public List<ClassFile> getFileByClassname(String classname);
	public void insertintoFile(String classname,String filename);
}
