package kdd9512.data.dao;

import kdd9512.data.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("mdao03")
public class MemberDAO03 {

    @Autowired
    private SqlSession sqlSession;
    // mybatis 를 사용하기 위해
    // sqlSession 객체를 MemberDAO03 에 DI 함.

    public int insertMember(MemberVO mvo) {
        return sqlSession.insert("member.insertMember",mvo);
    }

    public int updateMember(MemberVO mvo) {

        return sqlSession.update("member.updateMember", mvo);
    }

    public int deleteMember(String name) {
        String sql = " delete from member where name=? ";
//        Object[] params = new Object[]{name};
        return sqlSession.delete("member.deleteMember", name);
    }

    // select/select all 문 이용시 jdbcTemplate.query 메서드를 이용.
    public List<MemberVO> selectMember() {
        return sqlSession.selectList("member.selectList");

    }

    // select one 문 실행시 jdbcTemplate.queryForObject 메서드를 이용.
    public MemberVO selectOneMember(String userid) {

        return sqlSession.selectOne("member.selectOneList",userid);
    }

}
