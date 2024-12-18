package az.Developia.spring_rest_main;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Userrentity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; 
	    private String name;
	    private String password;
	    private String address;
	    private String phone;


	    

	
	    public Userrentity(String name, String password, String address, String phone) {
	        this.name = name;
	        this.password = password;
	        this.address = address;
	        this.phone = phone;
	    }

	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id=id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	
	
	    public String toString() {
	        return "UserEntity{" +
	                "id=" + id +
	                ", name=" + name + ':' +
	                
	                ", password='" + password + ':' +
	                ", address='" + address + ':' +
	                ", phone='" + phone + ':' +
	                '}';
	    }
}
