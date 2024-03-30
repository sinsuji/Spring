package com.dbal.app.book.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;
	

	@Override
	public List<BookVO> getBookList() {
		return bookMapper.getBookList();
	}

	@Override
	public List<Map<String, Object>> getRent() {
		return bookMapper.getRent();
	}
	
	@Override
	public boolean insertBook(BookVO vo) {
		return bookMapper.insertBook(vo) == 1 ? true : false;
	}

	@Override
	public int getBookNo() {
		return bookMapper.getBookNo();
	}
}
