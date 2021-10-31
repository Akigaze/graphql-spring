package demo.graphql.bootstarter.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

  private String bookName;

  private boolean publish;

  private float price;
}