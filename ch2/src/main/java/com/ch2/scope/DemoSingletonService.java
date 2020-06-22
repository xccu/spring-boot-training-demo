package com.ch2.scope;

import org.springframework.stereotype.Service;

@Service //默认为Singleton单例，只创建一个实例 相当于@Scope("singleton")
public class DemoSingletonService {

}
