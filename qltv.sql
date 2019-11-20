-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2019 at 03:31 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltv`
--

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE `docgia` (
  `MaDocGia` varchar(8) NOT NULL,
  `TenDocGia` varchar(45) NOT NULL,
  `MaLoaiDocGia` varchar(8) NOT NULL,
  `LopMon` varchar(30) NOT NULL,
  `NgaySinh` date NOT NULL,
  `Std` varchar(13) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`MaDocGia`, `TenDocGia`, `MaLoaiDocGia`, `LopMon`, `NgaySinh`, `Std`, `Email`) VALUES
('DG000001', 'Trương Hoàng Nam', 'LDG00001', '12A1', '1999-01-25', '0949709036', NULL),
('DG000002', 'Lê Minh Phúc', 'LDG00002', 'Toán', '1999-01-25', '0949709036', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `loaidocgia`
--

CREATE TABLE `loaidocgia` (
  `MaLoaiDocGia` varchar(8) NOT NULL,
  `TenDocGia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaidocgia`
--

INSERT INTO `loaidocgia` (`MaLoaiDocGia`, `TenDocGia`) VALUES
('LDG00001', 'Học Sinh'),
('LDG00002', 'Giáo Viên');

-- --------------------------------------------------------

--
-- Table structure for table `quanlymuonsach`
--

CREATE TABLE `quanlymuonsach` (
  `MaDocGia` varchar(8) NOT NULL,
  `MaSach` varchar(8) NOT NULL,
  `NgayMuon` date NOT NULL,
  `NgayTra` date NOT NULL,
  `TrangThai` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quanlymuonsach`
--

INSERT INTO `quanlymuonsach` (`MaDocGia`, `MaSach`, `NgayMuon`, `NgayTra`, `TrangThai`) VALUES
('DG000001', 'ST000001', '2019-11-05', '2019-11-05', 0);

-- --------------------------------------------------------

--
-- Table structure for table `quanlytienphat`
--

CREATE TABLE `quanlytienphat` (
  `MaLanPhat` varchar(8) NOT NULL,
  `SoTien` int(11) DEFAULT NULL,
  `MaDocGia` varchar(8) NOT NULL,
  `NgayPhat` date DEFAULT NULL,
  `LyDo` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `quydinh`
--

CREATE TABLE `quydinh` (
  `MaQuyDinh` varchar(8) NOT NULL,
  `TenQuyDinh` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(8) NOT NULL,
  `MaTacGia` varchar(8) NOT NULL,
  `TenSach` varchar(45) DEFAULT NULL,
  `MaTheLoai` varchar(8) DEFAULT NULL,
  `NhaXuatBan` varchar(45) DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `GiaSach` int(11) DEFAULT NULL,
  `TrangThai` tinyint(4) DEFAULT NULL,
  `NamXuatBan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `MaTacGia`, `TenSach`, `MaTheLoai`, `NhaXuatBan`, `NgayNhap`, `GiaSach`, `TrangThai`, `NamXuatBan`) VALUES
('ST000001', 'TG000001', 'Toán 11', 'TL000001', 'Bộ giáo dục và đào tạo', '2019-01-05', 23000, 1, '2013-05-01'),
('ST000002', 'TG000002', 'Toán 12', 'TL000001', 'Bộ giáo dục và đào tạo', '2019-01-05', 23000, 1, '2013-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTacGia` varchar(8) NOT NULL,
  `TenTacGia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`) VALUES
('TG000001', 'Bộ Giáo Dục'),
('TG000002', 'Tony'),
('TG000003', 'Nguyễn Nhật Ánh'),
('TG000004', 'Thạch Lam'),
('TG000005', 'Nam Cao'),
('TG000006', 'Hồ Chí Minh'),
('TG000007', 'Hoài Thanh'),
('TG000008', 'Xuân Quỳnh'),
('TG000009', 'Tô Hoài');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTaiKhoan` varchar(8) NOT NULL,
  `TenTaiKhoan` varchar(45) DEFAULT NULL,
  `MatKhau` varchar(45) DEFAULT NULL,
  `TenNhanVien` varchar(45) DEFAULT NULL,
  `LoaiTaiKhoan` varchar(45) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `MaTheLoai` varchar(8) NOT NULL,
  `TenTheLoai` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MaTheLoai`, `TenTheLoai`) VALUES
('TL000001', 'Toán'),
('TL000002', 'Sinh'),
('TL000003', 'Lý'),
('TL000004', 'Hóa'),
('TL000005', 'Anh'),
('TL000006', 'Sử'),
('TL000007', 'Văn');

-- --------------------------------------------------------

--
-- Table structure for table `thongtinquydinh`
--

CREATE TABLE `thongtinquydinh` (
  `MaQuyDinh` varchar(8) NOT NULL,
  `GiaTri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`MaDocGia`),
  ADD KEY `MaLoaiDocGia_idx` (`MaLoaiDocGia`);

--
-- Indexes for table `loaidocgia`
--
ALTER TABLE `loaidocgia`
  ADD PRIMARY KEY (`MaLoaiDocGia`);

--
-- Indexes for table `quanlymuonsach`
--
ALTER TABLE `quanlymuonsach`
  ADD PRIMARY KEY (`MaDocGia`,`MaSach`),
  ADD KEY `FK_QUANLYMUONSACH_SACH_MS_idx` (`MaSach`);

--
-- Indexes for table `quanlytienphat`
--
ALTER TABLE `quanlytienphat`
  ADD PRIMARY KEY (`MaLanPhat`),
  ADD KEY `FK_QUANLYTIENPHAT_DOCGIA_MDG_idx` (`MaDocGia`);

--
-- Indexes for table `quydinh`
--
ALTER TABLE `quydinh`
  ADD PRIMARY KEY (`MaQuyDinh`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `FK_SACH_TACGIA_MTG_idx` (`MaTacGia`),
  ADD KEY `FK_SACH_THELOAI_MTL_idx` (`MaTheLoai`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTacGia`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTaiKhoan`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTheLoai`);

--
-- Indexes for table `thongtinquydinh`
--
ALTER TABLE `thongtinquydinh`
  ADD PRIMARY KEY (`MaQuyDinh`,`GiaTri`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `docgia`
--
ALTER TABLE `docgia`
  ADD CONSTRAINT `FK_DOCGIA_LOAIDOCGIA_MLDG` FOREIGN KEY (`MaLoaiDocGia`) REFERENCES `loaidocgia` (`MaLoaiDocGia`);

--
-- Constraints for table `quanlymuonsach`
--
ALTER TABLE `quanlymuonsach`
  ADD CONSTRAINT `FK_QUANLYMUONSACH_DOCGIA_MDG` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`MaDocGia`),
  ADD CONSTRAINT `FK_QUANLYMUONSACH_SACH_MS` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Constraints for table `quanlytienphat`
--
ALTER TABLE `quanlytienphat`
  ADD CONSTRAINT `FK_QUANLYTIENPHAT_DOCGIA_MDG` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`MaDocGia`);

--
-- Constraints for table `quydinh`
--
ALTER TABLE `quydinh`
  ADD CONSTRAINT `FK_QUYDINH_THONGTINQUYDINH_MQD` FOREIGN KEY (`MaQuyDinh`) REFERENCES `thongtinquydinh` (`MaQuyDinh`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `FK_SACH_TACGIA_MTG` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`MaTacGia`),
  ADD CONSTRAINT `FK_SACH_THELOAI_MTL` FOREIGN KEY (`MaTheLoai`) REFERENCES `theloai` (`MaTheLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
