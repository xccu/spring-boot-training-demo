package com.wisely.ch6_5.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class) //1.开启属性注入，通过@EnableConfigurationProperties声明，使用@Autowired注入
@ConditionalOnClass(CharacterEncodingFilter.class) //2.当CharacterEncodingFilter在类路径的条件下
@ConditionalOnProperty(prefix = "spring.http.encoding",value = "enabled",matchIfMissing = true) //3.当设置spring.http.encoding = enabled的条件下
public class HttpEncodingAutoConfiguation {
    @Autowired
    private HttpEncodingProperties httpEncodingProperties;//3

    @Bean //4.使用java配置的方式配置CharacterEncodingFilter
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)//5.当容器中不存在这个bean时新建bean
    public CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.httpEncodingProperties.getChaeset().name());
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        return filter;
    }
}
