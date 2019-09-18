package com.belphegor.lifeprograminstitute.dao.mapper;

import com.belphegor.common.mybatis.BaseMapper;
import com.belphegor.lifeprograminstitute.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    User selectByUserName(@Param("username") String username);
}