package fr.anywr.testanywr.infrastructure.service;

import fr.anywr.testanywr.application.model.PageDto;
import fr.anywr.testanywr.application.model.PageSettings;
import fr.anywr.testanywr.application.model.StudentDto;
import fr.anywr.testanywr.domain.StudentService;
import fr.anywr.testanywr.infrastructure.dao.Student;
import fr.anywr.testanywr.infrastructure.repository.StudentRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  @Override
  public PageDto getStudentList(
      @NonNull PageSettings pageSettings, String classRoomName, String teacherFullName) {
    Pageable pageable = PageRequest.of(pageSettings.getPage(), pageSettings.getItemPerPage());
    Page<Student> students;
    if (Objects.nonNull(classRoomName) && Objects.nonNull(teacherFullName)) {
      students =
          studentRepository.findStudentByClassRoomNameAndTeacherFullName(
              classRoomName, teacherFullName, pageable);
    } else if (Objects.nonNull(classRoomName)) {
      students = studentRepository.findStudentByClassRoomName(classRoomName, pageable);
    } else {
      students = studentRepository.findAll(pageable);
    }
    return map(students);
  }

  private PageDto map(Page<Student> students) {
    List<StudentDto> collect =
        students.getContent().stream()
            .filter(Objects::nonNull)
            .map(this::buildStudentDto)
            .collect(Collectors.toList());
    return PageDto.builder()
        .item(collect)
        .size(students.getTotalElements())
        .pages(students.getTotalPages())
        .build();
  }

  private StudentDto buildStudentDto(Student student) {
    StudentDto studentDto =
        StudentDto.builder()
            .studentFirstName(student.getFirstName())
            .studentLastName(student.getLastName())
            .classRoomName(student.getClassRoom().getName())
            .build();
    if (Objects.nonNull(student.getClassRoom().getTeacher())) {
      studentDto.setTeacherLastName(student.getClassRoom().getTeacher().getLastName());
      studentDto.setTeacherFirstName(student.getClassRoom().getTeacher().getFirstName());
    }
    return studentDto;
  }
}
