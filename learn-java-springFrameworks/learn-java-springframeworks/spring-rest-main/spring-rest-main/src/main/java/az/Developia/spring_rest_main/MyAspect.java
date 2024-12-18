package az.Developia.spring_rest_main;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice//hazir annotasia

public class MyAspect {
@ExceptionHandler
@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public ErrorResponse handlerOurValidationException(OurValidationException exc) {
	ErrorResponse res=new ErrorResponse();
	BindingResult br=exc.getbr();
	String m=exc.getMessage();
	res.setMessage(m);
	List<String> validations=new ArrayList<>();
	for(FieldError err:br.getFieldErrors()) {
		
		validations.add(err.getField()+":::"+err.getDefaultMessage());
		
	}
res.setValidations(validations);
return res;
}
}
