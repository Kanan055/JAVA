package az.Developia.spring_rest_main;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
private String message;
private ArrayList<String>validations;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ArrayList<String> getValidations() {
	return validations;
}
public void setValidations(List<String> validations) {
	this.validations = validations;
}
}
