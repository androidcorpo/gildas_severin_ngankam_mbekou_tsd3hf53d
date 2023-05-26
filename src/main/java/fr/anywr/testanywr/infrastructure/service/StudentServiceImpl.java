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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  @Override
  public PageDto getStudentList(@NonNull PageSettings pageSettings) {
    List<Sort.Order> sort = pageSettings.buildSortOrder();
    Pageable pageable =
        PageRequest.of(pageSettings.getPage(), pageSettings.getItemPerPage(), Sort.by(sort));
    Page<Student> students;
    if (sort.isEmpty()) students = studentRepository.findAllCustomDefault(pageable);
    else {
      students = studentRepository.findAllCustom(pageable);
    }
    return map(students);
  }


  private PageDto map(Page<Student> students) {

    List<StudentDto> collect =
        students.getContent().stream()
            .filter(Objects::nonNull)
            .map(
                student ->
                    StudentDto.builder()
                        .teacherLastName(student.getClassRoom().getTeacher().getLastName())
                        .teacherFirstName(student.getClassRoom().getTeacher().getFirstName())
                        .studentFirstName(student.getFirstName())
                        .studentLastName(student.getLastName())
                        .classRoomName(student.getClassRoom().getName())
                        .build())
            .collect(Collectors.toList());
    return PageDto.builder()
        .item(collect)
        .size(students.getTotalElements())
        .pages(students.getTotalPages())
        .build();
  }
}
