package com.web.kotlinspring.service.impl

import com.web.common.dao.UserDao
import com.web.common.entity.User
import com.web.kotlinspring.reqparam.UserReq
import com.web.kotlinspring.service.UserService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.web.common.utils.ResponseData
import com.web.common.utils.failed
import com.web.common.utils.success

@Service
class UserServiceImpl:UserService{

    @Autowired
    lateinit var userDao: UserDao

    var log = LoggerFactory.getLogger(this.javaClass)

    override fun modifyUserInfo(userReq: UserReq): ResponseData {
        if(!validateUser(userReq)){
            return failed("userReq:${userReq} is not full")
        }
        GlobalScope.launch {
            delay(1000)
            log.info("${userReq}")
        }
        return success("success");
    }

    override fun insertUserInfo(userReq: UserReq): ResponseData {
        if(!validateUser(userReq)){
            return failed("userReq:${userReq} is not full")
        }
        var user = assembleUser(userReq)
        var isSuccess = userDao.insertSelective(user)
        return success(isSuccess)

    }

    private fun assembleUser(userReq: UserReq):User{
        var user:User = User()
        user.userName = userReq.username
        user.email = userReq.email
        user.phone = userReq.phone?.toInt()
        return user
    }

    private fun validateUser(userReq: UserReq):Boolean{
        if(userReq.phone == null || userReq.phone.length > 12){
            return false
        }
        if(userReq.username == null){
            return false
        }
        return true
    }

}