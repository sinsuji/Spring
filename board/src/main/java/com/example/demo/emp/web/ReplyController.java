package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.ReplyVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyController {

	@Autowired ReplyMapper mapper;

	
	// 리스트 페이지이동
	@GetMapping("/reply/replyMng")
	public ModelAndView replyMng() {
		 ModelAndView rv = new  ModelAndView("/reply/replyMng");
		 return rv;
	}
	
	
	// 리스트 데이터
	@GetMapping("/ajax/replyList")
	// @ResponseBody // vo 객체를 JSON형식의 String으로 자동변환
	public List<ReplyVO> replyList(ReplyVO vo) {
		return mapper.getReplyList(vo);
	}
	
	
	@PostMapping("/ajax/reply")
	public ReplyVO save(@RequestBody ReplyVO vo) {
		System.out.println(vo);
		 mapper.insertReply(vo);
		 return vo;
	}
}
