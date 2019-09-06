package com.web.kotlinspring.service

import com.web.kotlinspring.reqparam.UserReq
import src.main.kotlin.com.web.common.utils.ResponseData

interface UserService{
    fun modifyUserInfo(userReq: UserReq):ResponseData
}