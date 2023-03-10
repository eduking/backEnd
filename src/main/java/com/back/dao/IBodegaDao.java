package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.model.Bodega;

public interface IBodegaDao extends JpaRepository<Bodega,Integer>{
    
    
}
