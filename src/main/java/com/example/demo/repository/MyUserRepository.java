package com.example.demo.repository;

import com.example.demo.entity.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<Myuser,String> {

}
