package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	int employeeId; // int는 초기값이 0, Integer는 객체 타입이라 null 체크 가능
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone;
	String photo;
}
