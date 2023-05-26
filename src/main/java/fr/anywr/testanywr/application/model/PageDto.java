package fr.anywr.testanywr.application.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@Setter
@Builder
public class PageDto {
  private List<StudentDto> item;
  private long size;
  private long pages;
  private long currentPage;
}
