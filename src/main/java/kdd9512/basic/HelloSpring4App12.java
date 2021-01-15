package kdd9512.basic;


import kdd9512.product.ProductService02;
import kdd9512.product.anno.ProductService03Impl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring4App12 {
    // 상품 등록 프로그램 v4
    // HelloSpring4App12 -> ProductService02 -> ProductDAO02

    // Main 클래스에서 상품등록기능을 실행하기 위해
    // spring container 가 만들어 주는 객체를 이용.
    // 빈 설정대신 간단하게 어노테이션으로 DI를 함.




    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("product12.xml");

        ProductService02 ps = (ProductService03Impl) ctx.getBean("ps03");

        // ProductDAO03 pdao = new ProductDAO03Impl()
        // ps.setPdao(pdao);
        // ProductDAO03 에 대한 객체를 사용하려면
        // new 연산자로 해당 객체를 생성해야 하는데,
        // 이러한 작업을 스프링 컨테이너가 대신 처리함.
        // 단, bean.xml 에 이러한 내용이 미리 선언되어 있어야 함
        // ex) <bean id="pdao" class="kdd9512.product.ProductDAO03Impl"/>

        ps.newProduct();


    }
}
