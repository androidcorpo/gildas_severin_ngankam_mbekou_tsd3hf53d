package fr.anywr.testanywr;

import fr.anywr.testanywr.infrastructure.dao.ClassRoom;
import fr.anywr.testanywr.infrastructure.dao.Student;
import fr.anywr.testanywr.infrastructure.dao.Teacher;
import fr.anywr.testanywr.infrastructure.repository.ClassRoomRepository;
import fr.anywr.testanywr.infrastructure.repository.StudentRepository;
import fr.anywr.testanywr.infrastructure.repository.TeacherRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TestAnywrApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestAnywrApplication.class, args);
  }
}
