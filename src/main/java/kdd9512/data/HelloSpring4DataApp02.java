package kdd9512.data;

import kdd9512.data.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring4DataApp02 {
    // 스프링4 data를 이용한 프로젝트
    // 기존 JDBC API 이용시 문제점
    //  JDBC 는 데이터베이스에 접근하기 위한 자바 표준 API
    // 하지만, JDBC 표준 API 를 사용하면서 발생하는 문제는
    // 1) Connection/PreparedStatement/ResultSet 객체관리
    // 2) 복잡한 예외/SQLException 처리문제 - 원인을 찾기가 매우 힘듬
    // 3) DriverManager/JNDI 를 이용한 Connection 처리 문제

    // 스프링을 이용하는 것으로 위의 문제들의 대부분을 해결할 수 있음.

    // persistence API
    // JDBC : 자바 표준 API
    // Hibernate : ORM 기반 persistence API
    // JPA : J2EE 표준 API, hibernate 기반으로 제작.
    // myBatis : SQL Mapping 기반 persistence API.

    // 필요 라이브러리
    // spring-jdbc

    // 회원정보를 다루는 프로그램 : CRUD
    // App01 -> MemberService -> MemberDAO
    //              (MemberVO)

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring4data02.xml");

        MemberService msrv = (MemberService) ctx.getBean("msrv");

        // 회원정보 생성
        System.out.println(msrv.newMember());

        // 회원정보 조회(id, 가입일, 등급)
        System.out.println(msrv.readMember());

        // 회원정보 상세조회(id로 검색, 모든 컬럼출력)
        System.out.println(msrv.readOneMember());

        // 회원정보 수정(이름 등급 포인트)
        System.out.println(msrv.modifyMember());

        // 회원정보 삭제(이름)
        System.out.println(msrv.removeMember());


    }
}
