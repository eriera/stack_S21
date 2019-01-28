package com.ues21.arqprueba.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ues21.arqprueba.model.EjemploMaster;
import com.ues21.arqprueba.repository.EjemploMasterRepositoryExtended;

public class EjemploMasterRepositoryExtendedImpl implements EjemploMasterRepositoryExtended{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<EjemploMaster> getMasterByFechas(Date fechaDesde, Date fechaHasta) {
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EjemploMaster> query = builder.createQuery(EjemploMaster.class);
        Root<EjemploMaster> root = query.from(EjemploMaster.class);
		
        query.select(root).where(builder.between(root.get("atributoFecha"), fechaDesde, fechaHasta));

		return entityManager.createQuery(query).getResultList();
	}

}
