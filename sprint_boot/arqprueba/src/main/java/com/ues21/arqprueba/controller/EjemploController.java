package com.ues21.arqprueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ues21.arqprueba.model.EjemploDetail;
import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.repository.EjemploDetailRepository;
import com.ues21.arqprueba.repository.EjemploMasterRepository;
import com.ues21.arqprueba.service.EjemploService;


@RestController
public class EjemploController {
	
	@Autowired
	private EjemploMasterRepository repository;
	
	@Autowired
	private EjemploDetailRepository detailRepository;
	
	@Autowired
	private EjemploService ejemploService;
	
	@GetMapping("/")
	public List<String> dummyResponse(){
		List<String> result = new ArrayList<String>();
		result.add("Dummy");
		
		ejemploService.getEjemploMasterById(1l);
		System.out.println(ejemploService.getEjemploMasterById(1l));
		
		return result;
	}

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
