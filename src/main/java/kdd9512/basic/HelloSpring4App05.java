package kdd9512.basic;

import kdd9512.bean.*;

public class HelloSpring4App05 {
    // 다섯 번째 사례
    // factory 패턴을 이용해서 객체생성을 캡슐화함
    // 한편, 매개변수를 이용해서 생성할 객체를 취사선택.

    // 단, 객체생성을 팩토리 패턴으로 구현해야 하기에
    // 개발자가 신경써야 할 부분이 추가됌.

    // 만들어놓으면 편하긴한데, 실무에서 비즈니스 로직코드 작성하는것도 힘든 와중에
    // 객체생성관련 클래스 따로 작성하는게 상당한 고역임. 즉, 일거리가 늘어남.

    // 어떻게 개선하나?
    // --> 객체생성부분은 외부의 힘을 빌리는 것으로 해결가능.
    // IoC 컨테이너가 객체를 생성하고 그것을 주입 inject 받음.


    public static void main(String[] args) {
        HelloSpring4Bean05Factory.create("kr").sayHello("스프링4");
        HelloSpring4Bean05Factory.create("en").sayHello("Spring4");
        HelloSpring4Bean05Factory.create("jp").sayHello("スプリング4");

        // 팩토리이름.create(호출코드).메서드명(조건에 맞는 양식);
        // 호출코드의 경우 type.equalsIgnoreCase("kr") 이런식으로 대소문자 구분없이( type.equalsIgnoreCase("호출코드") ) 어떤 문자를 입력하면 호출할 수 있게 해놨다.

    }
}
