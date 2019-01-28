package com.ues21.arqprueba.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.repository.EjemploMasterRepository;

@Service
public class EjemploMasterService{
	
	@Autowired
	EjemploMasterRepository ejemploMasterRepository;
	
	public List<EjemploMaster> getMasterByFechas(Date fechaDesde, Date fechaHasta) {
		return ejemploMasterRepository.getMasterByFechas(fechaDesde,fechaHasta);
	}
	
	public EjemploMaster getEjemploMasterById(Long ejemploMasterId){
		return ejemploMasterRepository.findById(ejemploMasterId).orElse(null);
	}
	
	public List<EjemploMaster> getAllEjemploMaster(){
		return ejemploMasterRepository.findAll();
	}
	
	public EjemploMaster save(EjemploMaster ejemploMaster) {
		return ejemploMasterRepository.save(ejemploMaster);
	}

}
