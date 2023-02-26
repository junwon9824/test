package io.won.test.service.logic.service.logic;

import io.won.test.service.logic.entity.User;
import io.won.test.service.logic.service.UserService;
import io.won.test.service.logic.store.Userstore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceLogic implements UserService {

    private final Userstore userstore;

    @Override
    public String register(User newUser) {
        return this.userstore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userstore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userstore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userstore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userstore.retreiveAll();
    }
}
