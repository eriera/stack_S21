package {{packageName}};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import {{basePackageName}}.model.EjemploMasterModel;

@Repository
public interface {{className}} extends JpaRepository<EjemploMasterModel, Long>{

}
