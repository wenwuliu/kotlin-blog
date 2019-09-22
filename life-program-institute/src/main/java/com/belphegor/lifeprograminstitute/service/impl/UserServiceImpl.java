package com.belphegor.lifeprograminstitute.service.impl;

import com.belphegor.lifeprograminstitute.dao.UserDAO;
import com.belphegor.lifeprograminstitute.entity.User;
import com.belphegor.lifeprograminstitute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public User getUserByUsername(String username){
        return userDAO.selectByUserName(username);
    }

    @Override
    public boolean validateUser(User user) {
        if(user == null || user.getUserId() == null){
            return false;
        }
        User test = userDAO.selectByPrimaryKey(user.getUserId());
        if(test == null){
            return false;
        }
        if(!test.getUserName().equals(user.getUserName())){
            return false;
        }
        return true;
    }

    @Override
    public int addUser(User newAccount) {
        return userDAO.insertSelective(newAccount);
    }
}
