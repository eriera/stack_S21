package com.ues21.arqprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues21.arqprueba.model.EjemploDetail;
import com.ues21.arqprueba.repository.EjemploDetailRepository;
import com.ues21.arqprueba.repository.EjemploMasterRepository;

@Service
public class EjemploDetailService {
	
	@Autowired
	EjemploDetailRepository ejemploDetailRepository;
	
	@Autowired
	EjemploMasterRepository ejemploMasterRepository;
	
	
	public EjemploDetail getEjemploMasterById(Long ejemploDetailId){
		return ejemploDetailRepository.findById(ejemploDetailId).orElse(null);
	}
	
	public EjemploDetail save(EjemploDetail ejemploDetail, Long masterId) {
		ejemploDetail.setEjMaster(ejemploMasterRepository.findById(masterId).orElse(null));
		return ejemploDetailRepository.save(ejemploDetail);
	}	

}
