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