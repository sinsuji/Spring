package com.sam.app.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sam.app.reply.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(@Param("vo") ReplyVO vo);
	int insertReply(ReplyVO ReplyVO);
}
