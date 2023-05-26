package fr.anywr.testanywr.application.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {
  private static final long serialVersionUID = 5926468583005150707L;
  private String username;
  private String password;
  public String getUsername() {
    return this.username;
  }
  public String getPassword() {
    return this.password;
  }
}
