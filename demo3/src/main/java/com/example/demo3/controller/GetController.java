package com.example.demo3.controller;

import com.example.demo3.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping("/name")
    public String getName() {
        return "Spring";
    }

    @GetMapping("/variable/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }


    @GetMapping("/info/{id}")
    public String getUserInfo(@PathVariable("id") String userId) {
        return userId;
    }

    @GetMapping("/request1")
    public String getRequestPrams(@RequestParam String name, @RequestParam String email) {
        return name + " " + email;
    }

    @GetMapping("/request2")
    public String getRequestParams2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");

        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParams3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
