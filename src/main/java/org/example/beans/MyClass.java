package org.example.beans;

import com.mysql.cj.log.Log;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@NoArgsConstructor

public class MyClass implements BeanI, InitializingBean, DisposableBean {


    public MyClass(String name) {
        this.name = name;
        System.out.println("const");
    }

    @PreDestroy
    private void destory() {
        System.out.println("Destroy method");
    }


    @PostConstruct
    private void init() {
        System.out.println("Init method");
    }
    private String name;

    @Override
    public String toString() {
        return "MyClass{HAY}";
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
