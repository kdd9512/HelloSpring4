package kdd9512.product;

public class ProductService01 {

    // 상품등록 기능을 수행하는 메서드
    public void newProduct() {
        System.out.println("상품등록 준비중.");

        ProductVO pvo = new ProductVO();
        pvo.setPname("상품1");
        pvo.setPrice(9999);

        // 입력받은 상품 정보에 영속성을 부여하기 위해  DAO 호출
        // 마찬가지로 new 연산자로 해당 객체를 생성하고
        // insertProduct 메서드 호출
        ProductDAO01 pdao = new ProductDAO01();
        pdao.insertProduct(pvo);

        System.out.println("상품등록에 성공하였습니다...");
    }
}
