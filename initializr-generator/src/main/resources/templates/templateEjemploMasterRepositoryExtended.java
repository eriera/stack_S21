package {{packageName}};

import java.util.Date;
import java.util.List;

import {{basePackageName}}.model.EjemploMasterModel;

public interface {{className}} {

	List<EjemploMasterModel> getMasterByFechas(Date fechaDesde, Date fechaHasta);

}