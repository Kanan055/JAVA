package az.Developia.spring_rest_main;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRep extends JpaRepository<StudentMModel, Integer>{
//əlaqəli verilənlər bazası əməliyyatlarını asanlaşdır
}
