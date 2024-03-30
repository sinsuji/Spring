package com.dbal.app.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {

	@Autowired // 인터페이스 인젝션(상속받아 구현된 자식클래스 주입)
	BookService bookService;
	
	// 목록조회
	@GetMapping("getBook")
	public String getBookList(Model model) {
		// 목록조회
		model.addAttribute("list", bookService.getBookList());
		return "book/list";
	}
	
	// 등록페이지 이동
	@GetMapping("insertBook")
	public String insertBookForm(Model model) {
		// bookno 조회
		model.addAttribute("bookNo", bookService.getBookNo());
		return "book/insert";
	}

	// 등록처리
	@PostMapping("insertBook")
	public String insertBook(BookVO vo) {
		bookService.insertBook(vo);
		return "redirect:getBook";
	}
	
	
	// 대여조회
	@GetMapping("getRent")
	public String getRent(Model model) {
		model.addAttribute("bookList", bookService.getRent());
		return "book/getRent";
	}

}
