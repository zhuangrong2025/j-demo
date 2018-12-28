package com.annotation_demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by user on 2018/12/28.
 */
public class ContextLoaderTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(ParentConfig.class);
        Car car = (Car) cxt.getBean("Toyota");
        car.print();
        Car car1 = (Car) cxt.getBean("BMW");
        car1.print();
    }

}
