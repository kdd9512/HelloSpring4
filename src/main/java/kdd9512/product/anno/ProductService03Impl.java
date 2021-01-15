package kdd9512.product.anno;

import kdd9512.product.ProductDAO02;
import kdd9512.product.ProductService02;
import kdd9512.product.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ps03")
public class ProductService03Impl implements ProductService02 {

    @Autowired
//  이 서비스를 정상적으로 구동시키기 위해 xml 파일에서 pdao 에 대해 property를 추가했던 것 기억하는가?
//  이 @Autowired 하나만 넣어주면 그게 해결된다.
//  단, 어노테이션(@Component 이하의 변수명)과 오토와이어의 변수명은 같아야한다.

//          <bean id="ps03" class="kdd9512.product.ProductService03Impl" >-->
//  <!--        <property name="pdao" ref="pdao" />-->
//  <!--    </bean>-->

//  <!--    <bean id="pdao" class="kdd9512.product.ProductDAO03Impl"/>-->
//  이걸 service 부분과 DAO 부분에 각각 뺀거다.


    private ProductDAO02 pdao;
    // 이전 예제에서는 setter 메서드를 통해 DI 되었음.
    // 지금은 어노테이션을 선언해서 setter 메서드 정의없이 DI 받음


//    public void setPdao(ProductDAO02 pdao) {
//        this.pdao = pdao;
//    }

    // 상품등록 기능을 수행하는 메서드
    public void newProduct() {
        System.out.println("상품등록 준비중.");

        ProductVO pvo = new ProductVO();
        pvo.setPname("상품1");
        pvo.setPrice(9999);

        // 데이터가 영구히 저장되게끔 (입력받은 상품 정보에 영속성을 부여하기 위해 = persistant ), DAO 호출
        // 마찬가지로 new 연산자로 해당 객체를 생성하고
        // insertProduct 메서드 호출
        pdao.insertProduct(pvo);

        System.out.println("상품등록에 성공하였습니다...");
    }
}
