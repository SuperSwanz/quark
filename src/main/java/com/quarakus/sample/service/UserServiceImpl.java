package com.quarakus.sample.service;

import com.quarakus.sample.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    EntityManager em;

    @Override
    public User find(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<User> find() {
        return null;
    }
}
