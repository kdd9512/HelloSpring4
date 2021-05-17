package kdd9512.sungjuk;

import java.util.List;

public interface SungJukV12DAO {
    String insertSungJuk(SungJukVO sj);
    List<Object> selectSungJuk();
    SungJukVO selectOneSungJuk(String sjno);
    String updateSungJuk(SungJukVO sj);
    String deleteSungJuk(int sjno);
}
