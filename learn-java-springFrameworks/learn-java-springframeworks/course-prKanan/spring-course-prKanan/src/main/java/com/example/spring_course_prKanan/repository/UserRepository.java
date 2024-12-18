
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import org.springframework.stereotype.Repository;

import com.example.spring_course_prKanan.entity.AdminModel;


@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    public void add(AdminModel admin) {
        try (Connection conn = dataSource.getConnection()) {
     
            PreparedStatement ps = conn.prepareStatement("insert into user(username, password, enabled) values(?, ?, ?);");
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setInt(3, 1);  
            ps.executeUpdate();

            ps = conn.prepareStatement("insert into authorities(username, authority) values(?, ?);");
            ps.setString(1, admin.getUsername());
            ps.setString(2, "ROLE_ADMIN");
     
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }