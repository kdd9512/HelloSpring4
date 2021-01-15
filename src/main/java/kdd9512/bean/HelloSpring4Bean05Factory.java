package kdd9512.bean;

public class HelloSpring4Bean05Factory {

    // 인사말을 출력하는 객체를 생성하는 create 메서드 정의.
    // type 이라는 매개변수를 통해 출력할 인사말의 유형을 선택함.
    public static HelloSpring4Bean04 create(String type) {
        // 인터페이스 HelloSpring4Bean04 를 받아옴. 인터페이스 내 내용은? --> void sayHello(String msg);
        HelloSpring4Bean04 bean = null; // HelloSpring4Bean04 초기화 null.

        if (type.equalsIgnoreCase("kr"))
            // 대소문자 구분없이( type.equalsIgnoreCase("호출코드") ) 어떤 문자를 입력하면 이 명령을 호출할 수 있게
            bean = new HelloSpring4Bean04KR();
        else if (type.equalsIgnoreCase("en"))
            bean = new HelloSpring4Bean04EN();
        else if (type.equalsIgnoreCase("jp"))
            bean = new HelloSpring4Bean04JP();

        return bean;
    }
}
