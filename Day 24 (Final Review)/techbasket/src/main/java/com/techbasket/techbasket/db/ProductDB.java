package com.techbasket.techbasket.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techbasket.techbasket.entity.ProductEntity;

@Repository
public interface ProductDB extends CrudRepository<ProductEntity, Integer> {
     @Query(value = "select * from tech_basket.product order by likes desc limit 10", nativeQuery = true)
     public List<ProductEntity> getMostIn();

     @Query(value = "select * from tech_basket.product where name like %?1% or category like %?1% limit ?2,10", nativeQuery = true)
     public List<ProductEntity> findSearch(String name, int page);

     @Query(value = "select count(*) from tech_basket.product where name like %?1% or category like %?1%", nativeQuery = true)
     public long getTotalOf(String name);

     @Query(value = "select * from tech_basket.product order by pid desc limit 10", nativeQuery = true)
     public List<ProductEntity> getMostRe();

     @Query(value = "select json_object('pid',p.pid,'name',name,'price',price,'img',img,'category',category,'count',count(*)) from product p inner join cart c on c.pid = p.pid and c.uid = ?1 group by p.pid", nativeQuery = true)
     public List<Object> getCartProducts(int uid);

     @Query(value = "select * from tech_basket.product where pid = ?", nativeQuery = true)
     public List<ProductEntity> getProduct(int pid);

     @Query(value = "select * from tech_basket.product where sid = ?1 limit ?2,10", nativeQuery = true)
     public List<ProductEntity> thisSellerProducts(int sid, int page);

     @Query(value = "select count(*) from tech_basket.product where sid = ?1", nativeQuery = true)
     public int getSellerProductsCount(int sid);
}
