package com.example.demo.dao.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.jpa.entity.EntityTransac;
@Repository
public interface RepoTransac extends JpaRepository<EntityTransac,String>{

}
