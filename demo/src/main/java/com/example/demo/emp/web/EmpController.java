package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	@Autowired EmpMapper dao; // 의존성주입 (DI dependency Injection) - 객체관리를 스프링이 알아서 다해줌
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody // 모든 결과값을 JOSN으로 만들어줌
	public List<EmpVO> ajaxEmp() {
		return dao.getEmpList();
	}
	
	@RequestMapping("/empList")
	public String empList(Model model){ 
		model.addAttribute("empList", dao.getEmpList()); // model.addAttribute -> req.setAttributte와 같음
		return "empList";
	}
}
