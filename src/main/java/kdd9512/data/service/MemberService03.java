package kdd9512.data.service;

import kdd9512.data.dao.MemberDAO03;
import kdd9512.data.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("msrv03")

public class MemberService03 {

    @Autowired
    private MemberDAO03 mdao03;

    public String newMember() {
        String result = "회원정보 생성 실패";
        MemberVO mvo = new MemberVO();
        mvo.setUserid("spring4");
        mvo.setName("asdf");
        mvo.setPasswd("asdf1234");
        mvo.setGrade("Gold");
        mvo.setPoints("1000");
        mvo.setRegdate("2021-01-18 10:55:00");

        if (mdao03.insertMember(mvo) > 0) {
            result = "회원정보 생성 성공";

            return result;
        }

        return result;
    }

    // 회원정보 수정 (이름, 등급, 포인트)
    public String modifyMember() {
        String result = "회원정보 수정 실패";
        MemberVO mvo = new MemberVO();
        mvo.setUserid("spring4");
        mvo.setName("김똘칠");
        mvo.setGrade("Silver");
        mvo.setPoints("0");

        if (mdao03.updateMember(mvo) > 0)
            result = "회원정보 수정 성공";

        return result;
    }

    // 회원정보 삭제(이름)
    public String removeMember() {
        String result = "회원정보 삭제 실패";
//        MemberVO mvo = new MemberVO();
//        mvo.setName("김똘칠");
        String name = "김똘칠";
        if (mdao03.deleteMember(name) > 0) {
            result = "회원정보 삭제 성공";
        }

        return result;
    }

    public String readMember() {
        StringBuilder sb = new StringBuilder();
        String fmt = "%10s %10s %10s\n";
        List<MemberVO> mvos = mdao03.selectMember();
        for (MemberVO m : mvos) {
            sb.append(String.format(fmt,m.getUserid(),m.getGrade(),m.getRegdate()));
        }


        return sb.toString();
    }

    // 회원정보조회 id로 검색하게끔
    public String readOneMember() {
        String result = "";
        String fmt = "%8s %8s %8s %8s %8s\n";
        MemberVO mvo = mdao03.selectOneMember("spring4");
        result = String.format(fmt,mvo.getUserid(),
                mvo.getName(), mvo.getGrade(),
                mvo.getPoints(), mvo.getRegdate());

        return result;
    }
}
