package {{packageName}};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import {{basePackageName}}.model.EjemploDetailModel;
import {{basePackageName}}.repository.EjemploDetailRepository;
import {{basePackageName}}.repository.EjemploMasterRepository;

@Service
public class {{className}} {
	
	@Autowired
	EjemploDetailRepository ejemploDetailRepository;
	
	@Autowired
	EjemploMasterRepository ejemploMasterRepository;
	
	
	public EjemploDetailModel getEjemploMasterById(Long ejemploDetailId){
		return ejemploDetailRepository.findById(ejemploDetailId).orElse(null);
	}
	
	public EjemploDetailModel save(EjemploDetailModel ejemploDetail, Long masterId) {
		ejemploDetail.setEjMaster(ejemploMasterRepository.findById(masterId).orElse(null));
		return ejemploDetailRepository.save(ejemploDetail);
	}		
}
