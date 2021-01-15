package kdd9512.basic;

import kdd9512.bean.*; // bean 파일의 내용을 싹다 쓸어옴(import).

public class HelloSpring4App04 {
    // 네 번째 사례
    // 인사말을 조선말, 미국말, 왜말로 출력하도록 기능 개선.
    // 인터페이스를 도입

    // 이로 인해서 확장성이 높고 유연한 코드를 작성할 수 있음.
    // 또한, 객체 간 tightly coupled 도 피할 수 있음
    // 객체간 의존성을 완화할 수 있음.

    // 하지만, new 연산자로 객체를 생성하는 코드가 노출
    // 다시말해, HelloSpring4Bean04는
    // HelloSpring4Bean04KR, HelloSpring4Bean04EN,
    // HelloSpring4Bean04JP 에 의존적이라는 의미임.

    // 해결 : factory 패턴을 이용하여
    // 객체 생성을 전담하는 클래스를 만들어
    // 객체 생성과정을 캡슐화함.


    public static void main(String[] args) {
        HelloSpring4Bean04 bean = new HelloSpring4Bean04KR();
        bean.sayHello("스프링4");

        bean = new HelloSpring4Bean04EN();
        bean.sayHello("Spring4");

        bean = new HelloSpring4Bean04JP();
        bean.sayHello("スプリング4");

//        tightly coupled 일 경우 이하처럼 하나하나 다 써줘야 한다.

//        HelloSpring4Bean04KR bean = new HelloSpring4Bean04KR();
//        bean.sayHello("스프링4");
//
//        HelloSpring4Bean04EN bean = new HelloSpring4Bean04EN();
//        bean.sayHello("Spring4");
//
//        HelloSpring4Bean04JP bean = new HelloSpring4Bean04JP();
//        bean.sayHello("スプリング4");

    }
}
