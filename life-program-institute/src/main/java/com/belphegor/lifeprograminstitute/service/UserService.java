package com.belphegor.lifeprograminstitute.service;

import com.belphegor.lifeprograminstitute.entity.User;

public interface UserService {

    public User getUserByUsername(String username);

    public boolean validateUser(User user);

}
