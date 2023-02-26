package io.won.test.service.logic.store;

import io.won.test.service.logic.entity.User;

import java.util.*;

public interface Userstore {
    String create(User newUser);

    void update(User newUser);

    void delete(String id);

    User retrieve(String id);
    List<User> retreiveAll();


}
