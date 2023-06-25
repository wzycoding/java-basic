package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student(1, 101),
                new Student(1, 102),
                new Student(2, 201),
                new Student(2, 202),
                new Student(2, 203)
        );

        List<Integer> studentIdList = studentList.stream()
                .map(Student::getStudentId).collect(Collectors.toList());

        List<Integer> studentIdList1 = studentList.stream()
                .collect(Collectors.mapping(Student::getStudentId,
                        Collectors.toList()));

        System.out.println(studentIdList);

        System.out.println(studentIdList1);
    }

    static class Student {
        private int classId;
        private int studentId;

        public Student(int classId, int studentId) {
            this.classId = classId;
            this.studentId = studentId;
        }

        public int getClassId() {
            return classId;
        }

        public int getStudentId() {
            return studentId;
        }
    }
}

