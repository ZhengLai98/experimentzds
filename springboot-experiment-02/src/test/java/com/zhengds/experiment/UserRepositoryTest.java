package com.zhengds.experiment;

import com.zhengds.experiment.Repository.UserRepository;
import com.zhengds.experiment.entity.Address;
import com.zhengds.experiment.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    /**
     * 编写单元测试用例，测试方法实现的结果是否正确
     *
     * */
    @Test
    public  void addUserTest(){
        User u1=userRepository.addUser(new User("Zds3"));
        log.debug("{}",u1.getInsertTime());
    }
    @Test
    public void addAddressTest(){
        Address address=userRepository.addAddress(new Address("成栋"),3);
        log.debug("{}",address.getInsertTime());
    }
    @Test
    public void updateUserNameTest(){
        User user=userRepository.updateUser(1,"zds0");
        log.debug("{}",user.getName());
    }
    @Test
    public void updateAddressUser(){
        //userRepository.updateAddress(1,3);merge测试
        userRepository.updateAddress(2,1);//find测试
    }
    @Test
    public void listAdressesTest(){
        List<Address> list=userRepository.listAddresses(1);
        log.debug("{************************}",list);

    }
    @Test
    public  void removeAdressTset(){
        userRepository.removeAddress(3);
    }
    @Test
    public  void removeUserTest(){
        userRepository.removeUser(4);
    }
}
