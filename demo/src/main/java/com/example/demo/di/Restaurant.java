package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Data
@RequiredArgsConstructor // 생성자 주입 - final 필드를 초기화 시켜주는 생성자를 만들어줌
@Scope("prototype") // singletone(기본) : 하나를 만들어서 공유해서 사용, prototype : 요청할 때마다 새로 만듦, request : 요청되면 만들고 끝나면 제거, session
public class Restaurant {
	// setter 주입방식
	// lombok에서 setter 메서드를 생성할 때 setter 메서드 위에 @Autowired를 넣어줘라
	// @Setter(onMethod_ = {@Autowired})
	// private Chef chef;
	
	// 생성자 주입방식
	final private Chef chef;
	
	
}
