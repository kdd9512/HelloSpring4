package kdd9512.basic;

public class HelloSpring4App01 {
    // 첫 번째 사례
    // 간단한 인삿말을 출력하는 프로그램 작성
    // 메세지를 출력하는 sayHello메서드를 만들어 호출
    // 단, sayHello 호출하려면 HelloSpring4App01에 대한 객체가 먼저 만들어져 있어야.

    // 인사말을 출력하는 메서드가 현재 클래스에 있기 때문에
    // 프로그램 확장성 측면에서 봤을 때 제약이 존재한다.
    // 즉, 유지보수/업무분담의 어려움이 발생하므로
    // 인사말 출력기능만을 담당하는 별도의 클래스 작성.

    public static void main(String[] args) { // 2b

//        System.out.println("Hell,world!"); // 1

        HelloSpring4App01 app = new HelloSpring4App01(); // sayHello 받아올 객체 app을 새로 생성.
        app.sayHello(" MotherFucker!");
    }

    private void sayHello(String msg){ // 2a
        System.out.println("Hello," + msg);
    }
} // 실무에서는 이 private 부분을 따로 빼서 새로운 클래스에 담는다.
