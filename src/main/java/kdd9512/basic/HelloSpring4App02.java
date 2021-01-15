package kdd9512.basic;

import kdd9512.bean.HelloSpring4Bean02;

public class HelloSpring4App02 {

    // 두 번째 사례
    // 외부 클래스를 통해 인삿말을 출력하는 기능 구현
    // 인삿말을 출력하려면 외부 클래스를 객체화한 뒤
    // sayHello 메서드 호출

    // 한편, HelloSpring4App02를 실행하려면
    // HelloSpring4App02라는 클래스가 있어야 함
    // 즉, 클래스간의 의존성이 생김
    // 의존성이 커짐으로서 발생하는 부수적인 단점은
    // 코드변경시 그것과 연관되는 다른 클래스에도 영향을 미침.
    // 클래스를 호출할 때 항상 그 클래스가 품고있는 조건에 맞출 수 있을것이라는 보장이 없다.

    // 해결 : 인터페이스를 도입해서 객체간 의존성을 낮춤.

    public static void main(String[] args) {
        HelloSpring4Bean02 bean = new HelloSpring4Bean02();
        bean.sayHello("World!");
    }
}
