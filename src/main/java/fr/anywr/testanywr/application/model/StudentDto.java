package fr.anywr.testanywr.application.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@Setter
@Builder
public class StudentDto {
  private String classRoomName;
  private String teacherFirstName;
  private String studentLastName;
  private String studentFirstName;
  private String teacherLastName;
}
