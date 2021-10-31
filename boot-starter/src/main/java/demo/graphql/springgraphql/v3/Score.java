package demo.graphql.springgraphql.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Score {
  private String course;
  private int score;
  private Student student;
}
