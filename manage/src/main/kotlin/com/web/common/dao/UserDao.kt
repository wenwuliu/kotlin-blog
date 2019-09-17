package com.web.common.dao

import com.web.common.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class UserDao{

    @Autowired
    lateinit var userMapper: UserMapper

    fun findUserByUserId(userId:String): User {
        return userMapper.selectByUserId(userId)
    }

    fun insertSelective(user: User):Int{
        return userMapper.insertSelective(user)
    }

}