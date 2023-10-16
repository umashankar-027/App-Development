package com.techbasket.techbasket.db;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techbasket.techbasket.entity.CartEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CartDb extends CrudRepository<CartEntity, Integer> {
     @Transactional
     @Modifying
     @Query(value = "delete FROM tech_basket.cart where uid = ?1 and pid =?2", nativeQuery = true)
     public void deleteByUidPid(int uid, int pid);

     @Transactional
     @Modifying
     @Query(value = "delete FROM tech_basket.cart where uid =?1 and pid = ?2 limit 1;", nativeQuery = true)
     public void deleteByUidPidOne(int uid, int pid);

}
