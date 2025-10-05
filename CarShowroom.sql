-- =========================================================
-- DATABASE: QuanLyShowroomXe
-- Mục đích: Quản lý xe, loại xe, mô tả cá nhân hoá, khách hàng
-- và thông tin admin quản trị website
-- =========================================================

-- Xoá database cũ nếu tồn tại
DROP DATABASE IF EXISTS QuanLyShowroomXe;

-- Tạo database mới
CREATE DATABASE QuanLyShowroomXe CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE QuanLyShowroomXe;

-- =========================================================
-- 1. Bảng LoaiXe: Quản lý loại xe (Sedan, SUV, Điện, ...).
-- =========================================================
CREATE TABLE LoaiXe (
    loai_id INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai VARCHAR(100) NOT NULL
);

-- =========================================================
-- 2. Bảng Xe: Thông tin chung về xe trong showroom.
-- Liên kết với LoaiXe.
-- =========================================================
CREATE TABLE Xe (
    xe_id INT AUTO_INCREMENT PRIMARY KEY,
    ten_xe VARCHAR(100) NOT NULL,
    gia DECIMAL(15,2) NOT NULL, -- giá bán
    nam_sx YEAR,                -- năm sản xuất
    hang_sx VARCHAR(100),       -- hãng sản xuất
    loai_id INT,
    FOREIGN KEY (loai_id) REFERENCES LoaiXe(loai_id)
);

-- =========================================================
-- 3. Bảng MoTaDanhMuc: Danh mục mô tả xe (Động cơ, Nội thất...).
-- =========================================================
CREATE TABLE MoTaDanhMuc (
    mota_id INT AUTO_INCREMENT PRIMARY KEY,
    ten_mota VARCHAR(100) NOT NULL
);

-- =========================================================
-- 4. Bảng XeMoTa: Cá nhân hoá mô tả cho từng xe.
-- Mỗi xe có thể có nhiều mục mô tả, và nội dung chi tiết.
-- =========================================================
CREATE TABLE XeMoTa (
    xe_mota_id INT AUTO_INCREMENT PRIMARY KEY,
    xe_id INT,
    mota_id INT,
    noi_dung TEXT,
    FOREIGN KEY (xe_id) REFERENCES Xe(xe_id),
    FOREIGN KEY (mota_id) REFERENCES MoTaDanhMuc(mota_id)
);

-- =========================================================
-- 5. Bảng KhachHang: Thông tin khách hàng để lại liên hệ tư vấn.
-- =========================================================
CREATE TABLE KhachHang (
    khach_id INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(100) NOT NULL,
    so_dien_thoai VARCHAR(20),
    email VARCHAR(100),
    ghi_chu TEXT,
    ngay_dangky TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================================
-- 6. Bảng TuVanXe: Liên kết khách hàng nào quan tâm đến xe nào.
-- Quan hệ N-N giữa KhachHang và Xe.
-- =========================================================
CREATE TABLE TuVanXe (
    tuvan_id INT AUTO_INCREMENT PRIMARY KEY,
    khach_id INT,
    xe_id INT,
    FOREIGN KEY (khach_id) REFERENCES KhachHang(khach_id),
    FOREIGN KEY (xe_id) REFERENCES Xe(xe_id)
);

-- =========================================================
-- 7. Bảng Admin: Quản trị viên hệ thống (đăng nhập vào trang Admin).
-- Lưu mật khẩu dạng hash (không lưu plain text).
-- =========================================================
CREATE TABLE Admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL, -- lưu hash (bcrypt/argon2)
    ho_ten VARCHAR(100),
    email VARCHAR(100),
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================================
-- 8. Index để tăng tốc tìm kiếm.
-- =========================================================
CREATE INDEX idx_xe_loai ON Xe(loai_id);
CREATE INDEX idx_tuvan_khach ON TuVanXe(khach_id);
CREATE INDEX idx_tuvan_xe ON TuVanXe(xe_id);

-- =========================================================
-- 9. Dữ liệu mẫu
-- =========================================================

-- Thêm loại xe mẫu
INSERT INTO LoaiXe (ten_loai) VALUES 
('Sedan'),
('SUV'),
('Điện');

-- Thêm xe mẫu
INSERT INTO Xe (ten_xe, gia, nam_sx, hang_sx, loai_id) VALUES
('Toyota Camry', 1200000000, 2023, 'Toyota', 1),
('Hyundai SantaFe', 1350000000, 2022, 'Hyundai', 2),
('VinFast VF8', 950000000, 2023, 'VinFast', 3);

-- Thêm danh mục mô tả
INSERT INTO MoTaDanhMuc (ten_mota) VALUES
('Động cơ'),
('Ngoại thất'),
('Nội thất'),
('Công nghệ'),
('An toàn');

-- Thêm mô tả cho xe
INSERT INTO XeMoTa (xe_id, mota_id, noi_dung) VALUES
(1, 1, 'Động cơ 2.5L, 4 xy-lanh thẳng hàng, hộp số tự động 8 cấp'),
(1, 3, 'Ghế da cao cấp, màn hình giải trí 9 inch'),
(2, 1, 'Động cơ Diesel 2.2L, hộp số tự động 6 cấp'),
(2, 2, 'Thiết kế mạnh mẽ, gầm cao'),
(3, 1, 'Động cơ điện 150kW, pin 82kWh'),
(3, 4, 'Hỗ trợ kết nối điện thoại, trợ lý ảo AI');

-- Thêm khách hàng mẫu
INSERT INTO KhachHang (ho_ten, so_dien_thoai, email, ghi_chu) VALUES
('Nguyen Van A', '0901234567', 'a@example.com', 'Quan tâm đến Toyota Camry'),
('Tran Thi B', '0912345678', 'b@example.com', 'Quan tâm đến xe điện VinFast');

-- Khách hàng quan tâm đến xe nào
INSERT INTO TuVanXe (khach_id, xe_id) VALUES
(1, 1),
(2, 3);

-- Thêm admin mẫu (mật khẩu giả sử là "123456" nhưng đã mã hoá)
INSERT INTO Admin (username, password_hash, ho_ten, email) VALUES
('admin', '$2y$10$abcdefghijk1234567890hashcuabcrypt', 'Quản trị viên', 'admin@example.com');
