package com.example.demo;

import com.example.demo.entity.Myuser;
import com.example.demo.repository.MyUserRepository;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
public class MyUserTest {
    @Autowired
    private MyUserRepository mu;

    @Test
    void save() {
        Myuser user = mu.save(new Myuser("hello3", "1234", "123@", null, null));
        log.info("user==>{}", user);
    }

    @Test
    void update() {
        Myuser m = new Myuser("hello3", "1515", "2634@", null, null);
        Optional<Myuser> myuser = mu.findById("hello3");
        Myuser myuser1 = myuser.get();
        myuser1.setPassword(m.getPassword());
        myuser1.setEmail(m.getEmail());
    }
    @Test
    void delete(){
        mu.deleteById("hello3");
    }
    @Test
    void findAll() {
        List<Myuser> users = mu.findAll();
        log.info("users==>{}", users);
    }

}
