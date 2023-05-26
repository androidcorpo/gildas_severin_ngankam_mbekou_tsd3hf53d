package fr.anywr.testanywr.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@Getter
@AllArgsConstructor
public class JwtResponse implements Serializable {
  private static final long serialVersionUID = -8091879091924046844L;
  private final String jwtToken;
}
