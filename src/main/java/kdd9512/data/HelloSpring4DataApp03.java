package kdd9512.data;

import kdd9512.data.service.MemberService03;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring4DataApp03 {
    // mybatis 를 이용한 프로젝트
    // spring JDBC API 를 좀 더 편하게 사용하기 위해
    // 개발된 퍼시스턴스 계층 프레임워크
    // 자바 객체와 SQL문 사이 자동 Mapping 기능 지원

    // 코드 생산성 증대 : JDBC 관련 코드를 60% 정도 줄여줌.
    // hibernate나 JPA 보다 익히기 쉬움(러닝커브 낮음)

    // mybatis 주요 컴퍼넌트
    //  SqlMapConfig.xml : 디비 접속정보 등 환경설정파일
    //  SqlSessionFactoryBuilder : 설정파일을 통해 mybatis 객체 생성
    //  SqlSessionFactory : sqlSession객체 생성
    //  SqlSession : SQL 실행 또는 트랜잭션 관리 명령 실행
    //  Mappging 파일 : SQL 문과 OR Mapping 설정.

    // mybatis.org/mybatis-3

    // 회원정보를 다루는 프로그램 : CRUD
    // App01 -> MemberService -> MemberDAO
    //              (MemberVO)

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring4data03.xml");

        MemberService03 msrv = (MemberService03) ctx.getBean("msrv03");

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
