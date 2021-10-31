package demo.graphql.springgraphql.v2;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
  @QueryMapping(name = "course")
  public Course course(@Argument String id) {
    Course cn = new Course("cn", "Chinese", 100);
    Course en = new Course("en", "English", 50);
    Course math = new Course("math", "Math", 110);
    List<Course> courses = List.of(cn, en, math);
    return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
  }
}
