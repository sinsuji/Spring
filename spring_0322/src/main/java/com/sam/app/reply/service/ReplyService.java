package com.sam.app.reply.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sam.app.reply.ReplyVO;

public interface ReplyService {
	List<ReplyVO> getReplyList(@Param("vo") ReplyVO vo);
	int insertReply(ReplyVO ReplyVO);
}
