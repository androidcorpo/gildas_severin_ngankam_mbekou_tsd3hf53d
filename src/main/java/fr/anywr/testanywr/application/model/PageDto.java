package fr.anywr.testanywr.application.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@Builder
public class PageDto {
  private List<StudentDto> item;
  private long size;
  private long pages;
  private long currentPage;
}
