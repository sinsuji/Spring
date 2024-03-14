package com.example.demo.ex;

import java.util.List;

import lombok.Data;

@Data
public class EX1VO {
	private String username;
	private String password;
	// String[] hobby 또는
	private List<String> hobby;

}
