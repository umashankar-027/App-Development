package com.example.demo1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.ProductEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>
{
	@Transactional
	
	@Query(value="select * from product",nativeQuery = true)
	public List<ProductEntity>getAll();
	
	@Query(value="select * from product where pid = ?1",nativeQuery = true)
	public List<ProductEntity>getByPid(int pid);
	
	@Query(value="select * from product where name = ?1",nativeQuery = true)
	public Optional<ProductEntity> getByName(String name);
	
	@Query(value="select * from product where category = ?1",nativeQuery = true)
	public List<ProductEntity>getByCategory(String category);
	
	@Query(value="select * from product where price >= ?1",nativeQuery = true)
	public List<ProductEntity>getByPriceG(int price);
	
	@Query(value="select * from product order by likes desc limit 5",nativeQuery = true)
	public List<ProductEntity>getTopSelling();
	
	@Query(value="select * from product where pid <= (select max(pid) from product) and pid >= (select ((select max(pid) from product) - 4)) order by pid desc",nativeQuery = true)
	public List<ProductEntity>getNewArrivals();
	
	@Query(value="select * from product where pid in(select pid from cart where user_id = ?1)",nativeQuery = true)
	public List<ProductEntity>getCartItems(int user_id);
	
	@Modifying
	@Transactional
	@Query(value="delete from product where name = ?1",nativeQuery = true)
	public void deleteByName(String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from product where category = ?1",nativeQuery = true)
	public void deleteByCategory(String category);
}
