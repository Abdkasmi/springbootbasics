package be.s19.first_project.student;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping //is it needed? works without
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping //is it needed? works without
    public void addNewStudent(Student student, HttpServletResponse response) {
        try{
            List<Student> allStudents = studentRepository.findAll();
            for (Student s : allStudents) {
                if (Objects.equals(student.getEmail(), s.getEmail())){
                    System.out.println("email: " + student.getEmail() + " is already taken");
                    response.sendError(400);
                }
            }
            studentRepository.save(student);
        }
        catch (Exception e){
            System.out.println("exception: "+ e);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        System.out.println("Student successfully deleted\n");
    }

}
