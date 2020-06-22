package com.example.messageconverter;

import com.example.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

//自定义HttpMessageConverter，用于处理request和response数据
//1.继承AbstractHttpMessageConverter接口来实现自定义HttpMessageConverter
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConverter() {
		//2.新建一个我们自定义的媒体类型：application/x-wisely
		super(new MediaType("application", "x-wisely",Charset.forName("UTF-8")));
	}
	
	/**
	 * 3.重写readInternal方法，处理请求的数据
	 */

	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(),

		//代码逻辑：处理由'-'隔开的数据，并转换成DemoObj对象
		Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}
	
	/**
	 * 4.支持的处理类型，表名本HttpMessageConverter只处理DemoObjec这个类型
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}
	
	/**
	 * 5.重写writeInternal处理如何输出数据到response
	 */
	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

		//代码逻辑：在输出的文本前加上'hello'
		String out = "hello:" + obj.getId() + "-"
				+ obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}
