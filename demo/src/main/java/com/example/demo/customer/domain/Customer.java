package com.example.demo.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자
@Builder // 생성자 대신
@AllArgsConstructor // Builder와 함께 사용
@Entity
public class Customer {
	@Id // 기본키설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 20, nullable = false) // not null
	private String name;
	private String phone;
}
