package {{packageName}};

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class {{className}}  {
	
//	@Autowired
//	private EjemploMasterRepository repository;
	
	@GetMapping("/")
	public List<String> dummyResponse(){
		List<String> result = new ArrayList<String>();
		result.add("Dummy");
		return result;
	}
		

}
