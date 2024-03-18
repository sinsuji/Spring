package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.ReplyVO;
import com.example.demo.emp.mapper.ReplyMapper;

import lombok.Setter;

@SpringBootTest
public class ReplyMapperTests {
	private Long[] bnoArr = { 3145745L, 3145744L, 3145743L, 3145742L, 3145741L };
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper; 
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			// 게시물의 번호
			vo.setBno(bnoArr [i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insertReply(vo);
		});
	}
	
}
