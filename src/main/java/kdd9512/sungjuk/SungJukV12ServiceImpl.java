package kdd9512.sungjuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service("sjsrv12")
public class SungJukV12ServiceImpl implements SungJukV10Service, SungJukUI{

    @Autowired
//  이하 기본생성자를 대신하는  Autowired
    private SungJukV10DAO sjdao12; // 변수 초기화.


    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("성적 처리프로그램 v12\n")
                .append("-------------------\n")
                .append("1. 성적 데이터 입력\n")
                .append("2. 성적 데이터 조회\n")
                .append("3. 성적 데이터 상세조회\n")
                .append("4. 성적 데이터 수정\n")
                .append("5. 성적 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? ");
        System.out.print(sb);
    }

    public void newSungJuk() {
        Scanner sc = new Scanner(System.in);
        String name;
        int kor, eng, mat;

        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
        System.out.print("국어를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학을 입력하세요 : ");
        mat = sc.nextInt();

        SungJukVO sj = new SungJukVO(name, kor, eng, mat,
                0,0,' ');

        computeSungJuk(sj);


        String result = sjdao12.insertSungJuk(sj);
        System.out.println(result);

    }

    public void computeSungJuk(SungJukVO sj) {
        sj.settot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setMean( (double)sj.gettot() / 3 );
        switch((int)(sj.getMean() / 10)) {
            case 10:
            case 9: sj.setGrd('수'); break;
            case 8: sj.setGrd('우'); break;
            case 7: sj.setGrd('미'); break;
            case 6: sj.setGrd('양'); break;
            default: sj.setGrd('가');
        } // switch
    }

    // 조회할 성적데이터를 DAO로부터 넘겨받아 출력
    public void readSungJuk() {
        StringBuilder sb = new StringBuilder();
        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 등록일:%s\n";
        ArrayList<SungJukVO> sjvo = sjdao12.selectSungJuk();
        for(SungJukVO sj : sjvo) {
           sb.append(String.format( fmt, sj.getSjno(),
                sj.getName(),sj.getKor(),sj.getEng(),sj.getMat(),
                sj.getRegdate().substring(0,10)));
        }

        System.out.println(sb.toString());
    }

    public void readOneSungJuk() {
        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d\n" +
                    "총점:%d, 평균:%.1f, 학점:%s, 등록일:%s\n";

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 성적번호는? ");
        String sjno = sc.nextLine();

        SungJukVO sj = sjdao12.selectOneSungJuk(sjno);

        String result = String.format(fmt, sj.getSjno(),
                sj.getName(), sj.getKor(), sj.getEng(),
                sj.getMat(), sj.gettot(), sj.getMean(),
                sj.getGrd(), sj.getRegdate());

        System.out.println(result);
    }

    public void modifySungJuk() {
        Scanner sc = new Scanner(System.in);
        SungJukVO sj = new SungJukVO();

        System.out.print("수정할 성적번호는? ");
        sj.setSjno( sc.nextInt() );
        System.out.print("수정할 국어점수는? ");
        sj.setKor( sc.nextInt() );
        System.out.print("수정할 영어점수는? ");
        sj.setEng( sc.nextInt() );
        System.out.print("수정할 수학점수는? ");
        sj.setMat( sc.nextInt() );

        computeSungJuk(sj);

        String result = sjdao12.updateSungJuk(sj);
        System.out.println(result);
    }

    public void removeSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 성적번호는? ");
        int sjno = sc.nextInt();

        String result = sjdao12.deleteSungJuk(sjno);
        System.out.println(result);
    }
}
