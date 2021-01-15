package kdd9512.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EmployeeV2Main {
    public static void main(String[] args) {
//        EmployeeV2ServiceImpl empsrv = new EmployeeV2ServiceImpl();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
        EmployeeV2Service empsrv = (EmployeeV2ServiceImpl) ctx.getBean("empsrv");


        Scanner sc = new Scanner(System.in);
        String menu = " ";

        while (true) { //강제종료 전까지는 메뉴화면 띄워야 하므로.
            ((EmployeeV2UI)empsrv).displayMenu();
            // 현재 메뉴 디스플레이 인터페이스는 EmployeeV2UI 에 있기 때문에 형변환을 실시해 줘야 위치를 제대로 잡는다.
            menu = sc.nextLine();
            switch (menu) {
                case "1" : empsrv.newEmp(); break; // 신규입력
                case "2" : empsrv.readEmp(); break; // 테이블 값 인쇄
                case "3" : empsrv.readOneEmp(); break; // 테이블 내 검색
                case "4" : empsrv.modifyEmp(); break;// 테이블 값 수정 사번기준
                case "5" : empsrv.deleteEmp(); break; // 삭제 사번기준
                case "0" : System.out.println("\n시스템을 종료합니다....\n");
                System.exit(0);break;
                default : System.out.println("\n잘못 입력 하셨습니다.\n");break;
            }
        }
    }
}
