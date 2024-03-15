package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@Controller // 컨테이너 빈 등록 + 사용자요청 처리할 수 있는 커맨드 핸들러 변환
@RequiredArgsConstructor
public class EmpController {
	
	// 생성자주입 
	final EmpMapper mapper; // 의존성주입 (DI dependency Injection) - 객체관리를 스프링이 알아서 다해줌
	
	// 등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() {}
	
	// 등록처리 --> employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile) throws IllegalStateException, IOException {
		// 파일업로드
		File file = new File("d:/upload", photoFile.getOriginalFilename());
		photoFile.transferTo(file);
		
		vo.setPhoto(photoFile.getOriginalFilename());
		System.out.println(vo);
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}
	
	// 수정페이지 이동
	@GetMapping("/emp/update/{employeeId}")
	public String update(@PathVariable int employeeId, Model model) {
		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
		return "emp/update";
	}
	
	// 수정처리
	@PostMapping("/update")
	public String update(EmpVO vo) {
		mapper.updateEmp(vo);
		return "redirect:/emp/list";
	}
		
	// 삭제처리
	@RequestMapping("/emp/delete/{employeeId}")
	public String delete(@PathVariable int employeeId){ 
		System.out.println("employeeId : " + employeeId);
		mapper.deleteEmp(employeeId);
		return "redirect:/emp/list";
	}
	
	// 상세처리
	@RequestMapping("/emp/info/{employeeId}")
	public String empInfo(@PathVariable int employeeId, Model model){ 
		System.out.println("employeeId : " + employeeId);
		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
		return "emp/info";
	}
	
	// 목록페이지로 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, SearchVO svo){ 
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "emp/list";
	}
	
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
