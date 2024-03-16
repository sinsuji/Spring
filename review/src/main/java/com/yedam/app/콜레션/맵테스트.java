package com.yedam.app.콜레션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.app.EmpVO;

public class 맵테스트 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("100", "park"); // key, value
		map.put("101", "kim");
		map.put("102", "choi");
		
		String name = (String)map.get("101");
		
		// 반복문
		for( String key : map.keySet() ) { // map은 key로만 접근이 가능
			System.out.println(key + " : " + map.get(key));
		}
		
		// VO == Map
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String, Object>>();
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		map = new HashMap<>();
		map.put("firstName", "kim");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);
		
		// firstName만 출력
		for( HashMap<String, Object> empMap : empList ) {
			System.out.println(empMap.get("firstName"));
		}
		
		// filter
		for( HashMap<String, Object> empMap : empList) {
			if((Integer)empMap.get("salary") >= 15000) {
				System.out.println(empMap.get("firstName"));
			}
		}
		
		// stream
	}
}
