package com.ues21.arqprueba.repository;

import java.util.Date;
import java.util.List;

import com.ues21.arqprueba.model.EjemploMaster;

public interface EjemploMasterRepositoryExtended {
	
	List<EjemploMaster> getMasterByFechas(Date fechaDesde, Date fechaHasta);

}
