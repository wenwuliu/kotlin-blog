package com.belphegor.lifeprograminstitute.controller;

import com.belphegor.common.entity.ResponseEntity;
import com.belphegor.lifeprograminstitute.dao.UserDAO;
import com.belphegor.lifeprograminstitute.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/hello")
    @ResponseBody
    public ResponseEntity hello(){
        log.info("testeeee1");
        return ResponseEntity.success("hello");
    }

}
