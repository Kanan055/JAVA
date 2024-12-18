package com.example.spring_course_prKanan.controller;

import com.example.spring_course_prKanan.entity.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String showStudentForm(Model model) {
        // Yeni bir boş StudentModel obyekti yaradılır və modeli ötürülür
        StudentModel student = new StudentModel();
        model.addAttribute("student", student);
        
        // "student-form" adlı view-i geri qaytarır
        return "student-form";
    }

    @PostMapping("/student")
    public String submitStudentForm(@ModelAttribute("student") StudentModel student, Model model) {
        // Gələn tələbə məlumatları bu addımda işlənir
        model.addAttribute("message", "Tələbə məlumatları uğurla qəbul edildi!");
        model.addAttribute("student", student);

        // "student-result" adlı view-i geri qaytarır
        return "student-result";
    }
}
