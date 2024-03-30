package com.dbal.app.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dbal.app.book.model.BookVO;

@Mapper
public interface BookMapper {
	public int getBookNo();
	public List<BookVO> getBookList();
	public int insertBook(BookVO vo);
	public List<Map<String, Object>> getRent();
}
