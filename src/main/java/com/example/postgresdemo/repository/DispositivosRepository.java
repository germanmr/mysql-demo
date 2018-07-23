package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.PrestadorPK;

@Repository
public interface DispositivosRepository extends JpaRepository<Dispositivo, PrestadorPK> {

    List<Dispositivo> findAllBydispositivoPKPrestadorPKIn(List<PrestadorPK> id);

    Dispositivo findBydispositivoPK(Dispositivo dispositivo);

}
