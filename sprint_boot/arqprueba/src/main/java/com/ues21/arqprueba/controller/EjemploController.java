package com.ues21.arqprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ues21.arqprueba.model.EjemploDetail;
import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.repository.EjemploDetailRepository;
import com.ues21.arqprueba.repository.EjemploMasterRepository;


@RestController
public class EjemploController {
	
	@Autowired
	private EjemploMasterRepository repository;
	
	@Autowired
	private EjemploDetailRepository detailRepository;

	@GetMapping("/masterid/{masterId}")
	public EjemploMaster retrieveMasterPorId(@PathVariable Long masterId) {
		return null;//repository.findById(masterId);
	}

	@GetMapping("/master")
	public List<EjemploMaster> retrieveMaster() {
		return repository.findAll();
	}
	
	@GetMapping("/detail")
	public List<EjemploDetail> retriveDetail(){
		return detailRepository.findAll();
	}
		

}
