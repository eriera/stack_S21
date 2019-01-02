package com.ues21.arqprueba.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EjemploDetail{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull    
    private String atributoDetalle;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EjemploMaster ejMaster;    
    
    
    protected EjemploDetail() {}    
    
	public EjemploDetail(Long id, String atributoDetalle, EjemploMaster ejMaster) {
		this.id = id;
		this.atributoDetalle = atributoDetalle;
		this.ejMaster = ejMaster;
	}

	public EjemploDetail(String atributoDetalle, EjemploMaster ejMaster) {
		this.atributoDetalle = atributoDetalle;
		this.ejMaster = ejMaster;
	}	
	
	public String getAtributoDetalle() {
		return atributoDetalle;
	}
	public void setAtributoDetalle(String atributoDetalle) {
		this.atributoDetalle = atributoDetalle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public EjemploMaster getEjMaster() {
		return ejMaster;
	}

	public void setEjMaster(EjemploMaster ejMaster) {
		this.ejMaster = ejMaster;
	}


	
}
