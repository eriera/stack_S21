package com.ues21.arqprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues21.arqprueba.model.EjemploMaster;

@Repository
public interface EjemploMasterRepository extends JpaRepository<EjemploMaster, Long>, EjemploMasterRepositoryExtended{

}