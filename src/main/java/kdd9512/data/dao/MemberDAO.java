package kdd9512.data.dao;

import kdd9512.data.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("mdao")
public class MemberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // memberDAO 에서 사용할 JdbcTemplate 객체를
    // DI 받기 위해선, @Autowired 로 선언.

    // insert, update, delete 문 실행시
    // jdbcTemplate.updata 메서드 이용
    public int insertMember(MemberVO mvo) {
        // 실행할 sql 문 정의
        String sql = "insert into member values (?,?,?,?,?,?)";

        // SQL문에 전달할 매개변수 값 선언
        Object[] params = new Object[]{
                mvo.getUserid(), mvo.getPasswd(), mvo.getName(),
                mvo.getGrade(), mvo.getPoints(), mvo.getRegdate()
        };


        // SQL 문에 전달할 매개변수 값들의 유형.

        return jdbcTemplate.update(sql, params);
    }

    public int updateMember(MemberVO mvo) {
        String sql = " update member" +
                " set name=?, grade=?, points=? " +
                " where userid=? ";
        Object[] params = new Object[]{
                mvo.getName(), mvo.getGrade(), mvo.getPoints(),
                mvo.getUserid()
        };
        return jdbcTemplate.update(sql, params);
    }

    public int deleteMember(String name) {
        String sql = " delete from member where name=? ";
//        Object[] params = new Object[]{name};
        return jdbcTemplate.update(sql, name);
    }

    // select/select all 문 이용시 jdbcTemplate.query 메서드를 이용.
    public List<MemberVO> selectMember() {
        String sql = " select userid, grade, regdate from member ";
        RowMapper<MemberVO> mapp = new MemberRowMapper();
        // 콜백 크래스 등록만 하고 호출/실행은 따로 안함.
        // 단, query 메서드가 실행하는 도중, rs.next 가 참인 경우에 한해
        // IoC컨테이너가 mapp객체의 mapRow 메서드를 호출.

        return jdbcTemplate.query(sql, mapp);

    }

    // select one 문 실행시 jdbcTemplate.queryForObject 메서드를 이용.
    public MemberVO selectOneMember(String userid) {
        String sql = " select * from member where userid=? limit 1 ";

        Object[] params = new Object[] {userid};

        RowMapper<MemberVO> mapper = new MemberOneRowMapper();

        return jdbcTemplate.queryForObject(sql,params,mapper);
    }


    // 회원정보를 출력하는 RowMapper 클래스
    private class MemberRowMapper implements RowMapper<MemberVO> {
        @Override
        public MemberVO mapRow(ResultSet rs, int num) throws SQLException {
            MemberVO mvo = new MemberVO();
                mvo.setUserid(rs.getString("userid"));
                mvo.setUserid(rs.getString("grade"));
                mvo.setUserid(rs.getString("regdate"));
            return mvo;
        }
    }

    private class MemberOneRowMapper implements RowMapper<MemberVO> {

        @Override
        public MemberVO mapRow(ResultSet rs, int num) throws SQLException {
            MemberVO mvo = new MemberVO();
            mvo.setUserid(rs.getString("userid"));
            mvo.setName(rs.getString("name"));
            mvo.setGrade(rs.getString("grade"));
            mvo.setPoints(rs.getString("points"));
            mvo.setRegdate(rs.getString("regdate"));
            return mvo;
        }
    }
}
