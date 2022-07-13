package lecture0713;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Collection {
	public static void main(String[] args) {
		String str1 = "Hello"; // String pool
		String str2 = "Hello"; 
		String str3 = new String("Hello"); // Heap
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		
		List list = new ArrayList<>();
		list.add("Hello");
		list.add("홍길동");
		list.add(100); // auto wrapping 됨 new Integer(100)
		
		System.out.println(list.get(2).getClass().getName());
		
		
		// 같은 데이터 타입일 이용하는 경우가 사실 대부분 -> Generic
		List<String> list1 = new ArrayList<String>();
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "홍길동");
		map.put("2", "Hello");

		
		
		
	}
}
