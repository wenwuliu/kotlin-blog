package com.web.kotlinspring.controller

import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BaseController{

    @Autowired
    protected lateinit var request: HttpServletRequest

    @Autowired
    protected lateinit var response: HttpServletResponse

}

