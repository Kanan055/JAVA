package az.Developia.spring_rest_main;

import org.springframework.validation.BindingResult;

public class OurValidationException extends RuntimeException {
	private BindingResult br;
public OurValidationException(BindingResult br,String message) {
	super(message);
	this.br=br;
}
public BindingResult getbr() {
	return br;
}
}
