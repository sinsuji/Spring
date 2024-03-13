package com.example.demo.board;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	int boardNo;
	String title;
	String content;
	String writer;
	Date writeDate;
	int clickCnt;
	String image;
	
	int start = 1;
	int end = 10;
}
