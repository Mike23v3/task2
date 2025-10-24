package com.bioarktech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BioArk Technologies 应用程序主类
 * <p>
 * 这是应用程序的入口点，使用Spring Boot自动配置启动Web应用
 * </p>
 * 
 * @author BioArk Team
 */
@SpringBootApplication
public class BioArkApplication {

    /**
     * 应用程序主入口方法
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(BioArkApplication.class, args);
    }

}