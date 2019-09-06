package com.web.kotlinspring.service.impl

import com.web.kotlinspring.reqparam.UserReq
import com.web.kotlinspring.service.UserService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import src.main.kotlin.com.web.common.utils.ResponseData
import src.main.kotlin.com.web.common.utils.failed
import src.main.kotlin.com.web.common.utils.success

@Service
class UserServiceImpl:UserService{

    var log = LoggerFactory.getLogger(this.javaClass)

    override fun modifyUserInfo(userReq: UserReq): ResponseData {
        if(!validateUser(userReq)){
            return failed("userReq:${userReq} phone is null")
        }
        GlobalScope.launch {
            delay(1000)
            log.info("${userReq}")
        }
        return success("success");
    }

    private fun validateUser(userReq: UserReq):Boolean{
        if(userReq.phone != null && userReq.phone.length < 12){
            return false
        }
        return true
    }

}