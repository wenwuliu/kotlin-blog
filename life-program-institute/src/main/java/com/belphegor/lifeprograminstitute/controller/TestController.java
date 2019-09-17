package com.belphegor.lifeprograminstitute.controller;

import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.lifeprograminstitute.dao.UserDAO;
import com.belphegor.lifeprograminstitute.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/hello")
    @ResponseBody
    public ResponseEntity hello(){
        User user = new User();
        user.set
        userDAO.selectByPrimaryKey("1");
        return ResponseEntity.success("hello");
    }

}
