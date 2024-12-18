package az.Developia.spring_rest_main;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class StudentMModel {

	@Id
	@GeneratedValue(strategy=GenerationType.Identity)
	private Integer id;
	private String name;
	@NotBlank
	@NotNull//bos olmaz
	@Size(min=3,message="Ad minimum 3 simvol olmalidir")
	@Size(max=8,message="Ad maksimum  8 simvol olmalidir");
	private Integer point;
	@Min(value=20,message ="Minimum bal 20")
	@Max(value=20,message ="Maksimum bal 100")
	@ApiModelProperty(value ="Telebe qiymeti min 20 max 100 BAL")
	public Integer getId() {
		return id;
		
	}
	public void setId(Integer id) {
		this.id=id;
		
	}
	public String getName(String name) {
		this.name=name;
		
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point=point;
	//deyeri avto generasiya edir
}
