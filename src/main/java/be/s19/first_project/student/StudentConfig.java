package be.s19.first_project.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student abdoullah = new Student(
                    "Abdoullah",
                    LocalDate.of(2002, Month.FEBRUARY, 9),
                    "kasmiabdoullah@gmail.com"
            );
            Student krillin = new Student(
                    "krillin",
                    LocalDate.of(1023, Month.JANUARY, 1),
                    "krillin@krillin.krillin"
            );
            repository.saveAll(List.of(abdoullah, krillin));
        };
    }
}
