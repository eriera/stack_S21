package com.ues21.arqprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues21.arqprueba.model.EjemploDetail;

@Repository
public interface EjemploDetailRepository extends JpaRepository<EjemploDetail, Long> {

}
