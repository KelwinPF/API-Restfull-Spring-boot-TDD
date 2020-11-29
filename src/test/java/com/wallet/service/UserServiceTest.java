package com.wallet.service;


import com.repository.UserRepository;
import com.wallet.entity.User;
import com.wallet.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @MockBean
    UserRepository repo;

    UserService service;

    public void setUp(){
        BDDMockito.given(repo.findoByEmail(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @Test
    public void testFindByEmail(){
        Optional<User> user = service.findByEmail("emailteste@teste.com");

        assertTrue(user.isPresent());
    }
}
