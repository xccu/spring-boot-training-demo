package com.example.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

//配置类
@Configuration
public class ConditionConifg {
	@Bean
    @Conditional(WindowsCondition.class) //1.通过@Conditional注解，符合windows条件则实例化WindowsListService
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) //2.通过@Conditional注解，符合linux条件则实例化LinuxListService
    public ListService linuxListService() {
        return new LinuxListService();
    }

}
