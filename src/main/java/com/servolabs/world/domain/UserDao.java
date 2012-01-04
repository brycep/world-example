package com.servolabs.world.domain;

public interface UserDao {
    User getForUsername(String username);

    void createUser(User user);
}