package com.belphegor.lifeprograminstitute.dao;

import com.belphegor.common.mybatis.BaseDAO;
import com.belphegor.lifeprograminstitute.dao.mapper.UserMapper;
import com.belphegor.lifeprograminstitute.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO extends BaseDAO<User, UserMapper> {
}
