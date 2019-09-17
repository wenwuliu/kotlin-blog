package com.web.kotlinspring.service

import com.web.kotlinspring.reqparam.UserReq
import com.web.common.utils.ResponseData

interface UserService{
    abstract fun modifyUserInfo(userReq: UserReq): ResponseData
    abstract fun insertUserInfo(userReq: UserReq): ResponseData
}