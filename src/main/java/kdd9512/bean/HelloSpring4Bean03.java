package kdd9512.bean;

public class HelloSpring4Bean03 {

    // 다양한 언어로 인사말을 출력하는 메서드.
    public void sayHelloKR(String msg) {
        System.out.println("안녕하세요, " + msg);
    }
    public void sayHelloEN(String msg) {
        System.out.println("Hello, " + msg);
    }
    public void sayHelloJP(String msg) {
        System.out.println("こんちゃーす, " + msg);
    }

}
