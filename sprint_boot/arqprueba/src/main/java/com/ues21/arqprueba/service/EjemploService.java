package com.ues21.arqprueba.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.repository.EjemploMasterRepository;

@Service
public class EjemploService{
	
	@Autowired
	EjemploMasterRepository ejemploMasterRepository;
	
	public List<EjemploMaster> getMasterByFecha(Date fecha) {
		return ejemploMasterRepository.getMasterByFecha(fecha);
	}
	
	public EjemploMaster getEjemploMasterById(Long ejemploMasterId){
		return ejemploMasterRepository.findById(ejemploMasterId).orElse(null);
	}

}
