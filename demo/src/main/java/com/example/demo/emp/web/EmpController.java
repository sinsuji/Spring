package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@Controller // 컨테이너 빈 등록 + 사용자요청 처리할 수 있는 커맨드 핸들러 변환
@RequiredArgsConstructor
public class EmpController {
	
	// 생성자주입 
	final EmpMapper mapper; // 의존성주입 (DI dependency Injection) - 객체관리를 스프링이 알아서 다해줌
	
	
	@PostMapping("/insert")
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
		// mapper.insertEmp(vo);		
		// 커맨드객체는 model에 추가
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult", "success");
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv;
	}
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody // 모든 결과값을 ajax로 바꿔서 넘어감, JOSN으로 만들어줌
	public List<EmpVO> ajaxEmp() {
		return mapper.getEmpList(null, null);
	}
	
	@RequestMapping("/empResult")
	public String result() {
		return "result";
	}
	
	
	// forward : 모델에 담아서 모델을 가지고 넘어가면 됨
	@RequestMapping("/empList")
	public String empList(Model model){ 
		model.addAttribute("empList", mapper.getEmpList(null, null)); // model.addAttribute -> req.setAttributte와 같음
		return "empList";
	}
	
	// redirect : 완전히 다른 페이지로 가야할 경우
	@PostMapping("/insert3")
	public String insert3(EmpVO vo, RedirectAttributes rttr) {
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만 사용가능");
		return "redirect:empResult";
	}
	
	@PostMapping("/insert2")
	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String test() {
		return "index";
	}
}
