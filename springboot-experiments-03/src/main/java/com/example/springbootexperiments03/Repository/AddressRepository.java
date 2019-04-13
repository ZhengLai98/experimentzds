package com.example.springbootexperiments03.Repository;

import com.example.springbootexperiments03.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select a from Address a where a.detail=:detail")
    List<Address> list(@Param("detail") String detail);
}
