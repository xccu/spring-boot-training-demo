package com.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//声明Scope为protoType，每次调用都会创建一个新的Bean实例
public class DemoPrototypeService {

}
