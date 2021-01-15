package kdd9512.bean.anno;

import kdd9512.bean.HelloSpring4Bean04;
import org.springframework.stereotype.Component;

@Component("jp")
public class HelloSpring4Bean04JP implements HelloSpring4Bean04 {

    // 다양한 언어로 인사말을 출력하는 메서드.
    @Override
    public void sayHello(String msg) {
        System.out.println("こんにちは, " + msg);
    }
}
