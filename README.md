# 1. List, Set, Map (Collections Framework)

## List:

- Danh sách có thứ tự, cho phép trùng lặp (ví dụ: ArrayList, LinkedList).
- Thực tế: Dùng để lưu danh sách nhân viên, đơn hàng trong ứng dụng.
- Đặc điểm: Truy cập nhanh theo index (get(int index)), phù hợp khi cần duyệt tuần tự.

## Set:

- Tập hợp không có thứ tự, không cho phép trùng lặp (ví dụ: HashSet, TreeSet).
- Thực tế: Lưu danh sách ID unique hoặc email trong hệ thống.
- Đặc điểm: TreeSet tự động sắp xếp, HashSet tối ưu tìm kiếm.

## Map:

- Tập hợp key-value, không trùng key (ví dụ: HashMap, TreeMap).
- Thực tế: Lưu cấu hình (key = "db.url", value = "jdbc:mysql://...") hoặc cache dữ liệu.
- Đặc điểm: Truy xuất nhanh qua key (get(key)).

### Bài tập

Viết chương trình quản lý danh sách sinh viên:

- Dùng List để lưu tất cả sinh viên (tên, tuổi).
- Dùng Set để lưu danh sách mã sinh viên (ID) unique.
- Dùng Map để ánh xạ ID với điểm số của sinh viên.
- In toàn bộ thông tin ra màn hình.

# 2. Iterator

- Đối tượng cho phép duyệt qua các phần tử của collection (List, Set, Map.entrySet()).

## Phương thức chính:

- hasNext(): Kiểm tra còn phần tử tiếp theo không.
- next(): Lấy phần tử tiếp theo.
- remove(): Xóa phần tử hiện tại (tùy chọn).

## Thực tế: Dùng khi cần duyệt và xử lý dữ liệu lớn mà không muốn tải hết vào bộ nhớ.

- Ứng dụng trong Spring
- Duyệt danh sách entity từ repository.findAll() khi xử lý batch.

# 3. For-each

- Cú pháp ngắn gọn (for (Type item : collection)) để duyệt qua collection hoặc mảng.
- Đặc điểm: Không cần chỉ số (index) hay Iterator rõ ràng, dựa trên giao thức Iterable.
- Thực tế: Dùng để in log, tính tổng, hoặc xử lý nhanh danh sách.
- Ứng dụng trong Spring
- Duyệt List<User> để gửi email thông báo: for (User user : users) { sendEmail(user); }.

### Bài tập

Dựa trên bài tập 1:

- Dùng for-each để tính tổng điểm trung bình của sinh viên từ Map.
- In danh sách sinh viên có điểm trên trung bình.

# 4. Map, Filter, Collect (Stream API)

## Stream: Luồng xử lý dữ liệu theo kiểu pipeline, từ Java 8.

### Map: Chuyển đổi từng phần tử (stream.map(x -> transform(x))).

- Thực tế: Chuyển List<User> thành List<String> (tên).

### Filter: Lọc phần tử theo điều kiện (stream.filter(x -> condition)).

- Thực tế: Lọc danh sách nhân viên trên 25 tuổi.

### Collect: Thu thập kết quả thành collection (stream.collect(Collectors.toList())).

- Thực tế: Gộp kết quả lọc thành List hoặc Set.

### Ứng dụng trong Spring

- Trong @Service: users.stream().filter(u -> u.isActive()).map(User::getName).collect(Collectors.toList()).

### Bài tập

Dựa trên bài tập 1:

- Dùng Stream để lọc sinh viên có điểm trên 8.0.
- Chuyển danh sách thành List<String> chỉ chứa tên sinh viên.
- Thu thập kết quả và in ra.

## 5. Optional

Giải thích

- Optional: Lớp từ Java 8 để tránh NullPointerException, đại diện cho giá trị có thể null.
- Phương thức chính:
  of(value), ofNullable(value): Tạo Optional.
  isPresent(): Kiểm tra có giá trị không.
  orElse(defaultValue): Lấy giá trị hoặc mặc định.
  map(transform): Chuyển đổi giá trị nếu có.
- Thực tế: Xử lý dữ liệu từ database hoặc API khi giá trị có thể null.
- Ứng dụng trong Spring
  Trong repository.findById(id) trả về Optional<User>.
  Bài tập

Dựa trên bài tập 1:

Viết phương thức tìm sinh viên theo ID từ Map, trả về Optional<Student>.
Xử lý trường hợp không tìm thấy (in "Not found" hoặc trả về sinh viên mặc định).

## 6. Annotation

- Giải thích Annotation: Metadata gắn vào code (@Override, @Deprecated), từ Java 5.
- Cách dùng: Đánh dấu, cung cấp thông tin cho compiler, runtime, hoặc framework.
- Thực tế: Dùng để cấu hình, validate, hoặc tạo custom logic (như logging).
- Ứng dụng trong Spring
  @Autowired, @Entity, @GetMapping là annotation cốt lõi.

Bài tập
Tạo annotation @LogTime để ghi log thời gian thực thi của phương thức.
Áp dụng cho phương thức tính điểm trung bình trong bài tập 3.
In thời gian thực thi (dùng System.currentTimeMillis()).

## 7. Reflection

- Giải thích
  Reflection: Cơ chế kiểm tra và sửa đổi cấu trúc/lớp tại runtime (java.lang.reflect).
- Phương thức chính:
  Class.forName(): Lấy Class object.
  getDeclaredFields(), getDeclaredMethods(): Lấy thông tin field/method.
  invoke(): Gọi phương thức động.
  Thực tế: Dùng để xây dựng framework, debug, hoặc xử lý generic type.
- Ứng dụng trong Spring
  Spring dùng reflection để quét @Component, inject dependency, hoặc map entity.

Bài tập
Viết chương trình dùng reflection để:
Lấy tất cả field của lớp Student.
Gọi phương thức toString() trên instance Student động.
In thông tin field và kết quả toString().