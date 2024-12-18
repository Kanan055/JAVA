package az.Developia.spring_rest_main.Cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.Developia.spring_rest_main.LangRep;
import jakarta.validation.constraints.AssertFalse.List;
import net.bytebuddy.asm.Advice.Local;

@RestController
@RequestMapping(path="/translates")
public class TranslateRestCOnt {
	
	@Autowired
	private LangRep repository;
@GetMapping
public java.util.List<TranslateRestCOnt> getLang (@RequestHeader(value="Accept-Language")Local locale){
	String lang=locale.getLanguage();
	return repository.findByLanguage(lang);
	
}
public LangRep getRepository() {
	return repository;
}
public void setRepository(LangRep repository) {
	this.repository = repository;
}

}
