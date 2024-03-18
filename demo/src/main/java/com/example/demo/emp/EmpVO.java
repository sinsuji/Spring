package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") // 입력받을 때(파라미터) 받아온 String값을 Date로 바꿀 때 필요
	@JsonFormat(pattern = "yyyy-MM-dd")     // 출력 Date -> String
	Date hireDate;
	Integer salary;
	String jobId;
	@JsonProperty(value = "deptId") String departmentId;
	@JsonIgnore String managerId;
	@JsonIgnore String phone;
}
