import java.util.*;

public class Main {
    static boolean compare(int a, int b) {
        return a > b;
    }

    public static void main(String[] args) {
        /*
        List: Danh sách có thứ tự, cho phép trùng lặp (ví dụ: ArrayList, LinkedList).
        Thực tế: Dùng để lưu danh sách nhân viên, đơn hàng trong ứng dụng.
        Đặc điểm: Truy cập nhanh theo index (get(int index)), phù hợp khi cần duyệt tuần tự.

        Set: Tập hợp không có thứ tự, không cho phép trùng lặp (ví dụ: HashSet, TreeSet).
        Thực tế: Lưu danh sách ID unique hoặc email trong hệ thống.
        Đặc điểm: TreeSet tự động sắp xếp, HashSet tối ưu tìm kiếm.

        Map: Tập hợp key-value, không trùng key (ví dụ: HashMap, TreeMap).
        Thực tế: Lưu cấu hình (key = "db.url", value = "jdbc:mysql://...") hoặc cache dữ liệu.
        Đặc điểm: Truy xuất nhanh qua key (get(key)).
        */

        List<Student> studentList = new ArrayList<>();
        Set<String> studentIds = new HashSet<>();
        Map<String, Double> studentScores = new HashMap<>();

        addStudent(studentList, studentIds, studentScores, "1", "hieupv", 22, 5.0);
        addStudent(studentList, studentIds, studentScores, "2", "hieupv", 22, 5.0);
        addStudent(studentList, studentIds, studentScores, "3", "hieupv", 22, 5.0);
        printStudentInfo(studentList, studentScores);

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

    public static void printStudentInfo(List<Student> studentList, Map<String, Double> studentScores) {
        for (Student student : studentList) {
            System.out.println(student + ", Score: " + studentScores.get(student.getId()));
        }
    }
}