package az.Developia.spring_rest_main;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserrCont {
	@Autowired
	private UserRRep repository;
	@PostMapping
	public void save(@RequestBody Userrentity s) {
		
		repository.save(s);
		
	}
}
