package com.hodor.dao;

import java.util.List;
import com.hodor.dto.Class;

public interface IClassDao {
	public Class selectByName(String classname);
	public Class selectById( int id);
	public List<Class> selectAll();
	public void addClassByName(String classname);
}
