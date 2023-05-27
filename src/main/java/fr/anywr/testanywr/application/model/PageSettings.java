package fr.anywr.testanywr.application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@Setter
@NoArgsConstructor
public class PageSettings {
  private int page;
  private int itemPerPage;
  private String[] sorts;

  public PageSettings(int page, int itemPerPage) {
    this.page = page;
    this.itemPerPage = itemPerPage;
  }

  public List<Sort.Order> buildSortOrder() {
    List<Sort.Order> orders = new ArrayList<>();
    if (Objects.nonNull(sorts)) {
      if (sorts[0].contains(","))
        for (String sort : sorts) {
          String[] current = sort.split(",");
          orders.add(new Sort.Order(getSortDirection(current[1]), current[0]));
        }
      else {
        orders.add(new Sort.Order(getSortDirection(sorts[1]), sorts[0]));
      }
    }
    return orders;
  }

  private Sort.Direction getSortDirection(String direction) {
    if ("asc".equals(direction)) {
      return Sort.Direction.ASC;
    } else {
      return Sort.Direction.DESC;
    }
  }
}
