package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = {"회원가입 API"})
@RequestMapping("/member/api")
@RestController
public class SwaggerController {

    @ApiOperation(value = "회원가입", notes = "회원가입!!")
    @PostMapping(value = "/join")
    public Map<String,String> signUp(@ApiParam(name = "first param", value = "first value", readOnly = true) String input){
        Map<String, String> result = new HashMap<>();
        result.put("author", "koboseok");
        result.put("content", "V1 API 내용");
        return result;
    }
}
