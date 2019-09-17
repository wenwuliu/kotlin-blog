package com.web.kotlinspring.controllerimport com.web.kotlinspring.reqparam.TestReqimport com.web.kotlinspring.reqparam.UserReqimport com.web.kotlinspring.service.UserServiceimport org.springframework.beans.factory.annotation.Autowiredimport org.springframework.http.MediaTypeimport org.springframework.web.bind.annotation.RequestMappingimport org.springframework.web.bind.annotation.RequestMethodimport org.springframework.web.bind.annotation.ResponseBodyimport org.springframework.web.bind.annotation.RestControllerimport com.web.common.utils.ResponseDataimport com.web.common.utils.success@RestController@RequestMapping("/life-blog")class TestController:BaseController(){    @Autowired    lateinit var userService:UserService    @RequestMapping(value = ["/test"],method = [RequestMethod.GET],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])    @ResponseBody    fun test(testReq: TestReq): ResponseData {        var str = "test Result:username:${testReq.username},password:${testReq.password}"        return success(str)    }    @RequestMapping(value = ["/modifyUserInfo"],method = [RequestMethod.GET],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])    @ResponseBody    fun modifyUserInfo(userReq: UserReq):ResponseData{        return userService.modifyUserInfo(userReq)    }    @RequestMapping(value = ["/insertUserInfo"],method = [RequestMethod.GET],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])    @ResponseBody    fun insertUserInfo(userReq: UserReq):ResponseData{        return userService.insertUserInfo(userReq)    }}