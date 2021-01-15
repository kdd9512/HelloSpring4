package kdd9512.basic;

import kdd9512.bean.HelloSpring4Bean04;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring4App07 {
    // 스프링프레임워크를 사용하는 두 번째 사례.

    // 라이브러리
    // spring-beans (repo.spring.io)
    // spring-core
    // spring-context
    // spring-expression
    // commons-logging (commons.apache.org)

    // 스프링 컨테이너
    // 스프링 프레임워크에서 제공하는 컨테이너는 크게 두 가지가 존재.
    // BeanFactory : DI에 대한 기본적인 지원을 제공하는 가장 단순한 컨테이너
    // ApplicationContext : 빈팩토리를 확장해 프로퍼티 파일에 텍스트 메시지를 읽고 
    // 해당 이벤트 리스너에 대한 애플리케이션 이벤트 발행 같은 애플리케이션 프레임워크 서비스를 제공하는 컨테이너.


    public static void main(String[] args) {
        // 스프링 컨테이너의 관리를 받는 객체들이 정의된 설정파일 읽기.
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/bean06.xml");

        // 스프링 컨테이너를 통해 지정한 객체를 주입받음.
        HelloSpring4Bean04 bean = (HelloSpring4Bean04) ctx.getBean("kr");
        bean.sayHello("스프링4");

        bean = (HelloSpring4Bean04) ctx.getBean("en");
        bean.sayHello("Spring4");

        bean = (HelloSpring4Bean04) ctx.getBean("jp");
        bean.sayHello("スプリング4");



    }
}
