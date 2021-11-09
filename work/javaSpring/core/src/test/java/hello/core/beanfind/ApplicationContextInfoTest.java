package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// junit5 부터 퍼블릭 설정 안해도 됨

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefitionNames = ac.getBeanDefinitionNames();
        for (String beanDefitionName : beanDefitionNames) {
            Object bean = ac.getBean(beanDefitionName);
            System.out.println("name = " + beanDefitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefitionNames = ac.getBeanDefinitionNames();
        for (String beanDefitionName : beanDefitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefitionName);

            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefitionName);
                System.out.println("name = " + beanDefitionName + " object = " + bean);
            }
        }
    }
}
