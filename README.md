# 🚗 Showroom Car Website

Dự án xây dựng một hệ thống **website showroom ô tô** với backend bằng **Java Spring Boot**, frontend bằng **ReactJS**, và cơ sở dữ liệu **MySQL**.

## 📌 Tính năng chính
- 👤 Quản lý người dùng (đăng nhập / đăng ký / phân quyền).
- 🚘 Quản lý xe (thêm, sửa, xóa, tìm kiếm).
- 📸 Hiển thị chi tiết sản phẩm (hình ảnh, mô tả, thông số).
- 🛒 Giỏ hàng và đặt mua xe.
- 📊 Trang quản trị (Admin) quản lý dữ liệu.
- 🔎 Tìm kiếm, lọc xe theo hãng, giá, loại xe.

## 🏗️ Kiến trúc hệ thống
- **Frontend**: ReactJS + TailwindCSS/Bootstrap  
- **Backend**: Java Spring Boot (RESTful API)  
- **Database**: MySQL  
- **Authentication**: JWT  

```mermaid
flowchart LR
    A[ReactJS Frontend] -->|REST API| B[Java Spring Boot Backend]
    B --> C[(MySQL Database)]
