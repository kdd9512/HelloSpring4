package kdd9512.basic;

import kdd9512.bean.HelloSpring4Bean04;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloSpring4App06 {
    // 스프링프레임워크를 사용하는 첫 번째 사례
    // 이전 예제에서는  factory를 이용하여
    // 객체를 생성하는 코드를 작성했음.
    // 스프링 프레임워크는 이 과정이 필요없음.

    // 스프링 프레임워크
    // DI, IoC, AOP 를 적용한 콘솔/GUI/ 웹 응용프로그램 개발에
    // 사용하는 오픈소스 프레임워크
    // 복잡한 절차를 요구하고 비용이 많이 드는 EJB에 비해
    // 사용이 간단하고, 무료 서블릿 컨테이너에서도 무난히 실행됌.

    // 스프링 프레임워크를 이용한 개발의 필수조건
    // --> 인터페이스 기반 설계일 것.

    // 라이브러리
    // spring-beans (repo.spring.io)
    // spring-core
    // commons-logging (commons.apache.org)

    // 실행원리
    // 예제에서 보듯 객체 생성시 new 연산자를 사용하지 않고
    // 스프링이 대신 객체를 생성하고 프로그램에서는 DI 를 통해 사용하였음.
    // 1. bean.xml에 스프링 컨테이너가 미리 생성해둬야 할 객체와 이름을 정의해 둠.
    // 2. 프로그램이 시작되면 bean06.xml 에 작성한 객체정보를 스프링 컨테이너가 읽어서 객체를 만들어 둠
    // 3. BeanFactory 에서 getBean 메서드로 해당객체를 가져와서 HelloSpring4Bean04 타입의 변수에 주입함.
    // 4. 주입된 변수를 통해  sayHello 메서드 호출하면 실행

    // 스프링 컨테이너
    // 스프링 프레임워크에서 제공하는 컨테이너는 크게 두 가지가 존재.
    // BeanFactory : DI에 대한 기본적인 지원을 제공하는 가장 단순한 컨테이너
    // ApplicationContext : 빈팩토리를 확장해 프로퍼티 파일에 텍스트 메시지를 읽고
    // 해당 이벤트 리스너에 대한 애플리케이션 이벤트 발행 같은 애플리케이션 프레임워크 서비스를 제공하는 컨테이너


    public static void main(String[] args) {
        // 스프링 컨테이너의 관리를 받는 객체들이 정의된 설정파일 읽기.
        BeanFactory bf = new XmlBeanFactory(
                new FileSystemResource("src/main/java/bean06.xml")); // 이 경로에 xml파일이 있어야 한다.

        // 스프링 컨테이너를 통해 지정한 객체를 주입받음.
        HelloSpring4Bean04 bean = (HelloSpring4Bean04) bf.getBean("kr");
        bean.sayHello("스프링4");

        bean = (HelloSpring4Bean04) bf.getBean("en");
        bean.sayHello("Spring4");

        bean = (HelloSpring4Bean04) bf.getBean("jp");
        bean.sayHello("スプリング4");



    }
}
