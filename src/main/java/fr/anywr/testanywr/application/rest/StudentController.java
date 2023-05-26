package fr.anywr.testanywr.application.rest;

import fr.anywr.testanywr.application.model.PageDto;
import fr.anywr.testanywr.application.model.PageSettings;
import fr.anywr.testanywr.domain.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;

  @GetMapping
  PageDto getList(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "3") int itemPerPage,
      @RequestParam(required = false) String[] sorts) {
    PageSettings settings = new PageSettings(page, itemPerPage, sorts);
    return studentService.getStudentList(settings);
  }
  
}
