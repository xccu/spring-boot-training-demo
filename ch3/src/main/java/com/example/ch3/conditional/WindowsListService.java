package com.example.ch3.conditional;

//windows环境下要创建的Bean类
public class WindowsListService implements ListService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
