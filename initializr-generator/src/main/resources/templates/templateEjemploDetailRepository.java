package {{packageName}};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import {{basePackageName}}.model.EjemploDetailModel;

@Repository
public interface {{className}} extends JpaRepository<EjemploDetailModel, Long>{

}
