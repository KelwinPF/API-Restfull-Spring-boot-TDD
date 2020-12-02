package com.wallet.repository;

import com.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String email = "email@teste.com";

    UserRepository repo;

    @Before
    public void setUp(){
        User u = new User();
        u.setName("setup");
        u.setPassword("123");
        u.setEmail(email);

        repo.save(u);
    }
    @After
    public void tearDown(){
        repo.deleteAll();
    }
    @Test
    public void testSave(){
        User u = new User();
        u.setName("Teste");
        u.setPassword("123456");
        u.setEmail("este@hotmail.com");

        User response = repo.save(u);

        assertNotNull(response);
    }

    public void testFindByEmail(){
        Optional<User> response = repo.findByEmail(email);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(),email);
    }

}
