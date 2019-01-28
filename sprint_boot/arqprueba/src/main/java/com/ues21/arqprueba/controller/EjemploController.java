package com.ues21.arqprueba.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ues21.arqprueba.model.EjemploDetail;
import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.service.EjemploDetailService;
import com.ues21.arqprueba.service.EjemploMasterService;


@RestController
public class EjemploController {
	
	@Autowired
	private EjemploMasterService ejemploMasterService;
	
	@Autowired
	private EjemploDetailService ejemploDetailService;
	
	@GetMapping("/")
	public List<String> dummyResponse(){
		List<String> result = new ArrayList<String>();
		result.add("Dummy");
		return result;
	}

	
	@PostMapping("/ejemploMaster/dates")
	public List<EjemploMaster> getEjemploMasterbyFechas(@RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fechaDesde, 
			@RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fechaHasta) {
		
		return ejemploMasterService.getMasterByFechas(fechaDesde, fechaHasta);
	}	

	@GetMapping("/ejemploMaster/{masterId}/byId")
	public EjemploMaster getEjemploMasterbyId(@PathVariable Long masterId) {
		return ejemploMasterService.getEjemploMasterById(masterId);
	}
	
	@GetMapping("/ejemploMaster/all")
	public List<EjemploMaster> getAllEjemploMaster() {
		return ejemploMasterService.getAllEjemploMaster();
	}
	
	@PutMapping("/ejemploMaster/save")
	public Long createOrUpdateEjemploMaster(@RequestBody EjemploMaster ejemploMaster) {
		
		EjemploMaster savedEjemploMaster = ejemploMasterService.save(ejemploMaster);
		
		return savedEjemploMaster.getId();
		
	}

	@PutMapping("/ejemploDetail/save")
	public Long createOrUpdateEjemploDetail(@RequestBody EjemploDetail ejemploDetail, Long masterId) {
		
		EjemploDetail savedEjemploDetail = ejemploDetailService.save(ejemploDetail, masterId);
		
		return savedEjemploDetail.getId();
		
	}

		

}
