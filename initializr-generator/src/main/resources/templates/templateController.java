package {{packageName}};

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

import {{basePackageName}}.model.EjemploDetailModel;
import {{basePackageName}}.model.EjemploMasterModel;
import {{basePackageName}}.service.EjemploDetailService;
import {{basePackageName}}.service.EjemploMasterService;

@RestController
public class {{className}}  {
	
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
	public List<EjemploMasterModel> getEjemploMasterbyFechas(@RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
				Date fechaDesde, @RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fechaHasta) {
		
		return ejemploMasterService.getMasterByFechas(fechaDesde, fechaHasta);
	}	

	@GetMapping("/ejemploMaster/{masterId}/byId")
	public EjemploMasterModel getEjemploMasterbyId(@PathVariable Long masterId) {
		return ejemploMasterService.getEjemploMasterById(masterId);
	}
	
	@GetMapping("/ejemploMaster/all")
	public List<EjemploMasterModel> getAllEjemploMaster() {
		return ejemploMasterService.getAllEjemploMaster();
	}
	
	@PutMapping("/ejemploMaster/save")
	public Long createOrUpdateEjemploMaster(@RequestBody EjemploMasterModel ejemploMaster) {
		
		EjemploMasterModel savedEjemploMaster = ejemploMasterService.save(ejemploMaster);
		
		return savedEjemploMaster.getId();
		
	}

	@PutMapping("/ejemploDetail/save")
	public Long createOrUpdateEjemploDetail(@RequestBody EjemploDetailModel ejemploDetail, Long masterId) {
		
		EjemploDetailModel savedEjemploDetail = ejemploDetailService.save(ejemploDetail, masterId);
		
		return savedEjemploDetail.getId();
		
	}
		
}
