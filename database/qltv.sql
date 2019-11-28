-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: qltv
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `MaDocGia` varchar(8) NOT NULL,
  `TenDocGia` varchar(45) NOT NULL,
  `MaLoaiDocGia` varchar(8) NOT NULL,
  `LopMon` varchar(30) NOT NULL,
  `NgaySinh` date NOT NULL,
  `Std` varchar(13) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`MaDocGia`),
  KEY `MaLoaiDocGia_idx` (`MaLoaiDocGia`),
  CONSTRAINT `FK_DOCGIA_LOAIDOCGIA_MLDG` FOREIGN KEY (`MaLoaiDocGia`) REFERENCES `loaidocgia` (`MaLoaiDocGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES ('DG000001','Trương Hoàng Nam','LDG00001','12A1','1999-01-25','0949709036',NULL),('DG000002','Phạm Tuấn Anh','LDG00001','12A1','1999-01-25','0949709036',''),('dg000005','Phạm Tuấn Anh','LDG00001','12A2','1999-02-16','09484886','null'),('DG01','Lê Minh Phúc','LDG00001','12A2','1999-02-16','09484886','');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidocgia`
--

DROP TABLE IF EXISTS `loaidocgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaidocgia` (
  `MaLoaiDocGia` varchar(8) NOT NULL,
  `TenDocGia` varchar(45) NOT NULL,
  PRIMARY KEY (`MaLoaiDocGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidocgia`
--

LOCK TABLES `loaidocgia` WRITE;
/*!40000 ALTER TABLE `loaidocgia` DISABLE KEYS */;
INSERT INTO `loaidocgia` VALUES ('LDG00001','Học Sinh'),('LDG00002','Giáo Viên');
/*!40000 ALTER TABLE `loaidocgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanlymuonsach`
--

DROP TABLE IF EXISTS `quanlymuonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanlymuonsach` (
  `MaDocGia` varchar(8) NOT NULL,
  `MaSach` varchar(8) NOT NULL,
  `NgayMuon` date NOT NULL,
  `NgayTra` date NOT NULL,
  `TrangThai` tinyint(4) NOT NULL,
  PRIMARY KEY (`MaDocGia`,`MaSach`),
  KEY `FK_QUANLYMUONSACH_SACH_MS_idx` (`MaSach`),
  CONSTRAINT `FK_QUANLYMUONSACH_DOCGIA_MDG` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`MaDocGia`),
  CONSTRAINT `FK_QUANLYMUONSACH_SACH_MS` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanlymuonsach`
--

LOCK TABLES `quanlymuonsach` WRITE;
/*!40000 ALTER TABLE `quanlymuonsach` DISABLE KEYS */;
INSERT INTO `quanlymuonsach` VALUES ('DG000001','ST000001','2019-11-05','2019-11-05',-1),('DG000001','ST000002','2019-11-05','2019-11-01',-1),('DG000001','ST000003','2019-11-05','2019-11-01',0),('DG000001','ST000005','2019-11-05','2019-11-01',-1),('DG000002','ST000003','2019-11-05','2019-11-10',-1),('DG000002','ST000004','2019-11-05','2019-11-10',-1),('DG000002','ST000005','2019-11-05','2019-11-10',-1);
/*!40000 ALTER TABLE `quanlymuonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanlytienphat`
--

DROP TABLE IF EXISTS `quanlytienphat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanlytienphat` (
  `MaLanPhat` varchar(8) NOT NULL,
  `SoTien` int(11) DEFAULT NULL,
  `MaDocGia` varchar(8) NOT NULL,
  `NgayPhat` date DEFAULT NULL,
  `LyDo` longtext,
  PRIMARY KEY (`MaLanPhat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanlytienphat`
--

LOCK TABLES `quanlytienphat` WRITE;
/*!40000 ALTER TABLE `quanlytienphat` DISABLE KEYS */;
/*!40000 ALTER TABLE `quanlytienphat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quydinh`
--

DROP TABLE IF EXISTS `quydinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quydinh` (
  `MaQuyDinh` varchar(8) NOT NULL,
  `TenQuyDinh` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaQuyDinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quydinh`
--

LOCK TABLES `quydinh` WRITE;
/*!40000 ALTER TABLE `quydinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `quydinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `MaSach` varchar(8) NOT NULL,
  `TacGia` varchar(500) DEFAULT NULL,
  `TenSach` varchar(500) NOT NULL,
  `TheLoai` varchar(500) DEFAULT NULL,
  `NhaXuatBan` varchar(200) DEFAULT NULL,
  `NgayNhap` date NOT NULL,
  `GiaSach` int(11) NOT NULL,
  `TrangThai` varchar(15) NOT NULL,
  `NamXuatBan` date DEFAULT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('ST000001','Bộ giáo dục và đào tạo','Toán 11','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000002','Bộ giáo dục và đào tạo','Toán 12','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000003','Nhiều tác giả','Văn 11','Văn học','Giáo dục','2015-02-02',23000,'Đang được mượn','2012-01-01'),('ST000004','Nhiều tác giả','Toán cao cấp','Toán học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01'),('ST000005','Bộ giáo dục và đào tạo','Toán 10','Toán học','Bộ giáo dục và đào tạo','2019-01-05',20000,'Đang được mượn','2013-05-01');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sachthanhly`
--

DROP TABLE IF EXISTS `sachthanhly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sachthanhly` (
  `MaSach` varchar(8) NOT NULL,
  `MaThanhLy` varchar(8) NOT NULL,
  `TacGia` varchar(500) DEFAULT NULL,
  `TenSach` varchar(500) DEFAULT NULL,
  `TheLoai` varchar(500) DEFAULT NULL,
  `NhaXuatBan` varchar(200) DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `GiaSach` int(11) DEFAULT NULL,
  `TrangThai` varchar(45) DEFAULT NULL,
  `NamXuatBan` date DEFAULT NULL,
  PRIMARY KEY (`MaSach`),
  KEY `fk_thanhly_matl_idx` (`MaThanhLy`),
  CONSTRAINT `fk_thanhly_matl` FOREIGN KEY (`MaThanhLy`) REFERENCES `thanhly` (`MaThanhLy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sachthanhly`
--

LOCK TABLES `sachthanhly` WRITE;
/*!40000 ALTER TABLE `sachthanhly` DISABLE KEYS */;
INSERT INTO `sachthanhly` VALUES ('ST000001','8','Bộ giáo dục và đào tạo','Toán 11','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000002','8','Bộ giáo dục và đào tạo','Toán 12','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000004','1','Nhiều tác giả','Toán cao cấp','Toán học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01'),('ST000005','3','Bộ giáo dục và đào tạo','Toán 10','Toán học','Bộ giáo dục và đào tạo','2019-01-05',20000,'Đang được mượn','2013-05-01'),('ST000006','2','Nhiều tác giả','Toán cao cấp','Toán học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01');
/*!40000 ALTER TABLE `sachthanhly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `MaTaiKhoan` varchar(8) NOT NULL,
  `TenTaiKhoan` varchar(45) DEFAULT NULL,
  `MatKhau` varchar(45) DEFAULT NULL,
  `TenNhanVien` varchar(45) DEFAULT NULL,
  `LoaiTaiKhoan` varchar(45) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`MaTaiKhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('admin','admin','admin','admin','Quản trị hệ thống',''),('TK01','hoangnam','hoangnam','Hoang Nam','Thủ thư','');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhly`
--

DROP TABLE IF EXISTS `thanhly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhly` (
  `MaThanhLy` varchar(8) NOT NULL,
  `NgayThanhLy` date DEFAULT NULL,
  `LyDo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`MaThanhLy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhly`
--

LOCK TABLES `thanhly` WRITE;
/*!40000 ALTER TABLE `thanhly` DISABLE KEYS */;
INSERT INTO `thanhly` VALUES ('0','2019-11-27','khong'),('1','2019-11-27','a'),('2','2019-11-27','test'),('3','2019-11-27',''),('4','2019-11-27',''),('5','2019-11-27',''),('6','2019-11-27',''),('7','2019-11-27',''),('8','2019-11-27','test');
/*!40000 ALTER TABLE `thanhly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtinquydinh`
--

DROP TABLE IF EXISTS `thongtinquydinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongtinquydinh` (
  `MaQuyDinh` varchar(8) NOT NULL,
  `GiaTri` int(11) NOT NULL,
  PRIMARY KEY (`MaQuyDinh`,`GiaTri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtinquydinh`
--

LOCK TABLES `thongtinquydinh` WRITE;
/*!40000 ALTER TABLE `thongtinquydinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `thongtinquydinh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 13:23:35
