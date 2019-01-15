package com.hodor.service;

import java.util.List;
import com.hodor.dto.Class;
public interface IClassService {

	public List<Class> getAllClass();
	public void addClass(String classname);
}
