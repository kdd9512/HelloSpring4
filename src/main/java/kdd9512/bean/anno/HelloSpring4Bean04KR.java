package kdd9512.bean.anno;

import kdd9512.bean.HelloSpring4Bean04;
import org.springframework.stereotype.Component;

@Component("kr")
// 이 객체의 이름을 부여.
// 원래는 xml 파일 내에서 bean을 선언하고 id를 부여한 다음 호출해서 사용했다.
public class HelloSpring4Bean04KR implements HelloSpring4Bean04 {


    // 다양한 언어로 인사말을 출력하는 메서드.
    @Override
    public void sayHello(String msg) {
        System.out.println("안녕하세요, " + msg);
    }
}
