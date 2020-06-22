package com.example.domain;

public class DemoObj {
	private Long id;
	private String name;

	//1.jackson对对象和json做转换时一定需要空构造函数
	public DemoObj() {
		super();
	}
	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
