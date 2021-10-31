package demo.graphql.bootstarter.v3;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ScoreController {

  private final List<Score> scores;

  {
    Student xiaomi = new Student(1, "小米");
    Student david = new Student(1, "大卫");
    scores = List.of(
        new Score("chinese", 88, david),
        new Score("english", 80, xiaomi),
        new Score("math", 70, david),
        new Score("chinese", 67, xiaomi),
        new Score("math", 98, xiaomi)
    );
  }

  @MutationMapping(name = "courseScore")
  public List<Score> updateCourseScore(@Argument String course, @Argument int score) {
    return scores.stream()
        .filter(s -> s.getCourse().equals(course))
        .peek(s -> s.setScore(score))
        .collect(Collectors.toList());
  }

  @MutationMapping(name = "studentScore")
  public Score updateStudentScore(@Argument(name = "in") ScoreInput input) {
    Optional<Score> optionalScore = scores.stream()
        .filter(s -> s.getCourse().equals(input.getCourse()) && s.getStudent().getId() == input.getStudentId())
        .findFirst();
    if (optionalScore.isPresent()) {
      optionalScore.get().setScore(input.getScore());
      return optionalScore.get();
    }
    throw new RuntimeException("Score not found");
  }

  @QueryMapping(name = "score")
  public List<Score> score(@Argument String course) {
    if (StringUtils.hasText(course)) {
      return scores.stream().filter(s -> s.getCourse().equals(course)).collect(Collectors.toList());
    }
    return scores;
  }

}
