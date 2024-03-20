package com.cogent.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "User", url = "localhost:8081/auth")
public interface UserClient 
{
	@GetMapping("/validateUser")
	public boolean validUserToken(@RequestParam int userId, @RequestHeader("Authorization") String token);

	@GetMapping("/validateAdmin")
	public boolean validAdminToken(@RequestHeader("Authorization") String token);
}





//package com.cogent;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
////localhost:8081/api/v1/students/fetch/{schoolid}
//@FeignClient(name = "student-service", url = "localhost:8081/api/v1/students")
//public interface StudentClientInSchool 
//{
//	@GetMapping("/fetch/{schoolid}")
//	public List<Student> fetchById(@PathVariable("schoolid") int schoolId);
//	
//}