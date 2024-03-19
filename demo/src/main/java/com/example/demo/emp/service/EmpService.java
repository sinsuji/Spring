package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
// 화면에서 사용자의 요청이 발생하는 것들을 담아둠

public interface EmpService {
	Map<String, Object> getEmpList(EmpVO vo, SearchVO svo);
	EmpVO getEmpInfo(int employeeId);
	int insertEmp(EmpVO empVO); // insert에 들어올 수 있는 값은 int 아니면 void
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
	
}
