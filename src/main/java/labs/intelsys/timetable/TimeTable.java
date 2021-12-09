package labs.intelsys.timetable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {
    Lesson subject;
    Teacher teacher;
    Room room;
}
