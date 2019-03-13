package com.quarakus.sample.service;

import com.quarakus.sample.model.User;

import java.util.List;

public interface UserService {
    public User find(final Long id);

    public User save(final User user);

    public List<User> find();
}