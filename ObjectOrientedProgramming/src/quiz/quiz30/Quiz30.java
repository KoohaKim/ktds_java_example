package quiz.quiz30;
/*
 * 어떤 상품을 판매하는 판매자가 있습니다.

판매자에게서 상품을 구매하는 구매자가 있습니다.

구매자는 판매자에게서 상품을 구매할 수 있습니다.
구매자가 판매자에게서 상품 1개를 구매한다면
판매자의 상품 재고는 1개가 줄어야 하며
판매자의 금고에는 상품 1개에 대한 금액만큼 증가해야 합니다.

만약, 구매자가 판매자에게서 상품 3개를 구매한다면
판매자의 상품 재고는 3개가 줄어야 하며
판매자의 금고에는 상품 3개에 대한 금액만큼 증가해야 합니다.

구매자가 판매자에게서 구매하려는 상품의 개수가 더 크다면,
판매자는 남아있는 모든 상품을 판매해야 합니다.
따라서, 판매자의 상품재고는 남아있는 재고의 수가 모두 줄어야 하며
판매자의 금고에는 남아있는 상품의 재소 구 만큼에 대한 금액이 증가해야 합니다.

한편, 구매자는 판매자에게서 상품을 구매한다면
구매자의 지갑에는 구매한 상품만큼의 금액이 줄어들어야 하며
구매자의 장바구니에는 구매한 상품의 수 만큼 늘어나야 합니다.

만약 구매자가 판매자에게서 상품 여러개를 구매하려 하는데
구매자의 지갑에 충분한 돈이 없다면 판매자와 구매자는 아무런 변화가 없어야 합니다.

마지막으로 구매자와 판매자의 현재 상태를 출력해야 합니다.
구매자의 상품 수: n개
구매자의 지갑 현황: 8000원

판매자의 상품 수: n개
판매자의 상품 가격: n원
판매자의 금고 현황: 100000원
 */
public class Quiz30 {
    public static void main(String[] args) {
        Product doll = new Product("티니핑", new Quantity(100), 100_000);
        Product robot = new Product("건담", new Quantity(15), 50_000);
        Seller seller = new Seller(0);
        Customer rich = new Customer(9_000_000);
        Customer poor = new Customer(50);

        //잔액부족
        seller.sellProduct(poor, robot, new Quantity(1));
        //주문 수량 많을 경우
        seller.sellProduct(rich, doll, new Quantity(20));
        //일반 주문
        seller.sellProduct(rich, doll, new Quantity(5));
//        seller.sellProduct(rich, robot, new Quantity(5));
    }
}
