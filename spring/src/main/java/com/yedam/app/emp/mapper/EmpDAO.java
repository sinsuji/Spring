package com.yedam.app.emp.mapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// @Repository가 없으면 bean으로 등록이 안됨
// @Repository
public class EmpDAO {
	
	@Autowired
	SqlSession mybatis;

	public Map<String, Object> getInfo(String employeeId) {
		return mybatis.selectOne("Employee.getInfo", employeeId);
	}
}