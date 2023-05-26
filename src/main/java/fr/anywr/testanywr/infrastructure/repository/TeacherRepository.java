package fr.anywr.testanywr.infrastructure.repository;

import fr.anywr.testanywr.infrastructure.dao.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
