package demo.graphql.bootstarter.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {
  private String id;
  private String name;
  private int capacity;
}
