package io.won.test.service.logic.store.logic;

import io.won.test.service.logic.entity.User;
import io.won.test.service.logic.store.Userstore;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserstoreLogic implements Userstore {

    private Map<String, User> userMap;

    public UserstoreLogic() {
        this.userMap = new HashMap<>();

    }

    @Override
    public String create(User newUser) {
        this.userMap.put(newUser.getId(), newUser);
        return newUser.getId();
    }

    @Override
    public void update(User newUser) {
        this.userMap.put(newUser.getId(), newUser);

    }

    @Override
    public void delete(String id) {
    this.userMap.remove(id);
    }

    @Override
    public User retrieve(String id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> retreiveAll() {
        return this.userMap.values().stream().collect(Collectors.toList());
    }


}
