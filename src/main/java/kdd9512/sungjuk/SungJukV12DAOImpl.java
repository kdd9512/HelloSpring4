package kdd9512.sungjuk;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("sjdao12")
public class SungJukV12DAOImpl implements SungJukV12DAO {

    @Autowired
    private SqlSession sqlSession;


    // 넘겨받은 성적데이터를 sungjuk테이블에 저장
    public String insertSungJuk(SungJukVO sj) {
        String result = "성적데이터 처리 중 오류";

        int cnt = sqlSession.insert("sungjuk.insertSungJuk", sj);
        // 이 값이 0보다 큰지 아닌지를 따진다.
        if (cnt > 0) {
            result = "성적데이터 입력 완료";
        }
        return result;
    }

    // 번호,이름,국어,영어,수학,등록일을 조회하고
    // 그 결과들을 ArrayList에 담아서 넘김
    public List<Object> selectSungJuk() {
        return sqlSession.selectList("sungjuk.selectSungJuk");
    }

    // 성적번호로 성적데이터를 조회하고
    // 그 결과를 SungJukVO에 담아서 넘김
    public SungJukVO selectOneSungJuk(String sjno) {
        return sqlSession.selectOne("sungjuk.selectOneSungJuk", sjno);
    }

    // 수정할 성적데이터를 매개변수로 넘겨주면
    // sungjuk테이블에서 해당 데이터를 수정함
    public String updateSungJuk(SungJukVO sj) {
        String result = "성적데이터 수정 중 오류";

        int cnt = sqlSession.insert("sungjuk.updateSungJuk", sj);
        // 이 값이 0보다 큰지 아닌지를 따진다.
        if (cnt > 0) {
            result = "성적데이터 수정 완료";
        }
        return result;
    }

    // 삭제할 성적번호를 매개변수로 넘겨주면
    // sungjuk테이블에서 해당 데이터를 삭제함
    public String deleteSungJuk(int sjno) {
        String result = "성적데이터 삭제 중 오류";

        int cnt = sqlSession.insert("sungjuk.deleteSungJuk", sjno);
        // 이 값이 0보다 큰지 아닌지를 따진다.
        if (cnt > 0) {
            result = "성적데이터 삭제 완료";
        }
        return result;
    }
}
