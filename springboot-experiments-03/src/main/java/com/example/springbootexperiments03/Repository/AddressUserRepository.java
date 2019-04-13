package com.example.springbootexperiments03.Repository;

import com.example.springbootexperiments03.Entity.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddressUserRepository extends JpaRepository<AddressUser,Integer> {
    /*在UserAddressRepository接口中，声明基于user name属性address detail属性，查询详细的useraddress对象的方法*/

    @Query("select au from AddressUser au where au.user.name=:name AND au.address.detail=:detail")
    AddressUser find(@Param("name") String name,@Param("detail") String detail);
}
