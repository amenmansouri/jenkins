package com.example.Jenkins;

import com.example.Jenkins.entities.User;
import com.example.Jenkins.repositories.UserRepository;
import com.example.Jenkins.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserTests {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;
    User user1 =new User(1L,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Amen allah","Mansouri",new Timestamp(793065600));
    User user2 =new User(2L,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Muhamed","Mansouri",new Timestamp(852595200));
    User user3 =new User(3L,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"Ismail","Mansouri",new Timestamp(1010188800));
    List<User> users=Arrays.asList(user1, user2);
    @BeforeEach
    public void  init(){
        when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
        when(userRepository.findAll()).thenReturn(users);
    }
    @Test
    public void saveOrUpdateTest(){
        userService.saveOrUpdate(user3);
        verify(userRepository, times(1)).save(user3);
    }
    @Test
    public void findOneTest(){
       User user= userService.findOne(user1.getId());
       assertEquals(user1,user);
       assertNotEquals(user2,user);
    }
    @Test
    public void findAllTest(){
        List<User> userList= userService.findAll();
        assertEquals(users,userList);
    }
    @Test
    public void deleteTest(){
        userService.delete(user3.getId());
        verify(userRepository, times(1)).deleteById(user3.getId());
    }


}
