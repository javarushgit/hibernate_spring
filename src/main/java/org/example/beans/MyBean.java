package org.example.beans;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myBean")
@Setter
public class MyBean {
    private String name;

    private BeanI bean;

    @Autowired
    public MyBean(@Qualifier("someClass") BeanI bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "bean=" + bean.toString() +
                '}';
    }
}



