//package com.Room.Controller;
//
//import org.json.simple.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/restrooms")
//public class RoomRestController {
//    private static final Logger logger = LoggerFactory.getLogger(RoomRestController.class);
//    private final String GLOBAL_ERROR = "Some technical Error Please try again after some time";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/call_Staff_getAllEmp_endPoint")
//    public String callStaff_GetAllEmp() {
//        try {
//            String responseFromStaff = restTemplate.getForObject("http://localhost:8088/Staff/getAllEmp",
//                    String.class);
//            logger.info("vvv::  responseFromStaff= " + responseFromStaff);
//            return responseFromStaff;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return GLOBAL_ERROR;
//        }
//    }
//
//    @PostMapping("/call_Staff_addEmp_endPoint")
//    public String call_Staff_addEmp_endPoint() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject staffObj = new JSONObject();
//        staffObj.put("empId", 125);
//        staffObj.put("empDeptId", 2);
//        staffObj.put("empName", "Samesh");
//        staffObj.put("empDeptName", "Serving");
//        staffObj.put("email", "Samesh2@gmail.com");
//        staffObj.put("empSalary", 20000);
//        org.springframework.http.HttpEntity<String> s = new org.springframework.http.HttpEntity<String>(staffObj.toString(),headers);
//        String postForObject = restTemplate.postForObject("http://localhost:8088/Staff/addEmp", s, String.class);
//        return postForObject;
//    }
//}
