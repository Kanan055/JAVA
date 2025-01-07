package az.developia.student_crud.exception;

import org.springframework.validation.BindingResult;

public class MyRuntimeException extends RuntimeException{
	
	public MyRuntimeException(BindingResult result) {
		super();
		this.result = result;
	}

	private static final long serialVersionUID = -2193637097855519208L;
	private BindingResult result;

	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}
	

}
