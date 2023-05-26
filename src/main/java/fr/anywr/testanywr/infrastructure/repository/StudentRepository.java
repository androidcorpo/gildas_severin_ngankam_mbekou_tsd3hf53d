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
  Page<Student> findAll(Pageable pageable);
  @Query("select s from Student s join s.classRoom c where c.name =?1")
  Page<Student> findStudentByClassRoomName(String classRoomName, Pageable pageable);

  @Query(
      "select s from Student s join s.classRoom c join c.teacher t where c.name =?1 and (t.firstName like %?2% or t.lastName like %?2%)")
  Page<Student> findStudentByClassRoomNameAndTeacherFullName(String classRoomName, String teacherFullName, Pageable pageable);
}
