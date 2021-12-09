package labs.intelsys.timetable;


import java.util.*;
import java.util.stream.Collectors;

public class UniversityTimeTable {
    public static void main(String[] args) {
        Lesson l1 = new Lesson("math", true);
        Lesson l2 = new Lesson("math", false);
        Lesson l3 = new Lesson("phis", false);
        Lesson l4 = new Lesson("math", true);
        Lesson l5 = new Lesson("math", false);
        Lesson l6 = new Lesson("phis", false);
        Lesson l7 = new Lesson("phis", false);
        Lesson l8 = new Lesson("phis", false);
        Lesson l9 = new Lesson("math", false);
        Lesson l10 = new Lesson("phis", false);
        Lesson l11 = new Lesson("phis", false);
        Lesson l12 = new Lesson("phis", false); // error - too many lectures
        List<Lesson> lessons = Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
//        List<Lesson> lessons = Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8);
//        List<Lesson> lessons = Arrays.asList(l1, l4);
        Teacher lr1 = new Teacher("Sov", "math");
        Teacher lr2 = new Teacher("Lis", "math");
        Teacher lr3 = new Teacher("Lis", "phis");
//        Teacher lr4 = new Teacher("Ol", "math");
//        List<Teacher> teachers = Arrays.asList(lr1, lr2, lr3, lr4);
        List<Teacher> teachers = Arrays.asList(lr1, lr2, lr3);
        Room r1 = new Room("301", true);
        Room r2 = new Room("302", false);
        Room r3 = new Room("303", true);
//        Room r4 = new Room("304", false);
//        List<Room> rooms = Arrays.asList(r1, r2, r3, r4);
        List<Room> rooms = Arrays.asList(r1, r2, r3);
        Map<String, Integer> schedule = new HashMap<>();
        schedule.put("1Monday", 3);
        schedule.put("2Tuesday", 2);
        schedule.put("3Wednesday", 3);
        schedule.put("4Thursday", 1);
        schedule.put("5Friday", 0);
        try {
            Map<String, Map<Integer, List<TimeTable>>> timeTable = getTimetable(lessons, teachers, rooms, schedule);
//            Map<String, Map<Integer, List<TimeTable>>> timeTable = getTimetable1(lessons, teachers, rooms, schedule);
            System.out.println("Monday");
            printDay(timeTable.get("1Monday"));
            System.out.println("Tuesday");
            printDay(timeTable.get("2Tuesday"));
            System.out.println("Wednesday");
            printDay(timeTable.get("3Wednesday"));
            System.out.println("Thursday");
            printDay(timeTable.get("4Thursday"));
            System.out.println("Friday");
            printDay(timeTable.get("5Friday"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printDay(Map<Integer, List<TimeTable>> day) {
        day.keySet().stream().forEach(k -> {
            System.out.println("Lesson number " + k);
            if (day.get(k).isEmpty()) {
                System.out.println("Nothing");
            } else {
                day.get(k).stream().forEach(t -> System.out.println("Room " + t.getRoom().getName() + " teacher " + t.getTeacher().getName() + " subject " + t.getSubject().getName() + " " + (t.getSubject().isPractice ? "practice" : "lecture")));
            }
        });
        System.out.println();
    }

    private static Map<String, Map<Integer, List<TimeTable>>> getTimetable(List<Lesson> lessons, List<Teacher> teachers, List<Room> rooms, Map<String, Integer> schedule) {
        Map<String, Map<Integer, List<TimeTable>>> timetable = new HashMap<>();
        List<Lesson> prLessons = lessons.stream().filter(l -> l.isPractice).collect(Collectors.toList());
        List<Lesson> lecLessons = lessons.stream().filter(l -> !l.isPractice).collect(Collectors.toList());
        List<Map.Entry<String, Integer>> sortedDays = schedule.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedDays.size(); i++) {
            Map.Entry<String, Integer> day = sortedDays.get(i);
            Integer subjectsNum = day.getValue();
            Map<Integer, List<TimeTable>> daySchedule = new HashMap<>();
            timetable.put(day.getKey(), daySchedule);
            for (int j = 0; j < subjectsNum; j++) {
                List<TimeTable> subjDaySchedule = new ArrayList<>();
                daySchedule.put(j + 1, subjDaySchedule);
                List<Room> validPracticeRooms = rooms.stream().filter(r -> r.isPractice).collect(Collectors.toList());
                List<Room> validLectureRooms = rooms.stream().filter(r -> !r.isPractice).collect(Collectors.toList());
                List<Teacher> validTeachers = new ArrayList<>(teachers);
                int iii = 0;
                while(iii < lecLessons.size()) {
                    boolean da = addLectures(lecLessons, subjDaySchedule, validLectureRooms, validTeachers);
                    if (da) {
                        break;
                    }
                    iii++;
                }
                Teacher teacher;
                int iLesson;
                Lesson lecture;
                // add practices
                validPracticeRooms.addAll(validLectureRooms);
                for (int k = 0; k < validPracticeRooms.size(); k++) {
                    // find teacher
                    teacher = null;
                    iLesson = 0;
                    if (prLessons.isEmpty()) {
                        break;
                    }
                    lecture = prLessons.get(iLesson);
                    while (true) {
                        for (int ii = 0; ii < validTeachers.size(); ii++) {
                            Teacher curTeacher = validTeachers.get(ii);
                            if (subjDaySchedule.stream().map(t -> t.getTeacher().getName()).collect(Collectors.toList()).contains(curTeacher.getName())) {
                                continue;
                            }
                            if (curTeacher.getSubject().equals(lecture.getName())) {
                                teacher = curTeacher;
                                break;
                            }
                        }
                        if (teacher != null) {
                            break;
                        }
                        if (iLesson == prLessons.size() - 1) {
                            break;
                        }
                        lecture = prLessons.get(++iLesson);
                    }
                    if (teacher != null) {
                        prLessons.remove(lecture);
                        TimeTable timeTable = new TimeTable(lecture, teacher, validPracticeRooms.get(k));
                        subjDaySchedule.add(timeTable);
                        validTeachers.remove(teacher);
                        validPracticeRooms.remove(k);
                    }
                }
            }
        }
        if (!lecLessons.isEmpty() || !prLessons.isEmpty()) {
            throw new IllegalArgumentException("It is not possible to create a timetable");
        }
        return timetable;
    }

    private static boolean addLectures(List<Lesson> lecLessons, List<TimeTable> subjDaySchedule, List<Room> validLectureRooms, List<Teacher> validTeachers) {
        if (lecLessons.isEmpty()) {
            return true;
        }
        int iLesson = 0;
        Lesson lecture = lecLessons.get(iLesson);
        if (validLectureRooms.isEmpty()) {
            return true;
        }
        Room room = validLectureRooms.get(0);
        Teacher teacher = null;
        // find lecturer
        while (true) {
            for (int k = 0; k < validTeachers.size(); k++) {
                Teacher curTeacher = validTeachers.get(k);
                if (subjDaySchedule.stream().map(t -> t.getTeacher().getName()).collect(Collectors.toList()).contains(curTeacher.getName())) {
                    continue;
                }
                if (curTeacher.getSubject().equals(lecture.getName())) {
                    teacher = curTeacher;
                    break;
                }
            }
            if (teacher != null) {
                break;
            }
            if (iLesson == lecLessons.size() - 1) {
                break;
            }
            lecture = lecLessons.get(++iLesson);
        }
        if (teacher != null) {
            lecLessons.remove(lecture);
            TimeTable timeTable = new TimeTable(lecture, teacher, room);
            subjDaySchedule.add(timeTable);
            validTeachers.remove(teacher);
            validLectureRooms.remove(room);
        }
        return false;
    }

    private static Map<String, Map<Integer, List<TimeTable>>> getTimetable1(List<Lesson> lessons, List<Teacher> teachers, List<Room> rooms, Map<String, Integer> schedule) {
        Map<String, Map<Integer, List<TimeTable>>> timetable = new HashMap<>();
        List<Lesson> prLessons = lessons.stream().filter(l -> l.isPractice).collect(Collectors.toList());
        List<Lesson> lecLessons = lessons.stream().filter(l -> !l.isPractice).collect(Collectors.toList());
        List<Map.Entry<String, Integer>> sortedDays = schedule.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedDays.size(); i++) {
            Map.Entry<String, Integer> day = sortedDays.get(i);
            Integer subjectsNum = day.getValue();
            Map<Integer, List<TimeTable>> daySchedule = new HashMap<>();
            timetable.put(day.getKey(), daySchedule);
            for (int j = 0; j < subjectsNum; j++) {
                List<TimeTable> subjDaySchedule = new ArrayList<>();
                daySchedule.put(j + 1, subjDaySchedule);
                List<Room> validPracticeRooms = rooms.stream().filter(r -> r.isPractice).collect(Collectors.toList());
                List<Room> validLectureRooms = rooms.stream().filter(r -> !r.isPractice).collect(Collectors.toList());
                List<Teacher> validTeachers = new ArrayList<>(teachers);
                addLectures(lecLessons, subjDaySchedule, validLectureRooms, validTeachers);
                Teacher teacher;
                int iLesson;
                Lesson lecture;
                // add practices
                validPracticeRooms.addAll(validLectureRooms);
                for (int k = 0; k < validPracticeRooms.size(); k++) {
                    // find teacher
                    teacher = null;
                    iLesson = 0;
                    if (prLessons.isEmpty()) {
                        break;
                    }
                    lecture = prLessons.get(iLesson);
                    while (true) {
                        for (int ii = 0; ii < validTeachers.size(); k++) {
                            Teacher curTeacher = validTeachers.get(ii);
                            if (curTeacher.getSubject().equals(lecture.getName())) {
                                teacher = curTeacher;
                                break;
                            }
                        }
                        if (teacher != null) {
                            break;
                        }
                        if (iLesson == prLessons.size() - 1) {
                            break;
                        }
                        lecture = prLessons.get(++iLesson);
                    }
                    if (teacher != null) {
                        prLessons.remove(lecture);
                        TimeTable timeTable = new TimeTable(lecture, teacher, validPracticeRooms.get(k));
                        subjDaySchedule.add(timeTable);
                        validTeachers.remove(teacher);
                        validPracticeRooms.remove(k);
                    }
                }
            }
        }
        if (!lecLessons.isEmpty() || !prLessons.isEmpty()) {
            throw new IllegalArgumentException("It is not possible to create a timetable");
        }
        return timetable;
    }

}
