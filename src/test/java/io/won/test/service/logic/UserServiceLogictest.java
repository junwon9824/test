package io.won.test.service.logic;

import io.won.test.service.logic.entity.User;
import io.won.test.service.logic.service.UserService;
import io.won.test.service.logic.service.logic.UserServiceLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceLogictest {

    @Autowired
    private UserService userService;

    private User Kim;
    private User lee;


    @BeforeEach
    public void startup() {

        this.Kim = new User("Kim", "kim@naver.com");
        this.lee = new User("lee", "lee@naver.com");
        this.userService.register(Kim);
        this.userService.register(lee);

    }

    @Test
    public void registertest() {

        User sample = User.sample();
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
        this.userService.remove(sample.getId());


    }

    @Test
    public void find() {
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());

    }

    @AfterEach
    public void cleanup() {
        this.userService.remove(Kim.getId());
        this.userService.remove(lee.getId());

    }
}
