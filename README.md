# 🚗 Showroom Car Website

Dự án xây dựng một hệ thống **website showroom ô tô** với backend bằng **Java Spring Boot**, frontend bằng **ReactJS**, và cơ sở dữ liệu **MySQL**.

---

## 📌 Tính năng chính

### 👤 Người dùng
- Xem danh sách các mẫu xe showroom hiện có.  
- Xem chi tiết xe: hình ảnh, thông số kỹ thuật, màu sắc, phiên bản...  
- Liên hệ trực tiếp với showroom thông qua form liên hệ.  
  - Thông tin liên hệ sẽ được gửi đến quản lý để xử lý.  
- Đặt lịch lái thử xe trực tuyến.  

### 🛠️ Quản lý (Admin)
- Quản lý sản phẩm (CRUD xe: thêm, sửa, xóa, cập nhật).  
- Chọn và gắn nhãn **sản phẩm nổi bật** để hiển thị ưu tiên.  
- Xem danh sách người dùng đã gửi thông tin liên hệ.  
  - Quản lý trạng thái liên hệ: `Đang chờ`, `Đã liên hệ`, ...  
- Quản lý lịch lái thử: xem, xác nhận, thay đổi trạng thái.  

---

## 🏗️ Kiến trúc hệ thống
- **Frontend**: ReactJS + Bootstrap  
- **Backend**: Java Spring Boot (RESTful API)  
- **Database**: MySQL  
- **Authentication**: JWT  

```mermaid
flowchart LR
    A[Người dùng (ReactJS)] -->|Yêu cầu| B[Java Spring Boot API]
    B --> C[(MySQL Database)]
    D[Quản lý (Admin Panel)] -->|CRUD / Quản lý| B
