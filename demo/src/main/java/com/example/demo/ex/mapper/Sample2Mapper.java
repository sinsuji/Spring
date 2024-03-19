package com.example.demo.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Sample2Mapper {
	@Insert("INSERT INTO tbl_sample2(col2) VALUES (#{data})")
	public int insertCol2(String data);
}
