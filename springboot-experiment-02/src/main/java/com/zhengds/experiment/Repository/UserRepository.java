package com.zhengds.experiment.Repository;

import com.zhengds.experiment.entity.*;
import com.zhengds.experiment.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    /**
     * 添加用户，并返回包括时间戳的用户对象
     */
    public User addUser(User u) {
        em.persist(u);
        //在同一个事务中想要返回时间戳就必须调用refresh强制数据库同步过来
        em.refresh(u);
        return u;
    }

    /**
     * 添加地址，并指定地址对应的用户
     */
    public Address addAddress(Address address, int uid) {
        User user = em.find(User.class, uid);//搜寻对应id的用户添加地址
        address.setUser(user);
        //把user塞进去
        em.persist(address);
        return address;
    }

    /**
     * 更新指定ID用户的姓名
     */
    public User updateUser(int uid, String newName) {
        User user = new User();
        user.setId(uid);
        User newUser = em.merge(user);
        /*
        * JPA中的merge类似Hibernate中的saveOrUpdate方法，当数据库中存在id=2的Person，在em.close()时会发送一条update语句，而当数据库中不存在id=2的Person，
        * 在em.close()时会发送一条insert语句。
        * merge 一般的作用是合并已经被 EntityManager 脱管的对象合并到数据库中去，如果数据库中不存在则执行类似于 persist 的操作。
         对不同状态下的实例 A ， merge 会产生以下操作 :

        1.       如果 A 是一个 detached 状态的实体，该方法会将 A 的修改提交到数据库，并返回一个新的 managed 状态的实例 A2 ；

        2.       如果 A 是一个 new 状态的实体，该方法会产生一个根据 A 产生的 managed 状态实体 A2 ;

        3.       如果 A 是一个 managed 状态的实体，它的状态不会发生任何改变。但是系统仍会在数据库执行 UPDATE 操作；

        4.       如果 A 是一个 removed 状态的实体，该方法会抛出 IllegalArgumentException 异常。
声明一个新的托管对象，通过merge方法merge进去
*/
        em.refresh(newUser);
        newUser.setName(newName);
        return newUser;
    }
    /**
     * 尝试使用merge()，以及find()2种方法分别实现
     * 更新指定地址为指定用户

     */
    public Address updateAddress(int aid, int uid) {
       /* Address address=new Address();
        address.setId(aid);
        Address newAddress=em.merge(address);
        em.refresh(newAddress);
        User user=new User();
        user.setId(uid);
        User newUser=em.merge(user);
        em.refresh(newUser);
        newAddress.setUser(newUser);
        return null;*/
       User user =em.find(User.class,uid);
       Address address=em.find(Address.class,aid);
       address.setUser(user);
       return null;
    }
    /**
     * 返回指定用户的全部地址，没有返回空集合，而非null

     */
    public List<Address> listAddresses(int uid) {
        User user=em.find(User.class,uid);
        List<Address> list=user.getAddresses();
        List.of(list);
        return list;
    }
/**删除地址*/
    public void removeAddress(int aid) {
        Address address = em.find(Address.class, aid);
        em.remove(address);
        return;
    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     * @param
     */
    public void removeUser(int uid) {
        User user = em.find(User.class, uid);
        em.remove(user);
        return ;
    }



}
