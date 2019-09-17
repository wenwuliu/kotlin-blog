package com.web.common.utils

class ResponseData{
    var code:Int = 0
    lateinit var message:String
    lateinit var data:Any

    constructor(code:Int,message:String,data:Any){
        this.code = code
        this.message = message
        this.data = data
    }


}

fun success(data:Any):ResponseData{
    return ResponseData(0,"success",data)
}

fun failed(data: Any):ResponseData{
    return ResponseData(1,"error",data)
}

