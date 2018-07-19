package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Dispositivo;

@Repository
public interface DispositivosRepository extends JpaRepository<Dispositivo, Long> {

    List<Dispositivo> findByregistrationidIn(List<String> registrationIds);

}
