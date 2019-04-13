package com.example.springbootexperiments03;

import com.example.springbootexperiments03.Entity.Address;
import com.example.springbootexperiments03.Entity.AddressUser;
import com.example.springbootexperiments03.Entity.User;
import com.example.springbootexperiments03.Repository.AddressRepository;
import com.example.springbootexperiments03.Repository.AddressUserRepository;
import com.example.springbootexperiments03.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressUserRepository addressUserRepository;

    @Test
    public void init(){
        User user1=new User("BO");
        userRepository.save(user1);
        User user2=new User("ZhengDS");
        userRepository.save(user2);
        Address a1=new Address("956");
        addressRepository.save(a1);
        Address a2=new Address("954");
        addressRepository.save(a2);
        Address a3 = new Address("1021");
        addressRepository.save(a3);
        AddressUser au1=new AddressUser(user1,a1);
        addressUserRepository.save(au1);
        AddressUser au2=new AddressUser(user1,a2);
        addressUserRepository.save(au2);
        AddressUser au3=new AddressUser(user2,a3);
        addressUserRepository.save(au3);
    }
    @Test
    public void  userRepTest(){
        User u=userRepository.find(1);
        log.debug(u.getName());
    }
    @Test
    public void addressRepTest(){
        addressRepository.list("956")
                .forEach(a-> {
                    log.debug("{}",a);
                });
    }
    @Test
    public void addressuserRepTest(){
        AddressUser au=addressUserRepository.find("ZhengDS","1021");
        log.debug("插入时间",au.getInsertTime());
    }
}
