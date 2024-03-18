package com.example.demo.emp;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private long rno;
	private long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
