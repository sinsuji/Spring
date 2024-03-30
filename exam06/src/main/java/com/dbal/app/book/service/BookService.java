package com.dbal.app.book.service;

import java.util.List;
import java.util.Map;

import com.dbal.app.book.model.BookVO;

public interface BookService {
	public int getBookNo();
	public boolean insertBook(BookVO bookVO);
	public List<BookVO> getBookList();
	public List<Map<String, Object>> getRent();
}
