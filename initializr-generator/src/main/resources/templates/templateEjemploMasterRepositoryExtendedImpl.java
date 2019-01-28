package {{packageName}};

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import {{basePackageName}}.model.EjemploMasterModel;
import {{basePackageName}}.repository.EjemploMasterRepositoryExtended;

public class {{className}}  implements EjemploMasterRepositoryExtended{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<EjemploMasterModel> getMasterByFechas(Date fechaDesde, Date fechaHasta) {
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EjemploMasterModel> query = builder.createQuery(EjemploMasterModel.class);
        Root<EjemploMasterModel> root = query.from(EjemploMasterModel.class);
		
        query.select(root).where(builder.between(root.get("atributoFecha"), fechaDesde, fechaHasta));

		return entityManager.createQuery(query).getResultList();
	}

}