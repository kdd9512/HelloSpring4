package kdd9512.sungjuk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * 파일명 : SungJukV12Main
 * 작성일 : 2020.12.16
 *
 * 프로그램 설명 : 성적처리프로그램 v10
 * 스프링 기반 성적처리 프로그램 작성
 * 인터페이스를 기반으로 리디자인
 * mybatis 로 JDBC 코드 간소화.
 *
 */
public class SungJukV12Main {
    public static void main(String[] args) {
//    SungJukV10Service sjsrv = new SungJukV10ServiceImpl();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("sungjuk12.xml");
        SungJukV10Service sjsrv = (SungJukV12ServiceImpl) ctx.getBean("sjsrv12");

        Scanner sc = new Scanner(System.in);
        String menu = "";

        while(true) { // 메뉴 띄우고 작업번호 입력을 반복
            ((SungJukUI)sjsrv).displayMenu();
            menu = sc.nextLine();

            switch(menu) {
                case "1": sjsrv.newSungJuk(); break;
                case "2": sjsrv.readSungJuk(); break;
                case "3": sjsrv.readOneSungJuk(); break;
                case "4": sjsrv.modifySungJuk(); break;
                case "5": sjsrv.removeSungJuk(); break;
                case "0": System.exit(0); break;
                default:
                    System.out.println("잘못입력!!");
            }
        }
    }
}
// 기존 DAO/Service 부분을 이름에 Impl 추가하여 리팩토링
// DAO/Service 인터페이스 생성. 이 인터페이스에서는 display와 compute는 취급하지 않는다.
// 계산과 디스플레이를 위한 새 인터페이스 SungJukUI 를 생성. display와 compute는 여기서 취급.
// JDBC 설정. 주소갱신 및 아이디/비밀번호 확인. 주소는 DB접속 후 URL에서 확인 가능.
// resource 부분에 xml 추가.  <context:component-scan base-package="kdd9512.sungjuk" /> 으로 context 경로 잡아줌.
// DAOImpl 와 ServiceImpl 에 어노테이션 추가.
// 메인에  ApplicationContext ctx = new ClassPathXmlApplicationContext("sungjuk.xml");
//        SungJukV10Service sjsrv = (SungJukV10ServiceImpl) ctx.getBean("sjsrv"); 를 추가.
// 구동.


