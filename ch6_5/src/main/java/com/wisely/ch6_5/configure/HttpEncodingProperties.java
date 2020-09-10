package com.wisely.ch6_5.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;

@ConfigurationProperties(prefix = "spring.http.encoding") //1.在appilcation.propertiespe配置的时候前缀是spring.http.encoding
public class HttpEncodingProperties {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8"); //2.默认编码方式UTF-8

    private Charset chaeset =  DEFAULT_CHARSET;

    private boolean force = true; //3.设置forceEncoding，默认 true

    public Charset getChaeset(){
        return this.chaeset;
    }

    public boolean isForce(){
        return this.force;
    }

    public void setFprce(boolean force){
        this.force = force;
    }
}
