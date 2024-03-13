package com.example.demo.board;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper;
	
	@Test
	public void 게시글등록() {
		BoardVO vo = BoardVO.builder()
					// .boardNo(20)
					.title("게시글 등록 테스트")
					.content("게시글등록등록등록등록등록")
					.writer("김홍홍")
					.writeDate(new Date(2024,0,1))
					.build();
		int result = mapper.insertBoard(vo);
		
		System.out.println("등록되었습니다.");
	}
	
	//@Test
	public void 게시글전체조회() {
		BoardVO vo = new BoardVO();
		List<BoardVO> list = mapper.getBoardList(vo);
		for( BoardVO board : list ) {
			System.out.println("제목: " + board.getTitle() + ", "
							 + "내용: " + board.getContent() + ", "
							 + "작성자: " + board.getWriter());
		}
		System.out.println("결과는 = " + list.size());
	}
	
	// @Test
	public void 게시글단건조회() {
		int boardNo = 12;
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}
}
