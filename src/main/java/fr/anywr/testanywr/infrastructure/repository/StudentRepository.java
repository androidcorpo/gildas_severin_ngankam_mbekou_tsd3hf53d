package fr.anywr.testanywr.infrastructure.repository;

import fr.anywr.testanywr.infrastructure.dao.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Query(
      "select s from Student s join s.classRoom c join c.teacher t where c.name =?1 and (concat(t.firstName,' ', t.lastName) like concat('%',?2,'%'))")
  Page<Student> findStudentByClassRoomNameAndTeacherFullName(String classRoomName, String teacherFullName, Pageable pageable);
  @Query(
      "select s from Student s join s.classRoom c join c.teacher t where c.name =?1 or (concat(t.firstName, ' ',t.lastName) like concat('%',?2,'%'))")
  Page<Student> findStudentByClassRoomNameOrTeacherFullName(String classRoomName, String teacherFullName, Pageable pageable);
}
