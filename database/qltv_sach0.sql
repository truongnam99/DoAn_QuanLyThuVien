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
INSERT INTO `sach` VALUES ('ST000001','Bộ giáo dục và đào tạo','Toán 11','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000002','Bộ giáo dục và đào tạo','Toán 12','Toán học','Bộ giáo dục và đào tạo','2019-01-05',23000,'Trống','2013-05-01'),('ST000003','Nhiều tác giả','Văn 11','Văn học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01'),('ST000004','Nhiều tác giả','Toán cao cấp','Toán học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01'),('ST000005','Bộ giáo dục và đào tạo','Toán 10','Toán học','Bộ giáo dục và đào tạo','2019-01-05',20000,'Trống','2013-05-01'),('ST000006','Nhiều tác giả','Toán cao cấp','Toán học','Giáo dục','2015-02-02',23000,'Trống','2012-01-01');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-27 10:25:33
