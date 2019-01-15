package com.hodor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hodor.dto.ClassFile;

public interface IFileDao {
	public List<ClassFile> selectByClassname(String classname);
	public void insertintoFile(@Param("classname")String classname,@Param("filename")String filename);
}
