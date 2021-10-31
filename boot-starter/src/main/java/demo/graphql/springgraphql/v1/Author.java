package demo.graphql.springgraphql.v1;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Author {
  private Integer id;

  private String name;

  private SexEnum sex;

  private List<Book> books;
}
