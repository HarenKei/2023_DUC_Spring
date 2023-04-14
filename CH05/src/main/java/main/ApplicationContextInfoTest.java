package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppContext.class);

    void findAllBean() {
        String[] beanNames = ac.getBeanDefinitionNames();

        for(String beanDefinitionName : beanNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }

    public static void main(String[] args) {
        ApplicationContextInfoTest tst = new ApplicationContextInfoTest();

        tst.findAllBean();
    }

}
