package com.yedam.app.콜레션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

import lombok.ToString;

/*
 * List, Set, Map
 * list : 중복값 허용, index로 접근                    --> 목록, 순차적으로 읽고 쓰고 할 때 
 * set : 중복값 허용안함, index로 접근                  --> 중복값 허용안함
 * map : <key : value> 쌍으로 이루어짐, 무조건 key로 접근 --> 검색이 엄청 빠름
*/
public class CollectionTest {
	public static void main(String[] args) {
		// 중복값 제거 
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3); // 배열값을 list로 바꿔줌
		System.out.println(list);
		
		//list ==> set
		HashSet set = new HashSet<>(list);
		System.out.println(set);
		
		//List<EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO("park", "bbb", 20000));
		empList.add(new EmpVO("choi", "aaa", 10000));
		empList.add(new EmpVO("kim", "ccc", 14000));
		empList.add(new EmpVO("park", "bbb", 20000));
		
		// 중복값제거
		HashSet<EmpVO> empSet = new HashSet<>(empList);
		System.out.println(empSet.size());
		System.out.println(empList);
		
		// 필터링 : 급여가 15000이상인 사원만 검색
		List<EmpVO> filterList = new ArrayList<>();
		for( EmpVO vo : empSet ) {
			if(vo.getSalary() >= 15000) {
				filterList.add(vo);
			}
		}
		System.out.println(filterList.size());
		
		// ==> stream
		filterList = empSet.stream()
						   .filter( vo -> vo.getSalary() >= 15000 )
						   .collect(Collectors.toList());
		System.out.println(filterList);
		
		// lastName ==> b인 사람 
		filterList = empSet.stream()
				.filter( vo -> vo.getLastName().contains("b")) 
				.collect(Collectors.toList());
	
		System.out.println(filterList.toString());
	}
}
