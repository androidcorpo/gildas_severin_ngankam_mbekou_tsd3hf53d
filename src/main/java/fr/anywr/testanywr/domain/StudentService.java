package fr.anywr.testanywr.domain;

import fr.anywr.testanywr.application.model.PageDto;
import fr.anywr.testanywr.application.model.PageSettings;
import lombok.NonNull;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
public interface StudentService {
  PageDto getStudentList(@NonNull PageSettings pageSettings, String classRoomName, String teacherFullName);
}
