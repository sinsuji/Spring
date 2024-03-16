package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor // final 붙어있는 필드를 초기화 시켜주는 생성자를 만들어줌
@ToString
public class EmpVO {
	private int employeeId; // int는 초기값이 0, Integer는 객체 타입이라 null 체크 가능
	final private String firstName;
	final private String lastName;
	private String email;
	private Date hireDate;
	final private Integer salary;
	private String jobId;
	private String departmentId;
	private String managerId;
	private String phone;
	private String photo;
	
	// 생성자 - 객체가 생성될 때 그 필드를 초기화 시켜줌, 생성할 때만 값을 넣어줄 수 있고 변경불가
	// lombok을 이용하면 간편함 final과 @RequiredArgsConstructor 사용
//	public EmpVO(String firstName, String lastName) {
//		this.firstName = firstName; 
//		this.lastName = lastName; 
//	}
	
	
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getSalary() {
		return this.salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; // 부모와 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName()) && this.lastName.equals(vo.getLastName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}	
}
