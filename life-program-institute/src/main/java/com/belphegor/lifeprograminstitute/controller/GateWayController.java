package com.belphegor.lifeprograminstitute.controller;

import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.common.enums.RespCodeEnum;
import com.belphegor.common.utils.CommonUtils;
import com.belphegor.lifeprograminstitute.entity.User;
import com.belphegor.lifeprograminstitute.service.UserService;
import com.belphegor.lifeprograminstitute.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/belphegor",produces = "application/json;charset=UTF-8")
public class GateWayController {
    private static final Logger log = LoggerFactory.getLogger(GateWayController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity login(String username,String password){
        ResponseEntity responseEntity;
        User u = userService.getUserByUsername(username);
        if(u == null || !u.getPassword().equals(password)){
            responseEntity = ResponseEntity.failed(RespCodeEnum.LOGINFAILED);
        }else {
            String token = TokenUtils.generateToken(username);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("user",u);
            responseEntity = ResponseEntity.success(map);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(User user){
        if(user == null || StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())){
            return ResponseEntity.failed(RespCodeEnum.INVALIDPARAM);
        }
        User newAccount = new User();
        newAccount.setUserName(user.getUserName());
        newAccount.setPassword(user.getPassword());
        newAccount.setBirthday(user.getBirthday());
        newAccount.setHeight(user.getHeight());
        newAccount.setWeight(user.getWeight());
        newAccount.setUserId(CommonUtils.getUUID());
        int success = userService.addUser(newAccount);
        if(success > 0){
            return ResponseEntity.success();
        }
        return ResponseEntity.failed(RespCodeEnum.DEALFAILED);
    }
}
