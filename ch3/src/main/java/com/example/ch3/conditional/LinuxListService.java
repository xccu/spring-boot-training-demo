package com.example.ch3.conditional;

//linux环境下要创建的Bean类
public class LinuxListService implements ListService{

	@Override
	public String showListCmd() {
		return "ls";
	}

}
