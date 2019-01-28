package {{packageName}};

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import {{basePackageName}}.model.EjemploMasterModel;
import {{basePackageName}}.repository.EjemploMasterRepository;

@Service
public class {{className}} {
	
	@Autowired
	EjemploMasterRepository ejemploMasterRepository;
	
	public List<EjemploMasterModel> getMasterByFechas(Date fechaDesde, Date fechaHasta) {
		return ejemploMasterRepository.getMasterByFechas(fechaDesde,fechaHasta);
	}
	
	public EjemploMasterModel getEjemploMasterById(Long ejemploMasterId){
		return ejemploMasterRepository.findById(ejemploMasterId).orElse(null);
	}
	
	public List<EjemploMasterModel> getAllEjemploMaster(){
		return ejemploMasterRepository.findAll();
	}
	
	public EjemploMasterModel save(EjemploMasterModel ejemploMaster) {
		return ejemploMasterRepository.save(ejemploMaster);
	}	
	
}
