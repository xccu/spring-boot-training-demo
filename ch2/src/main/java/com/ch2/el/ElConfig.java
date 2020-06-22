package com.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.ch2.el")
@PropertySource("classpath:/com/ch2/el/test.properties")//7.注入配置文件
public class ElConfig {

	//1.注入普通字符串
	@Value("I Love You!")
    private String normal;

	//2.注入操作系统属性
	@Value("#{systemProperties['os.name']}")
	private String osName;

	//3.注入表达式结果
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

	//4.注入其他Bean的属性
	@Value("#{demoService.another}")
	private String fromAnother;

	//5.注入文件资源
	@Value("classpath:com/ch2/el/test.txt")
	private Resource testFile;

	//6.网注入址资源
	@Value("http://www.baidu.com")
	private Resource testUrl;

	//7.注入配置文件属性
	@Value("${book.name}")
	private String bookName;

	//7.注入配置文件属性
	@Autowired
	private Environment environment;

	//7.注入配置文件属性
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

	//输出属性值
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
