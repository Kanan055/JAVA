package az.Developia.spring_rest_main.Response;

import jakarta.validation.constraints.AssertFalse.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter



public class StudentDataWrapper {
private List<StudentEntity>student;
private int port;
public List<StudentEntity> getStudent() {
	return student;
}
public void setStudent(List<StudentEntity> student) {
	this.student = student;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
}
