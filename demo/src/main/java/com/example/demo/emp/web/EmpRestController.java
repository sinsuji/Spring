package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

@RestController
public class EmpRestController {
	
	@Autowired EmpMapper mapper;
	
	// @RestController에서 view 페이지로 넘겨야 할 경우 ModelAndView 사용
	// 리스트 페이지이동
	@GetMapping("/empMng")
	public ModelAndView empMng() {
		 ModelAndView mv = new  ModelAndView("empMng");
		 return mv;
	}
	
	
	// 사원리스트 데이터
	@GetMapping("/ajax/empList")
	// @ResponseBody // vo 객체를 JSON형식의 String으로 자동변환
	public List<EmpVO> empList(EmpVO vo, SearchVO svo, Paging pvo) {
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());	
		return mapper.getEmpList(vo, svo);
	}
	
//	@PostMapping("/ajax/emp")
//	public EmpVO save(EmpVO vo) {
//		System.out.println(vo);
//		// mapper.insertEmp(vo);
//		return vo;
//	}
	
	// 3. JsonString
	@PostMapping("/ajax/emp")
	public EmpVO save(@RequestBody EmpVO vo) {
		System.out.println(vo);
		mapper.insertEmp(vo);
		return vo;
	}
	
	@GetMapping("/ajax/emp/{empId}")
	public EmpVO info(@PathVariable int empId) {
		return mapper.getEmpInfo(empId);
	}
	
}
