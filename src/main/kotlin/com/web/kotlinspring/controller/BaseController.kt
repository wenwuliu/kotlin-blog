package com.web.kotlinspring.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/base")
class BaseController

    @RequestMapping(value = "/hello",method = [RequestMethod.GET],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ResponseBody
    fun hello():String {
        return "success";
    }


