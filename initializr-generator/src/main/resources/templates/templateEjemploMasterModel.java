package {{packageName}};

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class {{className}} {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private String atributoString;
    
    @Column(columnDefinition = "date")    
    private Date atributoFecha;
    
    @OneToMany(mappedBy="ejMaster", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<EjemploDetailModel> EjemploDetailModels;

    protected EjemploMasterModel() {}
        

	public EjemploMasterModel(Long id, String atributoString, Date atributoFecha) {
		this.id = id;
		this.atributoString = atributoString;
		this.atributoFecha = atributoFecha;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtributoString() {
		return atributoString;
	}

	public void setAtributoString(String atributoString) {
		this.atributoString = atributoString;
	}

	public Date getAtributoFecha() {
		return atributoFecha;
	}

	public void setAtributoFecha(Date atributoFecha) {
		this.atributoFecha = atributoFecha;
	}


	public List<EjemploDetailModel> getEjemploDetailModels() {
		return EjemploDetailModels;
	}


	public void setEjemploDetailModels(List<EjemploDetailModel> EjemploDetailModels) {
		this.EjemploDetailModels = EjemploDetailModels;
	}
    
    
}