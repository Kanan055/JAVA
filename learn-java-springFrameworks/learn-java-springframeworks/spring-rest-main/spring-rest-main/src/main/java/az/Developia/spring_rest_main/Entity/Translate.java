package az.Developia.spring_rest_main.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="translates")
public class Translate {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String language;
private String keyData;
private String valueData;
}
