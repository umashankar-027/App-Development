package com.example.demo1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>
{
	public Optional<UserEntity> findByName(String name);
}
