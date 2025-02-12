package collections;

import java.util.HashMap;
import java.util.Map;

public class MapAndHashMapExam {
	public static void main(String[] args) {
		Map<String, Integer> priceMap = new HashMap<>();

		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);

		Map<String, Integer> priceMap2 = new HashMap<>();
		priceMap2.putAll(priceMap);
		System.out.println(priceMap2);

//		System.out.println(priceMap);
//		System.out.println(priceMap.size());
//		
//		priceMap.put("LG Gram", 1_800_000);		// 변경된 value를 put
//		System.out.println(priceMap);			// 데이터가 추가되지 않고 가격만 변경됨
//		System.out.println(priceMap.size());	// size도 그대로
//		
//		
//		int applePrice = priceMap.get("Apple Macbook Pro"); // okay
//		System.out.println(applePrice);
//
//		int nullApple = priceMap.get("apple macbook pro"); // nullPointerException
//		System.out.println(nullApple);
		

//
//		priceMap.remove("Apple Macbook Pro"); // key값으로 조회 후 해당 map 삭제
//		System.out.println(priceMap);

//		boolean isEmpty = priceMap.isEmpty();
//		System.out.println(isEmpty);		//false -> 안 비어있음
//		System.out.println(priceMap);		
//		System.out.println(priceMap.size());//size -> 3
//		
//		priceMap.clear();
//		isEmpty = priceMap.isEmpty();
//		System.out.println(isEmpty);		//true -> clear 해서 
//		System.out.println(priceMap);		// {}
//		System.out.println(priceMap.size());	//0

		// containsKey
//		if ( !priceMap.containsKey("LG Gram") ) {
//			priceMap.put("LG Gram", 1_600_000);
//		}	
//			System.out.println(priceMap);
//			System.out.println(priceMap.size());

		// containsValue
//		if (priceMap.containsValue(1_700_000)) {
//			priceMap.put("LG Gram", 1_600_000);
//			System.out.println("hi");
//		}
//		System.out.println(priceMap);
//		System.out.println(priceMap.size());
	}
}
