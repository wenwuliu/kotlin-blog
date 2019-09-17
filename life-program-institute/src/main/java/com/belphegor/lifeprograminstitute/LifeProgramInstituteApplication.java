package com.belphegor.lifeprograminstitute;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.belphegor.lifeprograminstitute.dao.mapper")
@SpringBootApplication
public class LifeProgramInstituteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeProgramInstituteApplication.class, args);
    }

}
