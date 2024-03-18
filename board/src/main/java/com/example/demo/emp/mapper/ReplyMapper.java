package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(@Param("vo") ReplyVO vo);
	int insertReply(ReplyVO ReplyVO);
}
