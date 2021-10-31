package demo.graphql.bootstarter.v3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreInput {
  private String course;
  private int score;
  private int studentId;
}
