package kdd9512.product;

public class ProductVO {

    private String pname;
    private int price;

    // setter/getter 에 사용되는 private 변수들 초기화
    // 변수가 정의되었으므로 이하에서 문제없이 사용가능한 상태가 된다.

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }
}
