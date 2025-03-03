import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static boolean compare(int a, int b) {
        return a > b;
    }

    public static void main(String[] args) {


        List<Student> studentList = new ArrayList<>();
        Set<String> studentIds = new HashSet<>();
        Map<String, Double> studentScores = new HashMap<>();

        // Thêm sinh viên
        addStudent(studentList, studentIds, studentScores, "S001", "Alice", 20, 8.5);
        addStudent(studentList, studentIds, studentScores, "S002", "Bob", 21, 7.8);
        addStudent(studentList, studentIds, studentScores, "S003", "Charlie", 22, 9.0);
        addStudent(studentList, studentIds, studentScores, "S004", "David", 19, 6.5);

        // In thông tin sinh viên trước khi xóa
        System.out.println("\nDanh sách sinh viên trước khi xóa:");
        printStudentInfo(studentList, studentScores);

        // Xóa sinh viên dưới 20 tuổi
        removeUnderageStudents(studentList, studentScores);

        // In lại danh sách sau khi xóa
        System.out.println("\nDanh sách sinh viên sau khi xóa:");
        printStudentInfo(studentList, studentScores);

        // Tính tổng điểm trung bình
        double averageScore = calculateAverageScore(studentScores);
        System.out.println("\nĐiểm trung bình của sinh viên: " + averageScore);

        // In danh sách sinh viên có điểm trên trung bình
        System.out.println("\nDanh sách sinh viên có điểm trên trung bình:");
        printAboveAverageStudents(studentList, studentScores, averageScore);

        // Lọc danh sách sinh viên có điểm trên 8.0 và chuyển thành danh sách tên
        List<String> highScoringStudents = studentList.stream()
                .filter(student -> studentScores.get(student.getId()) > 8.0)
                .map(Student::getName)
                .collect(Collectors.toList());
        // In danh sách sinh viên có điểm trên 8.0
        System.out.println("\nDanh sách sinh viên có điểm trên 8.0:");
        highScoringStudents.forEach(System.out::println);

        // Tìm sinh viên theo ID
        findStudentById(studentList, "S001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
    }

    private static void addStudent(List<Student> studentList, Set<String> studentIds, Map<String, Double> studentScores, String id, String name, int age, double score) {
        if (studentIds.contains(id)) {
            System.out.println("ID " + id + " already exists!");
            return;
        }

        Student student = new Student(id, name, age);
        studentList.add(student);
        studentIds.add(id);
        studentScores.put(id, score);
    }

    private static void printStudentInfo(List<Student> studentList, Map<String, Double> studentScores) {
        for (Student student : studentList) {
            System.out.println(student + ", Score: " + studentScores.get(student.getId()));
        }
    }

    private static void removeUnderageStudents(List<Student> studentList, Map<String, Double> studentScores) {
        Iterator<Student> iterator = studentList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAge() < 20) {
                iterator.remove();
                studentScores.remove(student.getId());
            }
        }
    }

    private static double calculateAverageScore(Map<String, Double> studentScores) {
        double totalScore = 0;
        for (Double score : studentScores.values()) {
            totalScore += score;
        }
        return studentScores.isEmpty() ? 0 : totalScore / studentScores.size();
    }

    private static void printAboveAverageStudents(List<Student> studentList, Map<String, Double> studentScores, double averageScore) {
        for (Student student : studentList) {
            double score = studentScores.get(student.getId());
            if (score > averageScore) {
                System.out.println(student + ", Score: " + score);
            }
        }
    }

    private static Optional<Student> findStudentById(List<Student> studentList, String id) {
        return studentList.stream().filter(student -> student.getId().equals(id)).findFirst();
    }
}