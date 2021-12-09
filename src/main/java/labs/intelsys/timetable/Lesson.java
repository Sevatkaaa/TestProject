package labs.intelsys.timetable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lesson {
    String name;
    boolean isPractice;
}
