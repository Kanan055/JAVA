package az.Developia.spring_rest_main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.Developia.spring_rest_main.Response.StudentDataWrapper;
import jakarta.validation.Valid;
import lombok.Value;

//crud create read update delete+
@RestController
@RequestMapping
@CrossOrigin
@Api(description="bu servisde telebe ile bagli emeliyyatlar olacaq")

public class StudentMModelMModelCont {
	@Autowired // tanima meqsedli
	private StudentRep repository;

	@GetMapping(path = "/{id}")

	public StudentMModelMModelMModel getStudentMModelMModel(@PathVariable Integer id) {
if(findById.isPresent()) {
	return repository.findById(id).get();
}else {
	throw new OurNorFoundException("id kodu"+id+"olan telebe tapilmadi");
}

	
		
	}

	@GetMapping(path = "/list")
	public StudentDataWrapper findAll() {
	StudentDataWrapper response=new StudentDataWrapper();
	List<StudentEntity>list=repository.findAll();
	response.setPort(4545);
		return list;
	}

	@DeleteMapping(path = "/{id}")
	public void deleteStudentMModelMModel(@PathVariable Integer id) {
		repository.deleteById(id);
	}
@ApiOpertion(value="bu servis yeni telebe qebul edir")
	@PostMapping
	public Integer add(@Valid @RequestBody StudentMModel s,BindingResult br) {
		if(br.hasErrors()) {
		throw new OurValidationException(br,"Melumatin tamliginda problem var");	
		}
		s.setId(null);
		repository.save(s);
		return s.getId();// bazanin front terefinin gormesi ucun
		// modelde oldugu kimi qayidis tipi integer ola biler
	}

	@PutMapping
	public void update(@RequestBody Student s) {
		repository.save(s);
		// modelde oldugu kimi
	}
}
