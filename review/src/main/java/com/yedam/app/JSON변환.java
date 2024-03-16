package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// object ==> json으로 바꾼 것
		EmpVO vo = new EmpVO("길동", "홍", 20000);

		String str = objectMapper.writeValueAsString(vo);
		
		// json ==> object로 바꾼 것
		String json = "{\"employeeId\":0,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"hireDate\":null,\"salary\":null,\"jobId\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null,\"photo\":null}";
		vo = objectMapper.readValue(json, EmpVO.class);
		
		// url ==> object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		
		System.out.println("title : " + map.get("title"));
		
		// Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<Map>(){});
		// System.out.println(map.get());
	}
}
