package com.example.ch6_2_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Ch622Application {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

	@RequestMapping("/")
	String index() {

		return "book name is:"+bookName+" and book author is:" + bookAuthor;
	}
	public static void main(String[] args) { //2.main方法
		SpringApplication.run(Ch622Application.class, args);
	}
}
