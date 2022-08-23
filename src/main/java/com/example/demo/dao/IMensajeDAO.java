package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Mensaje;

public interface IMensajeDAO extends JpaRepository<Mensaje, Integer>{

}
